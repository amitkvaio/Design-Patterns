# **Abstract Factory Design Pattern**
---

## ✅ Abstract Factory Design Pattern

* **Definition:**
  A creational pattern that provides an **interface for creating families of related objects** (not just one type).
  *It is like a **factory of factories**.*

* **Use Case:**
    * When we want to create groups of related objects **together** without specifying their concrete classes.  
  
    * Example: Suppose we want to create `Pizza` **and** `Drink` together depending on the cuisine (e.g., **Italian Factory** gives `CheesePizza + Coke`, **Indian Factory** gives `PaneerPizza + MasalaChai`).

---

## 🔑 Difference between Factory and Abstract Factory

| Feature       | Factory Method Pattern                                    | Abstract Factory Pattern                                                                     |
| ------------- | --------------------------------------------------------- | -------------------------------------------------------------------------------------------- |
| **Focus**     | Creates **one product** at a time.                        | Creates **families of related products**.                                                    |
| **Structure** | One Factory Class or Method.                              | Multiple factories grouped under one Abstract Factory.                                       |
| **Example**   | Pizza Factory → Creates Cheese, Veggie, Chicken Pizza.    | Italian Factory → Creates Pizza **and** Drink, Indian Factory → Creates Pizza **and** Drink. |
| **Use Case**  | When we just need a simple decision to create an object. | When we need to create a group/set of related objects together.                             |

---

## 🎯 Example of Abstract Factory (Pizza + Drink Factory)

### Step 1 – Product Interfaces

```java
// Pizza interface
public interface Pizza {
    void prepare();
    void bake();
    void cut();
}

// Drink interface
public interface Drink {
    void serve();
}
```

### Step 2 – Concrete Products

```java
// Concrete Pizza
public class CheesePizza implements Pizza {
    public void prepare() { System.out.println("Preparing Cheese Pizza"); }
    public void bake() { System.out.println("Baking Cheese Pizza"); }
    public void cut() { System.out.println("Cutting Cheese Pizza"); }
}

public class VeggiePizza implements Pizza {
    public void prepare() { System.out.println("Preparing Veggie Pizza"); }
    public void bake() { System.out.println("Baking Veggie Pizza"); }
    public void cut() { System.out.println("Cutting Veggie Pizza"); }
}

// Concrete Drinks
public class Coke implements Drink {
    public void serve() { System.out.println("Serving Coke"); }
}

public class MasalaChai implements Drink {
    public void serve() { System.out.println("Serving Masala Chai"); }
}
```

### Step 3 – Abstract Factory

```java
public interface FoodFactory {
    Pizza createPizza();
    Drink createDrink();
}
```

### Step 4 – Concrete Factories

```java
// Italian Factory → Cheese Pizza + Coke
public class ItalianFoodFactory implements FoodFactory {
    public Pizza createPizza() { return new CheesePizza(); }
    public Drink createDrink() { return new Coke(); }
}

// Indian Factory → Veggie Pizza + Masala Chai
public class IndianFoodFactory implements FoodFactory {
    public Pizza createPizza() { return new VeggiePizza(); }
    public Drink createDrink() { return new MasalaChai(); }
}
```

### Step 5 – Client

```java
public class UserClient {
    public static void main(String[] args) {
        // Choose Factory at runtime
        FoodFactory factory = new ItalianFoodFactory();  // or new IndianFoodFactory()

        Pizza pizza = factory.createPizza();
        Drink drink = factory.createDrink();

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        drink.serve();
    }
}
```

---

## ✅ When to Use Abstract Factory

1. When our system should be **independent of how products are created**.
2. When we need to create **families of related objects**.
3. When we want to ensure **consistency among products** (e.g., Indian Pizza goes with Indian Drink).

---

👉 In short:

* **Factory Pattern** → Single product creation (Pizza types).
* **Abstract Factory Pattern** → Multiple related product creation (Pizza + Drink together, depending on cuisine).

---
 