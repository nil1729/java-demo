### Reference VS Object VS Instance VS Class
- Let's use the analogy of building a house to understand classes.
- A `class` is basically a blueprint for a house, using the blueprint (plans) we can build as many houses as we like based on our plans.
- Each house we build (in other words `instantiate` using the `new` operator) is an `object` also known as an `instance`.
- Each house we build has an address (a physical location). In other words if we want to tell someone where we live, we give them our address (perhaps written on a piece of paper). This is known as a `reference`.
- We can copy that `reference` as many times as we like but there is still just one house. In other words we are copying the paper that has address on it not the house itself.
- We can pass `references` as `parameters` to `constructors` and `methods`.

### House Class
```
    class House {
        private String color;
        
        public House(String color) {
            this.color = color;
        }
        
        public String getColor() {
            return this.color;
        }
        
        public void setColor(String color) {
            this.color = color;
        }
    }
```

### Main Method
```
    public class Main {
        public static void main() {
            House blueHouse = new House("blue");
            House anotherHouse = blueHouse;
            
            System.out.println(blueHouse.getColor()); // prints blue
            System.out.println(anotherHouse.getColor()); // blue
            
            anotherHouse.setColor("red");
            System.out.println(blueHouse.getColor()); // red
            System.out.println(anotherHouse.getColor()); // red
            
            House greenHouse = new House("green");
            anotherHouse = greenHouse;
            
            System.out.println(blueHouse.getColor()); // red
            System.out.println(anotherHouse.getColor()); // green
            System.out.println(greenHouse.getColor()); // green
        }
    }
```

- The line `House blueHouse = new House("blue");` creates a new `instance` of the House `class`. Remember House is a blueprint, and we are assigning it to the blueHouse `variable`. In other words it is a `reference` to the `object` in memory.
- The next line `House anotherHouse = blueHouse;` creates another `reference` to the same `object` in memory. Here we have to `refernces` pointing to the same object in memory. There is still one house, but two `references` to that one `object`. In other words we have two pieces of paper with the physical address of where the house is built.
- Next we have two `println` statements that print the blueHouse color and anotherHouse color. Both will print "blue" since we have two `references` to the same `object`.
- The next line calls the method `setColor` and sets teh color to `red`. Remember we have two `references` that point to the same `object` in memory. Once we change the color, of one, both `references` still point to the same `object`.
- Keep in mind that Java we always have `refernces` to an `object` in memory, there is no way to access an `object` directly everything is done using a `refernce`.

### `this` VS `super`
- The keyword `super` is used to access/call the parent class members (variables and methods).
- The keyword `this` is used to call the current class members (variables and methods). This is required when we have a parameter with the same name as an instance variable (field).
- **NOTE:** We can use both of them anywhere in a class except static areas (the static block or a static method). Any attempt to do so will lead to compile-time errors.

### Keyword `this`
- The keyword `this` is commonly used with `constructors` and `setters`, and optionally in `getters`. In the example below we are using the `this` keyword in the `constructor` and `setter` since there is a parameter with the same name. In the getter we don't have any parameters so the `this` keyword is optional.
- ```
    class House {
        private String color;
  
        public House(String color) {
            // this keyword is required, same parameter name as field 
            this.color = color;
        }
  
        public String getColor() {
            // this is optional
            return color; // same as return this.color;
        }
  
        public void setColor(String color) {
            // this keyword is required, same parameter as name field
            this.color = color;
        }
    }
  ```
  
### Keyword `Super`
- The keyword `super` is commonly used with `method overriding`, when we call a method with the same name from the parent class. In the example below we have a method `printMethod` that calls the `super.printMethod`.
- ```
    class SuperClass { // parent class aka super class
        public void printMethod() {
            System.out.println("Printed in Superclass.");
        }
    }
  
    class SubClass extends SuperClass { // subclass aka child class
        // overrides method from parent
        @Override
        public void printMethod() {
            super.printMethod(); // calls method in SuperClass (parent)
            System.out.println("Printed in Subclass");
        }
    }
  
    class MainClass {
        public static void main(String[] args) {
            SubClass s = new SubClass();
            s.printMethod();
        }
    }
  ```
- In other words it's calling the method with the same name from the parent class. Without the keyword `super` in this case it would be recursive call. Meaning that the method would call itself forever (or until memory is fully used). That is why the `super` keyword is needed.

### `this()` VS `super()` call
- In Java, we have the `this()` call and the `super()` call. Notice the braces it is known as a call since it looks like a regular method call.
- Use `this()` to call a constructor from another overloaded constructor in the same class.
- The call to `this()` can be used only in a constructor, and it must be the **first statement** in a constructor. It's used with constructor chaining, in other words when one constructor call
- The only way to call a parent constructor is by calling `super()`. This calls the parent constructor.
- The Java Compiler puts a default call to `super()` if we don't add it, and it is always the non args `super` which is inserted by compiler (constructor without arguments).
- The call to `super()` must be the first statement in each constructor.
- Even Abstract classes have constructors, although we can never instantiate an abstract class using the new keyword.
- An abstract class is still a `super` class, so its constructors run when someone makes an instance of a concrete subclass.
- **NOTE:** A constructor can have a call to `super()` or `this()` but never both.

