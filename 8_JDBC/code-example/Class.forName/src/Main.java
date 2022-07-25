// Class.forName(); // Load the Class

import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args)
            throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            SQLException
    {
        ExampleClass exampleClass = new ExampleClass(); // ----------------------> Line 1
        Class.forName("ExampleClass");  // ----------------------------> Line 2
        Class.forName("ExampleClass").newInstance();  // --------------> Line 3

        /**
         *
         * Only Line 1:
         *  ---> In static block
         *  ---> In instance block
         *
         *  Only Line 2:
         *  ---> In static block
         *
         *  Only Line 3:
         *  ---> In static block
         *  ---> In instance block
         *
         */


        /**
         *
         * DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
         * do the same with `Class.forName("com.mysql.cj.jdbc.Driver");`
         *
         *  Driver class
         *  ....
         *     static {
         *         try {
         *             DriverManager.registerDriver(new Driver());
         *         } catch (SQLException var1) {
         *             throw new RuntimeException("Can't register driver!");
         *         }
         *     }
         *  ....
         *
         */
    }
}

class ExampleClass {
    static  {
        System.out.println("In static block");
    }

    // instance
    {
        System.out.println("In instance block");
    }

}