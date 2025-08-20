# **Singleton Design Pattern** 

**Here is the full collection of Singleton Design Pattern implementations in Java**, showing its different variations (**eager, lazy, synchronized, double-checked locking, serialization, reflection, enum, cloning**).

---

# Singleton Design Pattern in Java

### 🔹 What is Singleton?

* Singleton ensures that **only one instance** of a class exists in the JVM.
* It also provides a **global point of access** to that instance.

**Examples in real-world software:**

* **Logger class** (only one instance required to log messages across app).
* **Configuration class** (only one central config shared everywhere).
* **Database connection pool** (we don’t want multiple instances of pool manager).
* **Thread pool** (one global pool).
* **Caching service** (central cache instance shared across application).

---

# 1️⃣ Basic Singleton (Problematic Example)

```java
package com.amit.singleton.design.pattern;

public class SingleTon01 {
    public static SingleTon01 sc = new SingleTon01();
}

class Client {
    public static void main(String[] args) {
        System.out.println(SingleTon01.sc);   // same object
        System.out.println(new SingleTon01()); // new object (breaks singleton)
        System.out.println(new SingleTon01()); // new object (breaks singleton)
    }
}
```

### Explanation:

* Here, `sc` is a static variable.
* As long as the client uses `SingleTon01.sc`, only **one instance** is returned.
* But if client uses `new SingleTon01()`, it creates a **new object**, violating singleton.

---
### Output
```
com.amit.singleton.design.pattern.SingleTon01@5e91993f  
com.amit.singleton.design.pattern.SingleTon01@156643d4  
com.amit.singleton.design.pattern.SingleTon01@123a439b  

```


# 2️⃣ Eager Initialization

```java
package com.amit.singleton.design.pattern;

public class SingleTon02 {
    private static SingleTon02 st = new SingleTon02();

    private SingleTon02() { }

    public static SingleTon02 getInstance() {
        return st;
    }
}
```

### Explanation:

* Constructor is **private** → no other class can create instance.
* Instance is created eagerly at **class loading time**.
* **Problem**: If this object is never used, it still takes memory.

**Use case:** Best when we are sure the object will be used (like **logging**).

---

# 3️⃣ Lazy Initialization (Not Thread-Safe)

```java
package com.amit.singleton.design.pattern;

public class SingleTon03 {
    private static SingleTon03 st = null;

    private SingleTon03() { }

    public static SingleTon03 getInstance() {
        if (st == null) {
            st = new SingleTon03();
        }
        return st;
    }
}
```

### Explanation:

* Instance is created **only when needed**.
* Saves memory if not used.
* **Not thread safe** → two threads can create multiple instances.

* **How it works:**

  * The first thread checks `instance == null` and creates the object.
  * If multiple threads enter at the same time, they may all create objects.

* **Problem:**

  * **Not thread-safe**.
  * Multiple objects can be created, breaking the Singleton principle.

* **Use case:**

  * Suitable only for **single-threaded applications**.
---

# 4️⃣ Lazy Initialization with Thread Issue Demonstration

```java
package com.amit.singleton.design.pattern;

public class SingleTon033 {
    private static SingleTon033 st = null;

    private SingleTon033() {
        System.out.println("Instance created by " + Thread.currentThread().getName());
    }

    public static SingleTon033 getInstance() {
        if (st == null) {
            try { Thread.sleep(100); } catch (InterruptedException e) { }
            st = new SingleTon033(); // multiple threads can reach here
        }
        return st;
    }

    public static void main(String[] args) {
        Runnable task = () -> {
            SingleTon033 instance = SingleTon033.getInstance();
            System.out.println("Hash: " + instance.hashCode() +
                               " - Thread: " + Thread.currentThread().getName());
        };
        new Thread(task, "Thread-1").start();
        new Thread(task, "Thread-2").start();
    }
}
```
---
### Output
```
Instance created by Thread-2
Instance created by Thread-1
Instance hash: 137456794 - Thread: Thread-2
Instance hash: 1164760111 - Thread: Thread-1 

```

### Explanation:

* Two threads may create **different instances**.
* Demonstrates why synchronization is needed.

---

# 5️⃣ Thread-Safe Singleton (Synchronized Method)

```java
package com.amit.singleton.design.pattern;

public class SingleTon04 {
    private static SingleTon04 st = null;

    private SingleTon04() { }

    public static synchronized SingleTon04 getInstance() {
        if (st == null) {
            st = new SingleTon04();
        }
        return st;
    }
}
```

### Explanation:

* **How it works:**

  * `synchronized` ensures only **one thread enters** `getInstance()` at a time.
  * Safe from race conditions.

* **Advantage:**

  * **Thread-safe** — only one instance will be created.

* **Problem:**

  * **Performance overhead**:

    * Even after the instance is created, every call still requires acquiring the lock.

* **Use case:**

  * Good when **thread-safety** is required but performance is **not critical**.

---

# 6️⃣ Double-Checked Locking

