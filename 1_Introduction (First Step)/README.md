```
public class Hello {
}
```
### Hello World Project
- `Java` programs (and most other programming languages) have `keywords`. Each has a specific meaning and sometimes they need to be used in specific orders. 
- We write `Java` programs by following a specific set of rules, using a combination of these `keywords` and other things we will see which collectively from a `Java` program.
- **NOTE:** `keywords` are case-sensitive - `public` and `Public` and `PUBLIC` are different things. 
- `public` and `class` are two `Java` keywords - they have a specific meaning which we will find out more about moving forward.
- The `public` java keyword is an access modifier. An access modifier allows us to define the scope or how other parts of our code or even some else's code can access this code.
- For now, we will use the `public` access modifier to give full access. We'll come back to access modifiers once we get further into the course.
- Defining a **class**. The `class` keyword is used to define a class with the name following the keyword - `Hello` in this case and left and right curly braces to define the class block.
- To define a class requires an optional access modifiers, followed by class, followed by the left and right curly braces.
- The left and right curly braces are defining the class body - anything in between them is "part" of the class. We can have data and code as we will see as we progress.

### Defining the Main Method
- **What is Method?** It's a collection of statements (one or more) that performs an operation. We'll be using a special method called the `main` method that Java looks for when running a program. It's the entry point of any Java code.
- ```
    public class Hello {
        public static void main(String[] args) {
            System.out.println("Hello World");
        }
    }
  ```
- `public` is an access modifier we discussed when defining the class.
- `static` is a Java keyword that needs an understanding of other concepts, for now, know that we need to have static for java to find our method to run the code we are going to add.
- `void` is yet another java keyword used to indicate that the method will not return anything.
- The left and right parenthesis in a method declaration are mandatory and can optionally include one or more parameters - which is a way to pass information to method
- `Code Block` - A code block is used to define a block of code. It's mandatory to have one in a method declaration and it's here where we will be adding statements to perform certain tasks.
- `Statement` - This is a complete command to be executed and can include one or more expressions

### What are Variables?
- Variables are a way to store information in our computer. Variables that we define in a program can accessed by a name we give them, and the computer does the hard work of figuring out where they get stored in the computers random access memory (RAM).
- A variable, as the name suggests can be changed, in other words, it's contents are variable.
- What we have to do is to tell the computer what type of information we want to store in the variable, and then give it a name.
- There are lots of different types of data we can define for our variables. Collectively these are known as `Data Types`. 
- To define a variable we need to specify the data type, then give our variable a name, and optionally add an expression to initialize the variable with a value.

```
public class Hello {
        public static void main(String[] args) {
            int myFirstNumber = 1729;
            System.out.println(myFirstNumber);
        }
    }
```

### Declaration Statement
- Used to define a variable by indicating the data type, and the name and optionally to set the variable to a certain value.

### Expression
- This is a construct that evaluates to a single value.

### String Literal
- Any sequence of characters surrounded by double quotes is a Sting literal in Java. It's value cannot be changed, unlike a variable.

### Primitive Data Types
- The eight primitive data types in Java are `boolean`, `byte`, `char`, `short`, `int`, `long`, `float`, `double`. Consider these data types as the building blocks of data manipulation.

### Wrapper Classes
- Java uses the concept of a wrapper class for all eight primitive types - In the case of an `int`, we can use `Interger`, and by doing that it gives us ways to perform operations on an `int`.
- ```
    int myMinIntValue = Integer.MIN_VALUE;
    int myMaxIntValue = Integer.MAX_VALUE;
  ```
- In this case, we are using the `MIN_VALUE` and `MAX_VALUE` to get Java to tell us the minimum and maximum ranges of numbers that can be stored.

### Overflow and Underflow in Java
- If we try and put a value larger than the maximum value in Java, or a value smaller than the minimum value in Java, then we will get an `Overflow` in the case of maximum value or an `Underflow` in the case of the minimum.
- The computer just skips back to the minimum number or the maximum number, which is usually not what we want. It's an important concept to be aware of.

### Size of Primitive Types and Width
- A `Byte` occupies 8 bits. So a `Byte` occupies `8 bits`. We say that a `byte` has a width of `8`.
- A `short` can store a large range of numbers and occupies `16 bits` and has a width of `16`.
- An `int` has a much larger range as we know, and occupies `32 bits`, and has a width of `32`.

### Casting in Java
- Casting means to treat or convert a number from one type to another. We put the type we want the number to be in parentheses like this: `(byte)(myMinByteValue/2);`

