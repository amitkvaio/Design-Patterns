# **Factory Design Pattern**
---

# 🔹 Factory Design Pattern Explanation

* **Definition**: Factory Pattern is a **Creational Design Pattern** that provides an interface (or method) for creating objects but **lets subclasses or a factory class decide which class to instantiate**.
* Instead of using `new` everywhere in the code, we delegate object creation to a **Factory**.

✅ **Why we use it?**

* To achieve **loose coupling** (client doesn’t depend on concrete classes).
* To avoid repeating object creation logic everywhere.
* To make the system more **scalable** when new product types are introduced.

✅ **Where to use?**

* When we have a **super interface/abstract class** and multiple implementations.
* When object creation depends on **some input or condition**.
* Example:

  * `PizzaStore` → wants different types of Pizza (`CheesePizza`, `ChickenPizza`, `VeggiePizza`).
  * `PizzaFactory` → decides which pizza to create based on input.

---

# 🔹 Code

### 1. `Pizza` (Interface – Common contract for all pizzas)

```java
package com.amit.factory.design.pattern.pizzafactory;

// Common interface for all pizzas
public interface Pizza {
    void prepare();
    void bake();
    void cut();
}
```

👉 **Why?**

* Defines a common behavior for all pizzas.
* Helps in **polymorphism** (we can refer to `Pizza` without knowing the exact type).

---

### 2. `CheesePizza` (Concrete class)

```java
package com.amit.factory.design.pattern.pizzafactory;

// Concrete product - Cheese Pizza
public class CheesePizza implements Pizza {

    @Override
    public void prepare() {
        System.out.println("Preparing Cheese Pizza");
    }

    @Override
    public void bake() {
        System.out.println("Baking Cheese Pizza");
    }

    @Override
    public void cut() {
        System.out.println("Cutting Cheese Pizza");
    }
}
```

👉 **Why?**

* Implements pizza-specific behavior.
* Similar classes for `ChickenPizza` and `VeggiePizza`.

---

### 3. `ChickenPizza` (Concrete class)

```java
package com.amit.factory.design.pattern.pizzafactory;

// Concrete product - Chicken Pizza
public class ChickenPizza implements Pizza {

    @Override
    public void prepare() {
        System.out.println("Preparing Chicken Pizza");
    }

    @Override
    public void bake() {
        System.out.println("Baking Chicken Pizza");
    }

    @Override
    public void cut() {
        System.out.println("Cutting Chicken Pizza");
    }
}
```

---

### 4. `VeggiePizza` (Concrete class)

```java
package com.amit.factory.design.pattern.pizzafactory;

// Concrete product - Veggie Pizza
public class VeggiePizza implements Pizza {

    @Override
    public void prepare() {
        System.out.println("Preparing Veggie Pizza");
    }

    @Override
    public void bake() {
        System.out.println("Baking Veggie Pizza");
    }

    @Override
    public void cut() {
        System.out.println("Cutting Veggie Pizza");
    }
}
```

---

### 5. `PizzaFactory` (Factory class)

```java
package com.amit.factory.design.pattern.pizzafactory;

// Factory class to create pizza objects
public class PizzaFactory {

    // Factory method to decide which Pizza to create
    public static Pizza createPizza(String type) {
        Pizza p = null;
        if (type.equalsIgnoreCase("cheese")) {
            p = new CheesePizza();
        } else if (type.equalsIgnoreCase("chicken")) {
            p = new ChickenPizza();
        } else if (type.equalsIgnoreCase("veggie")) {
            p = new VeggiePizza();
        }
        return p;
    }
}
```

👉 **Why?**

* Centralizes object creation logic.
* Client (`PizzaStore`) doesn’t need to use `new` directly.

---

### 6. `PizzaStore` (Client of Factory)

```java
package com.amit.factory.design.pattern.pizzafactory;

// Client class that uses the Factory to order pizzas
public class PizzaStore {

    public Pizza orderPizza(String type) {
        // Delegate object creation to Factory
        Pizza p = PizzaFactory.createPizza(type);

        if (p != null) {
            p.prepare();
            p.bake();
            p.cut();
        } else {
            System.out.println("Sorry, we don't have that type of pizza.");
        }
        return p;
    }
}
```

👉 **Why?**

* Client (`PizzaStore`) **doesn’t know the actual pizza class**.
* Just asks the factory for a pizza.

---

### 7. `UserClient` (Test Class)

```java
package com.amit.factory.design.pattern.pizzafactory;

public class UserClient {
    public static void main(String[] args) {
        PizzaStore ps = new PizzaStore();

        // Order a Chicken Pizza
        ps.orderPizza("chicken");

        // Order a Cheese Pizza
        ps.orderPizza("cheese");

        // Order an unsupported pizza
        ps.orderPizza("mushroom");
    }
}
```

👉 **Output Example**:

```
Preparing Chicken Pizza
Baking Chicken Pizza
Cutting Chicken Pizza

Preparing Cheese Pizza
Baking Cheese Pizza
Cutting Cheese Pizza

Sorry, we don't have that type of pizza.
```

---

# 🔹 Real World Use Cases of Factory Pattern

1. **Spring Framework** –
   `ApplicationContext.getBean("beanName")` works like a Factory to create/manage beans.

2. **JDBC API** –
   `DriverManager.getConnection()` returns a specific `Connection` object (MySQL, Oracle, etc.) depending on the input.

3. **Logging Frameworks** –
   `LoggerFactory.getLogger(ClassName.class)` returns different loggers.

4. **GUI Libraries** –
   Different buttons/menus are created based on OS (Windows/Mac/Linux).

---

✅ **Summary**

* Factory Pattern is useful when we want to **create objects without exposing creation logic**.
* It provides **loose coupling, flexibility, and scalability**.

---