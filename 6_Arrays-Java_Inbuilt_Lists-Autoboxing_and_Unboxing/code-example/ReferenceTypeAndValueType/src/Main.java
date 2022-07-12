import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        /*
         *
         * Value Types
         *
         */
        int myIntValue = 10;
        int anotherIntValue = myIntValue;

        System.out.println("myIntValue = " + myIntValue);
        System.out.println("anotherIntValue = " + anotherIntValue);

        anotherIntValue++;

        System.out.println("myIntValue = " + myIntValue);
        System.out.println("anotherIntValue = " + anotherIntValue);

        /*
         *
         * Reference Type
         *
         */
        int[] myIntArray = new int[5];
        int[] anotherArray = myIntArray;

        System.out.println("myIntArray = " + Arrays.toString(myIntArray));
        System.out.println("anotherArray = " + Arrays.toString(anotherArray));

        anotherArray[0] = 1;

        System.out.println("after change myIntArray = " + Arrays.toString(myIntArray));
        System.out.println("after change anotherArray = " + Arrays.toString(anotherArray));

        modifyArray(myIntArray);

        System.out.println("after modify myIntArray = " + Arrays.toString(myIntArray));
        System.out.println("after modify anotherArray = " + Arrays.toString(anotherArray));

        anotherArray = new int[] {10, 20, 30, 40, 50}; // dereference
        modifyArray(myIntArray);

        System.out.println("2nd modification myIntArray = " + Arrays.toString(myIntArray));
        System.out.println("2nd modification anotherArray = " + Arrays.toString(anotherArray));
    }

    public static void modifyArray(int[] array) {
        array[0] = 2;
        array = new int[] {1, 2, 3, 4, 5}; // dereference
    }
}
