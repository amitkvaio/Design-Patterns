# **Prototype Design Pattern**

## ✅ **Definition**

* Prototype pattern is a **creational design pattern**.
* It allows us to **create a new object by copying (cloning)** an existing object instead of creating it from scratch.
* Useful when object creation is **costly, complex, or resource-intensive**.

---

## ✅ **Use Cases in IT Industry**

1. **When object creation is expensive**

   * Example: Loading configuration objects from a database or reading from a file. Instead of recreating them, we clone the existing object.

2. **When many similar objects are required**

   * Example: In a game, if we need thousands of enemies (zombies, soldiers) with minor changes, we clone a prototype instead of constructing each one.

3. **When system performance is critical**

   * Example: Parsing XML/JSON to create a template object once and then cloning it for further use.

4. **In caching systems**

   * Example: A cached prototype object can be cloned whenever a new request comes, avoiding repetitive creation.

---

## ✅ **Document Management System**

Imagine you are working in a **Document Management System (DMS)**.

* Every document (Word, PDF, Excel) has common fields: `title`, `author`, `content`, etc.
* Creating these objects from scratch each time (with formatting, metadata, and default content) is costly.
* Instead, you create a **prototype document** (a template) and **clone it** whenever a new document is required.

---

## ✅ **Java Example – Prototype Pattern**

```java
package com.amit.core.designpattern.prototype;

// Step 1: Prototype Interface
public interface Document extends Cloneable {
    Document clone();
    void setTitle(String title);
    void setAuthor(String author);
    void print();
}
```

```java
package com.amit.core.designpattern.prototype;

// Step 2: Concrete Prototype (Word Document)
public class WordDocument implements Document {
    private String title;
    private String author;
    private String content;

    public WordDocument(String content) {
        this.content = content;
    }

    @Override
    public Document clone() {
        try {
            return (Document) super.clone(); // shallow copy
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public void print() {
        System.out.println("WordDocument [Title=" + title + ", Author=" + author + ", Content=" + content + "]");
    }
}
```

```java
package com.amit.core.designpattern.prototype;

// Step 3: Client
public class PrototypeDemo {
    public static void main(String[] args) {
        // Create a prototype document (Template)
        WordDocument prototype = new WordDocument("Default company letterhead and formatting");

        // Clone prototype for new documents
        WordDocument doc1 = (WordDocument) prototype.clone();
        doc1.setTitle("Offer Letter");
        doc1.setAuthor("HR Team");
        doc1.print();

        WordDocument doc2 = (WordDocument) prototype.clone();
        doc2.setTitle("Appointment Letter");
        doc2.setAuthor("HR Team");
        doc2.print();

        WordDocument doc3 = (WordDocument) prototype.clone();
        doc3.setTitle("Relieving Letter");
        doc3.setAuthor("HR Team");
        doc3.print();
    }
}
```

---

## ✅ **Output**

```
WordDocument [Title=Offer Letter, Author=HR Team, Content=Default company letterhead and formatting]
WordDocument [Title=Appointment Letter, Author=HR Team, Content=Default company letterhead and formatting]
WordDocument [Title=Relieving Letter, Author=HR Team, Content=Default company letterhead and formatting]
```

---

## ✅ **Benefits**

* Avoids costly object creation.
* Makes it easy to produce similar objects.
* Reduces complexity (no need to reinitialize from scratch).

---

## ✅ **Real-World**

* **Spring Framework** → Spring Beans are prototype-scoped. Each request gives you a new cloned instance.
* **IDE Templates** → IntelliJ/Eclipse use prototype patterns for code templates.
* **Game Development** → Cloning objects like players, enemies, and environments.
* **Caching** → Database query results or configuration objects cloned from cache.

---
## **👉 In short:**
Prototype Pattern is best when creating an object is expensive, and you want to reuse or clone an existing one.