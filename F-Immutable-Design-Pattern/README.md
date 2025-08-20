
#  **Immutable Design Pattern**

## ✅ **Definition**

* An **Immutable class** is a class whose objects **cannot be modified once created**.
* Any change results in a **new object** being created.

👉 In Java, **String**, all **wrapper classes** (`Integer`, `Boolean`, `Long`, etc.) are immutable.

---

## ✅ **Why Immutable Design Pattern? (Use Cases in IT Industry)**

1. **Thread Safety**

   * Immutable objects are inherently **thread-safe** because their state never changes.
   * Example: String objects shared across multiple threads.

2. **Caching**

   * Frequently used objects can be cached and reused without worrying about modification.
   * Example: Integer cache in Java (`Integer.valueOf(1)`).

3. **Security**

   * Prevents unauthorized modifications of sensitive data.
   * Example: Immutable objects in **financial applications** (bank account details).

4. **Collections & Data Transfer**

   * Prevents modification of data once it’s passed to another method/class.
   * Example: Returning an **unmodifiable list** from a method.

---

## ✅ **Rules to Create an Immutable Class**

1. Declare the class as **`final`** (no subclassing).
2. Declare all fields as **`private final`**.
3. Provide a **parameterized constructor** to initialize fields.
4. Provide only **getter methods**, no setters.
5. For mutable fields (like collections or custom objects), return a **defensive copy** or **unmodifiable collection** in getters.

---

# 📌 **Program**

---

### 1️⃣ **Simple Immutable Class**

```java
package com.amit.immutable.design.pattern;

final class SingleP {
	private final String name;
	private final int roll;

	public SingleP(final String name, final int roll) {
		this.name = name;
		this.roll = roll;
	}

	public String getName() {
		return name;
	}

	public int getRoll() {
		return roll;
	}
}

public class Immutable {
	public static void main(String[] args) {
		SingleP s1 = new SingleP("amit", 101);
		System.out.println(s1.getName());
		System.out.println(s1.getRoll());
	}
}
```

### 🔎 **Explanation**

* `SingleP` is immutable because:

  * `final` class (cannot be extended).
  * Fields are `private final`.
  * No setters.
  * Only getters.
* Once created, we cannot change `name` or `roll`.

---

### 2️⃣ **Mutable Class (Address)**

```java
package com.amit.immutable.design.pattern;

public class Address {
	String firstLine;
	String secondLine;
	String city;

	public Address(String firstLine, String secondLine, String city) {
		this.firstLine = firstLine;
		this.secondLine = secondLine;
		this.city = city;
	}

	// Getters and Setters
	// (These make Address mutable)
	public String getFirstLine() { return firstLine; }
	public void setFirstLine(String firstLine) { this.firstLine = firstLine; }
	public String getSecondLine() { return secondLine; }
	public void setSecondLine(String secondLine) { this.secondLine = secondLine; }
	public String getCity() { return city; }
	public void setCity(String city) { this.city = city; }

	@Override
	public String toString() {
		return "Address [firstLine=" + firstLine + ", secondLine=" + secondLine + ", city=" + city + "]";
	}
}
```

### 🔎 **Explanation**

* `Address` is **mutable** because it has **setters**.
* If we directly store `Address` inside an immutable class, it can break immutability.

---

### 3️⃣ **Immutable Class with Mutable Object (Student + List of Address)**

```java
package com.amit.immutable.design.pattern;

import java.util.Collections;
import java.util.List;

public final class StduentUnmodifiable {
	private final String name;
	private final int age;
	private List<Address> addressList;

	public StduentUnmodifiable(final String name, final int age, final List<Address> addresslist) {
		this.name = name;
		this.age = age;
		this.addressList = addresslist;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	// Defensive approach: return unmodifiable list
	public List<Address> getAddressList() {
		return Collections.unmodifiableList(addressList);
	}

	@Override
	public String toString() {
		return "StduentUnmodifiable [name=" + name + ", age=" + age + ", addressList=" + addressList + "]";
	}
}
```

