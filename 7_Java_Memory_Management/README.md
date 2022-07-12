### Java Memory
- How Memory works?
- Code optimisation
- Avoiding coding errors

### The Stack (FIFO) (First-In-First-Out)
- ```
    public class Main {
        public static void main(String[] args) {
            int value = 7;
            value = calcualte(value);
        }
        
        public static int calculate(int data) {
            int tempValue = data + 3;
            int newValue = tempValue * 2;
            return newValue;
        }
    }
  ```
  
- ```
  | newValue = 20      |
  | tempValue = 10     |
  | data = 7           |
  | value = 7          | 
  | args = emtry array |
  ```

### The Heap
- All objects are stored on the heap
- ```
    int age = 21;
    String name = "Hello";
  ```
- ```
    | Stack    |       | Heap             |
    |----------|       |------------------| 
    | name     | ----> | String ("Hello") |
    | age = 21 |
  ```

### Sharing Data (Heap)
- ```
    public static void main(String[] args) {
        List<String> myList = new ArrayList<string>();
        myList.add("One");
        myList.add("Two");
        myList.add("Three");
        printList(myList);
    }
  
    public static void printList(List<String> data) {
        String value = data.get(1);
        data.add("Four");
        System.out.println(data);
    }
  ```
  
- ```
                 |-------------------------------------------------|
    | Stack  |   |       | Heap                               |    |
    |--------|   |       |------------------------------------|    |
    | value  | --| |---> | | List |                           |    |
    | data   | ----|     | |------|                           |    |
    | myList | ----|     | | 0    | ----> | String("One")   | |    |
                         | | 1    | ----> | String("Two")   | | <--| 
                         | | 2    | ----> | String("Three") | |
                         | | 3    | ----> | String("Four")  | |
  ```

### Java Memory - The Rules
- Objects are stored on the heap
- variables are a reference to the object
- Local variables are stored on the stack

### Passing variables by value
- ```
    public class Main {
        public static void main(String[] args) {
            int localValue = 5;
            calculate(localValue);
            System.out.println(localValue); // 5
        }
  
        public static void calculate(int calcValue) {
            calcvalue = calcValue * 100;
        }
    }
  ```

### Passing Values (by Reference)
- ```
    public class Main {
        public static void main(String[] args) {
            Customer c = new Customer("Nil");
            renameCustomer(c);
            System.out.println(c.getName()); // Nilanjan
        }
  
        public static void renameCustomer(Customer cust) {
            cust.setName("Nilanjan");
        }
    }
  ```

### The final keyword
- ```
    final Customer c = new Customer("Nilanjan"); 
    // now we can't change the variable c
  ```
- ```
    final Customer c;
    c = new Customer("Nil"); // valid
    c = new Customer("John"); // not valid
  ```
- We can change the object parameters assigned to a `final variable`.
- In the given example we can change the Customer name by calling `setName()` method.
- ```
    public class Main {
        public static void main(String[] args) {
            final Customer c = new Customer("John");
            // is this method call safe ? -> Not safe as we don't know the implementation of the getName() method
            System.out.println(c.getName()); // John
            System.out.println(c.getName()); // ABC
        }
    }
  
    class Customer {
        ...
        
        public String getName() {
            String temp = this.name;
            this.name = "ABC";
            return temp;
        }
    }
  ```
  
### Escaping References
- We may always encounter with a problem that can occur in our code called `Escaping References`.
- One of the key concept of `Object Oriented Programming` is `encapsulation`.
- The idea that classes contain both the data and the functionality package together. With access to this data, within a class being strictly controlled.
- **Example of a Well-Defined class** 
  - The data in the class, which are title and the author fields, cannot be accidentally changed from outside the class. These are private fields, so they are not visible directly, and we can only set the value of these fields by either calling the constructor or one of the set methods.
  - ```
        public class Book {
            
            private String title;
            private String author;
            
            public String getTitle() {
                return title;
            }
      
            public void setTitle(String title) {
                this.title = title;
            }
    
            public Book(String title, String author) {
                this.title = title;
                this.author = author;
            }
        }
    ```
- **Example of not a Well-Defined Class**
  - ```
       // Class Definitions 
       public class CustomerRecords {
          private Map<String, Customer> records;
    
          public CustomerRecords() {
              this.records = new HashMap<String, Customer>();
          }
    
          public void addCustomer(Customer c) {
              this.records.put(c.getName(), c);
          }
    
          public Map<String, Customer> getCustomers() {
              return this.records;
          }
          // Not a good code, there is a problem here.
          // The problem is getCustomers() method
          // We now know that this returns a refernce to the records collection.
          // The calling code now obtains a reference to the collection and it can do anything it like with that collection.
       } 
    
       // Client Code
       CustomerRecords records = new CustomerRecords();
    
       records.addCustomer(new Customer("John"));
       records.addCustomer(new Customer("Nilanjan"));
    
       for(Customer next : records.getCustomers().values()) {
            System.out.println(next);
       }
    
       // Evil code
       CustomerRecords records = new CustomerRecords();
       Map<String, Customer> myCustomers = records.getCustomers();
       myCustomers.clear();
    ```
- **Immutable Collections**
  - `Collections.unmodifyableMap`
  - `Collections.unmodifyableList`

### Garbage Collection & Garbage Eligibility
- In other languages we must state when an object is no longer needed by calling a like `free()`.
- Objects that are not freed continue to consume memory ... this is a `memory leak`
- Java avoids memory leak by:
  - Running on a virtual machine
  - Adopts a Garbage Collection strategy
- **Garbage Collection**
  - Any object on the heap which cannot be reached through a reference from the stack is `eligible for garbage collection`
  - *Example:*
    - `Circular References` on the Heap

### Using `Finalize`
- ```
    public void closeFile() {
        file.close()
    }
  
    public void finalize() {
        if(file.isOpen()) {
            logger.warn("It looks like this resource was not closed");
        }
    }
  ```

### Soft Leaks
- An object is referenced on the stack even though it will never be used again.
