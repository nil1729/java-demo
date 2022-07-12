import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /*
         *
         * Array Declaration
         *
         */
        int[] myIntArray = new int[10]; // {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
        double[] myDoubleArray = new double[10];

//        myIntArray[0] = 45;
//        myIntArray[1] = 46;
//        myIntArray[5] = 50;

        for (int i = 0; i < myIntArray.length; i++) {
            myIntArray[i] = i * 10;
        }
        printArray(myIntArray);

        int[] myIntergers = getIntegers(5);

        printArray(myIntergers);

        System.out.println("The average is " + getAverage(myIntergers));
    }

    public static int[] getIntegers(int number) {
        System.out.println("Enter " + number + " integer values.\r");
        int[] values = new int[number];

        for (int i = 0; i < number; i++) {
            values[i] = scanner.nextInt();
        }

        return values;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Element " + i + ", value is " + array[i]);
        }
    }

    public static double getAverage(int[] array) {
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        return (double) sum / (double) array.length;
    }
}