### Constructors Bad Example
- ```
    class Rectangle {
        private int x;
        private int y;
        private int height;
        private int width;
  
        public Rectangle() {
            this.x = 0;
            this.y = 0;
            this.width = 0;
            this.height = 0;
        }
  
        public Rectangle(int width, int height) {
            this.x = 0;
            this.y = 0;
            this.width = width;
            this.height = height;
        }
  
        public Rectangle(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }
    }
  ```
- In this example we have three constructors.
- All three constructors initialize variable.
- There is repeated code in every constructor. We are initializing variables in each constructor with some default values.

### Constructors Good Example
- ```
    class Rectangle {
        private int x;
        private int y;
        private int width;
        private int height;
        
        // 1st constructor
        public Rectangle() {
            this(0, 0); // calls 2nd constructor
        }
  
        // 2nd constructor
        public Rectangle(int width, int height) {
            this(0, 0, width, height); // calls 3rd constructor
        }
  
        // 3rd constructor
        public Rectangle(int x, int y, int width, int height) {
            // initialize variables
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }
    }
  ```
- In this example we also have three constructors
- The 1st constructor calls the 2nd, the 2nd constructor call the 3rd constructor, and the 3rd constructor initializes the instance variables.
- The 3rd constructor does all the work.
- No matter what constructor we call, the variable will always be initialized in 3rd constructor.
- This is known as `constructor chaining`, the last constructor has the **responsibility** to initialize the variables. 

### `super()` call example
- ```
    class Shape {
        private int x;
        private int y;
        
        public Shape(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
  
    class Reactangle extends Shape {
        private int width;
        private int height;
        
        // 1st constructor
        public Reactangle(int x, int y) {
            this(x,  y, 0, 0); // calls 2nd constructor
        }
   
        // 2nd constructor
        public Rectangle(int x, int y, int width, int height) {
            super(x, y); // calls constructor from parent (Shape)
            this.width = width;
            this.height = height;
        }
    }
  ```
- In this example we have a class Shape with x,y variables and class Rectangle that extends Shape with variables width and height.
- In Rectangle, the 1st constructor we are calling the 2nd constructor.
- The 2nd constructor call the parent constructor with parameters x and y.
- The parent constructor will initialize x,y variables while the 2nd Rectangle constructor will initialize the width and height variables.
- Here we have both `super()` and `this()` calls.

### Method Overloading
- Method `overloading` means providing two or more separate methods in a class with the `same name` but `different parameters`.
- Method return type may or may not be different and that allows us to `reuse` the same method name.
- `Overloading` is very handy, it reduces duplicated code, and we don't have to remember multiple method names.
- `Overloading` does not have anything related to do with `polymorphism` but Java developers often refer to `overlaoding` as `Compile Time Polymorphism`.
- In other words the compiler decided which method is going to be called based on the method name, return type and argument list.
- We can overload `static` and `instance` methods.
- Usually `overloading` happens inside a single class, but a method can also be treated as `overload` in the subclass of that class.
- That is because a `subclass inherits` one version of the method from the parent class and then the subclass can have another overloaded version of the method.
- Method will be considered overloaded if both follow the following rules:
  - Methods must have the same method name.
  - Methods must have different parameters.
- If methods follow the rules above then they may or may not:
  - Have different return types.
  - Have different access modifiers.
  - Throw different checked or unchecked exceptions.
- ```
    class Dog {
        public void bark() {
            System.out.println("woof");
        }
    }
    
    class GermanShepherd extends Dog {
        
        @Override
        public void bark() {
            System.out.println(""woof woof woof");
        }
    }
  ```

### Method Overriding
- Method `overriding` means defining a method in a child class that already exists in the parent class with same signature (same name, same arguments).
- By extending the parent class the child class gets all the methods defined in the parent class (those methods are also known as derived methods).
- Method `overriding` is also known as `Runtime Polymorphism` and `Dynamic Method Dispatch`, because the method that is going to be called is decided at runtime by the JVM.
- When we `override` a method it's recommended to put `@Override` immediately above the method definition. This is an annotation that the compiler reads and will then show us an error if we don't follow overriding rules correctly.
- We `can't override static` methods, `only instance` methods.
- Method will be considered overridden if we follow these rules:
  - It must have same named and same arguments.
  - Return type can be a subclass of the return type in the parent class.
  - It can't have a lower access modifier.
  - For example if the parent method is `protected` then using `private` in the child is not allowed but using `public` in the child would be allowed.
