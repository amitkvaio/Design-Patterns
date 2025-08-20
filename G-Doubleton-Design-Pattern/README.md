# **DoubleTon Design Pattern**
### **How to design doubleton design pattern**
---

### 🔹 What is DoubleTon?

* A **Singleton** allows only **one object** of a class.
* A **DoubleTon** allows exactly **two objects** of a class.
* After that, it **reuses** the same two objects instead of creating new ones.

---
```java
package com.amit.core.designpattern.i.doubleton;

public class DoubleTon {
	private static DoubleTon[] tons = new DoubleTon[2];

	private static int index;

	private DoubleTon() {
		System.out.println("DoubleTon()");
	}

	static {
		tons[0] = new DoubleTon();
		tons[1] = new DoubleTon();
	}

	public static DoubleTon getObject() {
		return tons[(index++) % 2];
	}

	public static void main(String[] args) {
		DoubleTon d1 = DoubleTon.getObject();
		DoubleTon d2 = DoubleTon.getObject();
		DoubleTon d3 = DoubleTon.getObject();
		DoubleTon d4 = DoubleTon.getObject();

		System.out.println(d1);
		System.out.println(d2);
		System.out.println(d3);
		System.out.println(d4);
	}
}

```


### 🔹 Code Explanation

1. **Array to store objects**

```java
private static DoubleTon[] tons = new DoubleTon[2];
```

* Holds **exactly two instances** of `DoubleTon`.

2. **Index counter**

```java
private static int index;
```

* Used to track which object to return next.

3. **Private constructor**

```java
private DoubleTon() {
    System.out.println("DoubleTon()");
}
```

* Prevents outside object creation.
* Prints whenever constructor is called (to show object creation).

4. **Static block**

```java
static {
    tons[0] = new DoubleTon();
    tons[1] = new DoubleTon();
}
```

* Runs **once when class loads**.
* Creates **exactly two objects** in memory.
* Prints `"DoubleTon()"` twice.

5. **Get Object Method**

```java
public static DoubleTon getObject() {
    return tons[(index++) % 2];
}
```

* Returns object from array using **round-robin (modulo)**.
* `index++ % 2` ensures results alternate: `0, 1, 0, 1, 0, 1...`

6. **Main Execution**

```java
DoubleTon d1 = DoubleTon.getObject();
...
System.out.println(d1);
```

* Always returns one of the **two pre-created objects**.
* Prints memory addresses (hash codes) of objects.
* You will see **only 2 unique addresses** repeating.

---

### 🔹 Sample Output (simplified)

```
DoubleTon()
DoubleTon()
com.amit.core.designpattern.i.doubleton.DoubleTon@1a2b3c
com.amit.core.designpattern.i.doubleton.DoubleTon@4d5e6f
com.amit.core.designpattern.i.doubleton.DoubleTon@1a2b3c
com.amit.core.designpattern.i.doubleton.DoubleTon@4d5e6f
...
```

✅ Only **two objects** are ever created.
✅ They are returned in a **round-robin** manner.

---

### 🔹 Use Cases of DoubleTon

* **Thread Pools** → Maintain limited objects for reuse.
* **Database Connections** → Restrict number of connections.
* **Caching** → Keep only 2 cached objects to save memory.

---

👉 In short:
This `DoubleTon` ensures **only two objects exist** in JVM for this class, and all requests just **cycle through them** instead of creating new objects.

---