```java
package com.amit.singleton.design.pattern;

public class SingleTon05 {
    private static volatile  SingleTon05 st = null;

    private SingleTon05() { }

    public static SingleTon05 getInstance() {
        if (st == null) {
            synchronized (SingleTon05.class) {
                if (st == null) {
                    st = new SingleTon05();
                }
            }
        }
        return st;
    }
}
```

### Explanation:


* **How it works:**

  * First check: avoids locking when the instance is already initialized.
  * Synchronization happens only once during initialization.
  * `volatile` ensures visibility of the instance across threads.

* **Advantage:**

  * **Thread-safe**.
  * **Faster** than synchronized method after initialization.

* **Problem:**

  * Slightly **complex code** compared to the others.

* **Use case:**

  * Best for **multi-threaded, high-performance applications**.
---

✅ **Summary Table**

| Approach               | Thread-Safe | Performance | When to Use                           |
| ---------------------- | ----------- | ----------- | ------------------------------------- |
| Non-Synchronized       | ❌ No        | ✅ Fast      | Single-threaded apps                  |
| Synchronized Method    | ✅ Yes       | ❌ Slow      | Multi-threaded apps, small scale      |
| Double-Checked Locking | ✅ Yes       | ✅ Fast      | Multi-threaded, high-performance apps |

---


# 7️⃣ Singleton with Serialization Issue

```java
package com.amit.singleton.design.pattern;

import java.io.Serializable;

public class SingleTon06 implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final SingleTon06 instance = new SingleTon06();

    private SingleTon06() { }

    public static SingleTon06 getInstance() {
        return instance;
    }
}
```

### Explanation:

* Serialization can create **new object** breaking singleton.
* Fix by overriding `readResolve()`.

# 8️⃣ Singleton with Serialization Issue Demonstration
---
```java
package com.amit.singleton.design.pattern;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SingleTon06Client {
	public static void main(String[] args) {
		SingleTon06 singleTon = SingleTon06.getInstance();
		try {
			serialization(singleTon);
			SingleTon06 single = deserilization("test.ser");
			System.out.println("HashCode : singleTon : "+singleTon.hashCode());
			System.out.println("HashCode : single : "+single.hashCode());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void serialization(SingleTon06 singleTon) throws IOException {
		FileOutputStream outputStream = new FileOutputStream("test.ser");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
		objectOutputStream.writeObject(singleTon);
		System.out.println("Serialization has been done!!!");
		outputStream.close();
	}
	
	public static SingleTon06 deserilization(String fileName) throws IOException, ClassNotFoundException {
		FileInputStream fileInputStream = new FileInputStream(fileName);
		ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
		SingleTon06 single = (SingleTon06)inputStream.readObject();
		return single;
	}
}
```
---
### Output

```
Serialization has been done!!!  
HashCode : singleTon : 589431969  
HashCode : single : 1078694789  
```

### Solution
```
So it destroys the singleton pattern.  
To overcome this scenario all we need to do it provide the implementation of readResolve() method.  
In serialized class
```
# 9️⃣ Singleton with Reflection Issue

```java
package com.amit.singleton.design.pattern;

import java.lang.reflect.Constructor;

public class SingleTon07Client {
    public static void main(String[] args) {
        SingleTon06 singleOne = SingleTon06.getInstance();
        SingleTon06 singleTwo = null;

        try {
            Constructor<?>[] constructors = SingleTon06.class.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                constructor.setAccessible(true);
                singleTwo = (SingleTon06) constructor.newInstance(); // breaks singleton
                break;
            }
        } catch (Exception e) { e.printStackTrace(); }

        System.out.println("singleOne hash: " + singleOne.hashCode());
        System.out.println("singleTwo hash: " + singleTwo.hashCode());
    }
}
```

### Explanation:

* Reflection can break singleton by **invoking private constructor**.
* Solution: Throw exception in constructor if instance already exists.

---
### Solution

```java
// In cash of Serialization and De-serialization
package com.amit.singleton.design.pattern;

import java.io.Serializable;

import javax.naming.OperationNotSupportedException;

public class SingleTon06 implements Serializable {

	private static final long serialVersionUID = 1L;
	private static SingleTon06 singleTon;

	private SingleTon06() throws OperationNotSupportedException {
		if (singleTon != null) {
			throw new OperationNotSupportedException("Object creation is not supported!!");
		}
	}

	public static SingleTon06 getInstance() throws OperationNotSupportedException {
		if (singleTon == null) {
			singleTon = new SingleTon06();
		}
		return singleTon;
	}
}

```
```java
package com.amit.singleton.design.pattern;

import java.lang.reflect.Constructor;

import javax.naming.OperationNotSupportedException;

public class SingleTon07Client {
	
	public static void main(String[] args) throws OperationNotSupportedException {
		 SingleTon06 singleOne = SingleTon06.getInstance();
		 SingleTon06 singleTwo = null;
		try {
			Constructor[] constructors = SingleTon06.class.getDeclaredConstructors();
			for (Constructor constructor : constructors) {
				// Below code will destroy the singleton pattern
				constructor.setAccessible(true);
				singleTwo = (SingleTon06) constructor.newInstance();
				break;
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("HashCode : singleTon : "+singleOne.hashCode());
		System.out.println("HashCode : singleTwo : "+singleTwo.hashCode());
		 
	}
}
```
### When we run above program it will throw the below exception saying "OperationNotSupportedException"
Means it will avoid to create the duplicate object.
```
Caused by: javax.naming.OperationNotSupportedException: Object creation is not supported!!
	at com.amit.singleton.design.pattern.SingleTon06.<init>(SingleTon06.java:15)
	... 6 more
HashCode : singleTon : 1101288798
```