- There are also some **important points** about method `overriding` to keep in mind:
  - `Only inherited methods can be overriden`, in other words methods can be overridden only in child classes.
  - `Constructors and private methods cannot be overriden`.
  - Methods that are final cannot be overridden.
  - A subclass can use `super.methodName()` to call the superclass version of an overridden method.
- ```
    class Dog {
        
        public void bark() {
            System.out.println("woof");
        }
  
        public void bark(int number) {
            for(int i = 0; i < number; i++) {
                System.out.println("woof");
            }
        }
    }
  ```
  
### Method Overloading VS Method Overriding
| Method Overloading                                                       | Method Overriding                                                                |
|--------------------------------------------------------------------------|----------------------------------------------------------------------------------|
| Provides functionality to reuse a method name with different parameters. | Used to override a behavior which the class has inherited from the parent class. |
| Usually in a single class but may also be used in a child class.         | **Always in two classes** that have a child-parent or IS-A relationship.         |
| **Must have** different parameters.                                      | **Must have** the same parameters and same name.                                 |
| May have different return types.                                         | Must have the same return type or covariant return type (child class).           |
| May have different access modifiers (private, protected, public)         | **Must NOT** have a lower modifier but may have a higher modifier.               |
| May throw different exceptions.                                          | **Must NOT** throw a new or broader checked exception.                           |

### Covariant return type
- ```
    class Burger {
      // fields, methods ...
    }
  
    class HealthyBurger extends Burger {
      // fields, methods ...
    }
  ```
- ```
    class BurgerFactory {
      
      public Burger createBurger() {
        return new Burger();
      }
    }
  
    class HealthyBurgerFactory {
    
      @Override
      public HealthyBurger createBurger() {
        return new HealthyBurger();
      }
    }
  ```
  
### Static Methods
- `Static methods` are declared using `static` modifier.
- `Static methods can't` access instance methods and instance variables directly.
- They are usually used for operations that don't require any data from an instance of the class (from `this`). (the `this` keyword is the current instance of a class)
- In `static methods` we can't use the `this` keyword.
- Whenever we see a method that `does not use instance variables` that method should be declared as a `static method`.
- For example `main` is a static method, and it is called by the JVM when it starts an application.

### Static Methods Example
- ```
    class Calculator {
        public static void printSum(int a, int b) {
            System.out.println("sum= " + (a + b));
        }
    }
  
    public class Main {
        
        public static void main(String[] args) {
            Calculator.printSum(5, 10);
            printHello(); // shorter form of Main.printHello();
        }
  
        public static void printHello() {
            System.out.println("Hello");
        }
    }
  ```
- `static methods` are called as `ClassName.methodName();` or `methodName();` only if in the same class
- In this example `Calculator.printSum(5, 10);` and `printHello();`

### Instance Methods
- `Instance methods` belong to an instance of a class.
- To use an `instance method` we have to instantiate the class first usually by using the `new` keyword.
- `Instance methods` can access instance methods and instance variables directly.
- `Instance methods` can also access static methods and static variables directly.

### Instance Method Example
- ```
    class Dog {
      
        public void bark() {
            System.out.println("woof");
        }
    }
  
    public class Main {
        
        public static void main(String[] args) {
            Dog rex = new Dog(); // create instance
            rex.bark(); // call instance method
        }
    }
  ```
  
### Static Variables
- Declared by using the keyword `static`.
- `Static variables` are also known as `static member variables`.
- Every instance of that class `shares` the same static variable.
- If changes are made to that variable, all others instances will see the effect of the change.
- `Static variables` are not used very often but can sometimes be very useful. For example when reading user input using `Scanner` we will declare scanner as a static variable.
- ```
    class Dog {
        
        private static String name;
        
        public Dog(String name) {
            Dog.name = name;
        }
  
        public void printName() {
            System.out.println("name= " + name);
        }
    }
  
    public class Main {
        
        public static void main(String[] args) {
            Dog rex = new Dog("rex"); // create instance (rex)
            Dog fluffy = new Dog("fluffy"); // create instance (fluffy)
            rex.printName(); // prints fluffy
            fluffy.printName(); // prints fluffy
        } 
    }
  ```
  
### Instance Variables
- They `don't` use the `static` keyword.
- Instance variable are also known as fields or member variables.
- `Instance variables` belong to an instance of a class.
- Every instance has its own copy of an instance variable.
- Every instance can have a different value (state).
- Instance variables represent the state of an instance.
- ```
    class Dog {
        
        private String name;
  
        public Dog(String name) {
            this.name = name;
        }
        
        public void printName() {
            System.out.println("name= " + name);
        }
    }
  
    public class Main {
         
        public static void main(String[] args) {
            Dog rex = new Dog("rex"); // create instance (rex)
            Dog fluffy = new Dog("fluffy"); // create instance (fluffy)
            rex.printName(); // prints rex
            fluffy.printName(); // prints fluffy
        }
    }
  ```