### 🔎 **Explanation**

* Class is `final`, fields are `final`.
* No setters provided.
* For the `List<Address>`, we return **`Collections.unmodifiableList`** so nobody can modify the original list.

---

### 4️⃣ **Client Code**

```java
package com.amit.immutable.design.pattern;

import java.util.ArrayList;
import java.util.List;

public class StduentUnmodifiableClient {
	public static void main(String[] args) {
		Address ad1 = new Address("Kadugodi", "Hanumanthappa", "Bangalore");
		Address ad2 = new Address("Marathalli", "KalaMandir", "Bangalore");

		List<Address> addList = new ArrayList<>();
		addList.add(ad1);
		addList.add(ad2);

		StduentUnmodifiable std = new StduentUnmodifiable("Amit", 30, addList);
		System.out.println("Student: " + std);

		// Trying to modify address list externally
		std.getAddressList().remove(0);   // Throws UnsupportedOperationException
	}
}
```

### 🔎 **Explanation**

* If we try to `remove(0)` from the `addressList`, it throws `UnsupportedOperationException` because we used `Collections.unmodifiableList()`.
* This ensures immutability of the `StduentUnmodifiable` class.

---

# 📌 **Interview Concepts**

### ✅ **Why Immutable Objects are Preferred?**

* Thread safety → no synchronization needed.
* Simplicity → once created, state is fixed.
* Security → prevents malicious changes.
* Performance → can be cached and reused.

### ✅ **Difference Between Mutable and Immutable**

| Feature       | Mutable (e.g., `Address`) | Immutable (e.g., `String`, `StudentUnmodifiable`) |
| ------------- | ------------------------- | ------------------------------------------------- |
| State         | Can change after creation | Fixed once created                                |
| Thread Safety | Not thread-safe           | Thread-safe                                       |
| Example       | StringBuilder             | String                                            |

---

# 📌 **Case: If We Don’t Implement Cloneable**

* Suppose our immutable class holds a mutable object (like `Address`).
* If we simply **return the reference** of `Address` from a getter without making a clone → the caller can modify it.
* Example:

  ```java
  std.getAddressList().get(0).setCity("Delhi");  // modifies student’s internal state
  ```
* This **breaks immutability**.

👉 Solution:

* Either implement **deep copy using `Cloneable`** or
* Use **defensive copies** (new object creation in getter/constructor).

---

### Key Rules for Immutability

1. **Class must be `final`** → To prevent subclassing.
2. **Fields must be `private final`** → So values can be set only once.
3. **Initialize fields via constructor**.
4. **Only getters, no setters** → Prevent modification after creation.
5. **For mutable fields** (like `List`, `Date`), return:

   * **Unmodifiable collection** OR
   * **Defensive copy** (deep copy).

---

### Use Cases in IT Industry

* **Thread-safe data sharing** → No synchronization needed.
* **Caching frequently used objects** → Safe to reuse (e.g., `Integer.valueOf()`).
* **Security-sensitive objects** → Prevent unauthorized modifications (e.g., user roles, credentials).

---

### Example: Immutable `Student` Class

```java
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public final class Student {
    private final String name;
    private final int rollNo;
    private final List<String> subjects;

    public Student(String name, int rollNo, List<String> subjects) {
        this.name = name;
        this.rollNo = rollNo;
        // Defensive copy
        this.subjects = new ArrayList<>(subjects);
    }

    public String getName() { return name; }
    public int getRollNo() { return rollNo; }

    // Return unmodifiable list
    public List<String> getSubjects() {
        return Collections.unmodifiableList(subjects);
    }
}
```

---

### Interview Points

* **Why `String` is immutable?**

  * Security (avoid exposing sensitive data)
  * Caching (string pool reuse)
  * Thread safety (no race condition on shared strings)

* **What if no defensive copy is used?**

  * Outside code can modify internal fields → breaks immutability.

---

✅ **Example in Industry:**

* In financial apps, an immutable `Transaction` object is used so once created, no one can alter the transaction details (amount, sender, receiver).

---