### Floating Point Numbers
- Unlike whole numbers, floating point numbers have fractional parts that we express with a decimal point. `3.14159` is an example.
- Floating point numbers are also known as real numbers. We use a floating point number when we need more precision in calculations.

### Single and Double Precision
- Precision refers to the format and amount of space occupied by the type. Single precision occupies `32 bits` (so has a width of `32`) and a Double precision occupies `64 bits` (and thus has a width of `64`).
- As a result the `float` has a range from `1.4E-45` to `3.4028235E+38` and the `double` is much more precise with a range from `4.9E-324` to `1.7976931348623157E+308`.

### Floating Point Number Precision Tips
- In general `float` and `double` are great for general floating point operations. But both are not great to use where precise calculations are required - this is due to a limitation with how floating point numbers are stored, not a Java problem as such.
- Java has a class called `BigDecimal` that overcomes this.
- For now just keep in the back of our mind that when precise calculations are necessary, such as when performing currency calculations, floating-point types should not be used.

### Char Data Type
- A `char` occupies two bytes of memory, or `16 bits` and thus has a width of `16`. The reason it's not just a `single byte` is that it allows you to store Unicode characters.

### Unicode
- `Unicode` is an International encoding standard for use with different language and scripts, by which each letter, digit, or symbol is assigned a unique numeric value that applies across different platforms and programs.
- In the English alphabet, we have the letters A through Z. Meaning only 26 characters are needed in total to represent the entire English alphabet. But other languages need more characters, and often a lot more.
- `Unicode` allows us to represent these languages and the way it works is that by using a combination of the `two bytes` that a `char` takes up in memory it can represent and one of `65535` different types of characters.

### Boolean Primitive Type
- A `boolean` value allows for two choices `True` and `False`, `Yes` or `No`, `1` or `0`. In Java terms we have a `boolean` primitive type, and it can be set to two values only. `true` or `false`.

### String
- The `String` is a datatype in Java, which is not a primitive type. It's actually a `Class`, but it enjoys a bit of favoritism in Java to make it easier to use than a regular class.
- A `String` is a sequence of characters. A `String` can contain a sequence of characters. A large number of characters. Technically it's limited by memory or the `MAX_VALUE` of an `int` which was `2.14 Billion`. That's a lot of characters.

### String in Java are Immutable
- When we said we can delete characters out of a `String`, that's not strictly true. Because `Strings` in Java are immutable. That means we can't change a `String` after it's created. Instead, what happens is a new `String` is created.

### What are Operators?
- `Operators` in Java are special symbols that perform specific operations on one, two or three operands, and then return a result.

### What is an Operand ?
- An `operand` is a term used to describe any object that is manipulated by an `operator`. if we consider this statement
- ```
  int myVar = 15 + 12;
  ```
- Then `+` is the operator, and `15` and `12` are the `operands`. Variables used instead of literals are also `operands`.

### What is an Expression?
- An `expression` is formed by combining variables, literals, method return values and operators.
- In the line below, `15 + 12` is the expression which has (or returns) `27` is this case.
- `int myValue = 15 + 12;`

### What is a Comment?
- `Comments` are ignored by the computer and are added to a program to help describe something. `Comments` are there for humans.
- We use `//` in front of any code, or on a blank line. Anything after the `//` right through to the end of the line is ignored by the computer.
- Aside from describing something about a program, comments can be used to temporarily disable code.

### if-then Statements in Java
- The `if-then` statement is the most basic of all the control flow statements. It tells our program to execute a certain section of code only if particular test evaluates to `true`. This is known as `conditional logic`.

### Conditional Logic
- `Conditional logic` uses specific statements in Java to allow us to check a condition and execute certain code based on whether that condition (the expression) is `true` or `false`.

### Logical AND & Logical OR
- The `AND` operator comes in two flavors in Java, as does the `OR` operator.
- `&&` is the Logical `AND` which operates on `boolean` operands - Checking if a given condition is `true` or `false`.
- Likewise `||` is the Logical `OR` what again operates on `boolean` operands - Checking if a given condition is `true` or `false`.

### The NOT Operator
- The `!` or NOT operator is also known as the Logical Complement Operator.
- For use with `booleans` it tests the alternate value

### Ternary Operator
- The `ternary` operator is a shortcut to assigning one of two values to a variable depending on a given condition.
- It's a shortcut of the `if-then-else` statement.

### Learning Resources
- [Operators - Oracle Docs](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/opsummary.html)
- [Operators Precedence Table](https://www.cs.bilkent.edu.tr/~guvenir/courses/CS101/op_precedence.html)
- [Unicode Characters List](https://unicode-table.com/en/)