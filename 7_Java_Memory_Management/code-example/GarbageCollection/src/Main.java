public class Main {
    public static void main(String[] args) {
        /*
         *
         * Memory Management
         *
         */
        String one = "Hello";
        String two = "Hello";

        if (one == two) {
            System.out.println("they are the same object");
        } else {
            System.out.println("they are different objects");
        }

        String three = new Integer(76).toString();
        String four = "76";
        String five = new Integer(76).toString().intern();

        if (three == four) {
            System.out.println("they are the same object");
        } else {
            System.out.println("they are different objects");
        }

        if (four == five) {
            System.out.println("they are the same object");
        } else {
            System.out.println("they are different objects");
        }

        /*
         *
         * Using gc methods
         *
         */
        Runtime runtime = Runtime.getRuntime();

        long availableBytes = runtime.freeMemory();
        System.out.println("Available memory: " + (availableBytes / 1024) + " K");

        // let's create ton of garbage
        for (int i = 0; i < 100; i++) {
            Customer c;
            c = new Customer("John");
        }

        availableBytes = runtime.freeMemory();
        System.out.println("Available memory: " + (availableBytes / 1024) + " K");

        System.gc();

        availableBytes = runtime.freeMemory();
        System.out.println("Available memory: " + (availableBytes / 1024) + " K");
    }
}
