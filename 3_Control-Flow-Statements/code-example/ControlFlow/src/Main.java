public class Main {
    public static void main(String[] args) {
        /*
         *
         * Switch Statements
         *
         */
        int switchValue = 3;
        switch (switchValue) {
            case 1:
                System.out.println("Value was 1");
                break;
            case 2:
                System.out.println("value was 2");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("was a 3, or a 4, or a 5");
                System.out.println("Actually it was a " + switchValue);
                break;
            default:
                System.out.println("Was not 1 or 2");
                break;
        }

        /*
         *
         * For loop
         *
         */
        for (int i = 0; i < 5; i++) {
            System.out.println("Loop " + i + " hello!");
        }

        /*
         *
         * While loop
         *
         */
        int count = 1;
        while (count != 6) {
            System.out.println("Count value is " + count);
            count++;
        }

        /*
         *
         * do-while loop
         *
         */
        count = 6;
        do {
            System.out.println("Count value was " + count);
            count++;

            if (count > 100) {
                break;
            }
        } while (count != 6);

        /*
         *
         * Parsing values from String
         *
         */
        String numberAsString = "2022";
        // String numberAsString = "2022a"; // this will give an error
        System.out.println("numberAsString = " + numberAsString);
        int number = Integer.parseInt(numberAsString);
        System.out.println("number = " + number);
    }
}