# 9️⃣ Singleton using Enum (Best Solution)

```java
package com.amit.singleton.design.pattern;

public enum SingleTon08 {
    SINGLETON_INSTANCE;

    public void test() {
        System.out.println("Hash: " + this.hashCode());
    }
}
```

### Explanation:

* Enum ensures **only one instance**.
* Safe against:

  * Serialization
  * Cloning
  * Reflection
* **Drawback**: No lazy initialization.

---

# 🔟 Singleton with Cloning Issue

```java
package com.amit.singleton.design.pattern;

public class SingleTon09 implements Cloneable {
    public static final SingleTon09 instance = new SingleTon09();

    private SingleTon09() { }

    public static SingleTon09 getInstance() {
        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // breaks singleton
    }
}
```

### Fix:

```java
@Override
protected Object clone() throws CloneNotSupportedException {
    throw new CloneNotSupportedException("Singleton cannot be cloned");
}
```

---

# ✅ Practical Use Cases of Singleton

1. **Logger Class**

   * One logger for whole application.
   * Example: `LogManager.getLogger()` in Log4j.

2. **Database Connection Pool Manager**

   * Only one pool manager handles all DB connections.

3. **Configuration Manager**

   * Central configuration (e.g., properties loaded once).

4. **Caching**

   * One cache object shared across app.

5. **Thread Pool**

   * One global thread pool instead of multiple.

---

# ✅ Practical Use Cases of Singleton

When an interviewer asks *“What is the best / optimal way to create a Singleton class in Java?”*,
they are checking if you know:

* **Thread-safety**
* **Lazy initialization**
* **Performance**
* **How to avoid breaking Singleton** (via Serialization, Reflection, Cloning)

---

## ✅ Best / Optimal Singleton Approaches

### 1. **Enum Singleton (Most Recommended)**

* **Simplest & safest** way (introduced in Java 5).
* Provides thread-safety, serialization safety, and reflection safety out of the box.
* But **not lazy** (instance created at class loading).

```java
public enum SingletonEnum {
    INSTANCE;

    public void doSomething() {
        System.out.println("Doing some work...");
    }
}
```

**Usage:**

```java
public class Client {
    public static void main(String[] args) {
        SingletonEnum singleton = SingletonEnum.INSTANCE;
        singleton.doSomething();
    }
}
```

🔹 **Why optimal?**

* Enum ensures only one instance is ever created (JVM guarantees it).
* Serialization creates the same object.
* Reflection cannot break it.

---

### 2. **Bill Pugh Singleton (Best if Lazy Loading Required)**

This is the **most optimal lazy-loaded singleton** without synchronization overhead.

```java
public class Singleton {
    private Singleton() { }

    // Inner static helper class - not loaded until getInstance() is called
    private static class SingletonHelper {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public void doSomething() {
        System.out.println("Doing some work...");
    }
}
```

**Usage:**

```java
public class Client {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        singleton.doSomething();
    }
}
```

🔹 **Why optimal?**

* Lazy initialization (object created only when needed).
* Thread-safe (JVM loads inner class in a thread-safe way).
* No need for synchronized or double-checked locking.
* Faster than `synchronized` method.

---

## 📊 Interview Perspective

* If interviewer asks: **“What’s the best way to implement Singleton in Java?”**
  ✅ Say: *“Using Enum Singleton (Joshua Bloch recommends it in Effective Java). If we need lazy initialization, the Bill Pugh Singleton is the best approach.”*

* If they go deeper:

  * **Eager Initialization** → simple but wastes memory if unused.
  * **Lazy Initialization + synchronized** → thread-safe but slow.
  * **Double-checked Locking** → efficient but verbose.
  * **Bill Pugh** → optimal for lazy loading.
  * **Enum** → optimal overall, safest.

---

## 🏆 Final Recommendation (Interview Answer)

👉 **Answer in an interview like this**:

> *“The best way to implement Singleton in Java is using Enum, because it is thread-safe, handles serialization automatically, and prevents reflection attacks.   
If lazy initialization is required, the Bill Pugh Singleton (static inner helper class) is the most optimal choice because it’s thread-safe without synchronization overhead.”*

---