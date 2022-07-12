public class DataTypeClass {
    public static void main(String[] args) {
        int myValue = 1729;

        int myMinIntValue = Integer.MIN_VALUE;
        int myMaxIntValue = Integer.MAX_VALUE;

        System.out.println("Integer Minimum Value " + myMinIntValue);
        System.out.println("Integer Maximum Value " + myMaxIntValue);
        System.out.println("Busted Minimum Value " + (myMinIntValue - 1));
        System.out.println("Busted Maximum Value " + (myMaxIntValue + 1));

        int myMaxIntTestValue = 2_147_483_647;

        byte myMinByteValue = Byte.MIN_VALUE;
        byte myMaxByteValue = Byte.MAX_VALUE;
        System.out.println("Byte Minimum Value " + myMinByteValue);
        System.out.println("Byte Maximum Value " + myMaxByteValue);

        short myMinShortValue = Short.MIN_VALUE;
        short myMaxShortValue = Short.MAX_VALUE;
        System.out.println("Short Minimum Value " + myMinShortValue);
        System.out.println("Short Maximum Value " + myMaxShortValue);

        long myLongValue = 100L;
        long myMinLongValue = Long.MIN_VALUE;
        long myMaxLongValue = Long.MAX_VALUE;
        System.out.println("Long Minimum Value " + myMinLongValue);
        System.out.println("Long Maximum Value " + myMaxLongValue);
        long bigLongLiteralValue = 2_147_483_647_123L;
        System.out.println(bigLongLiteralValue);

        int myTotal = (myMinIntValue / 2);
        // this will give an error;
        // byte myNewByteValue = (myMinByteValue / 2);
        byte myNewByteValue = (byte)(myMinByteValue / 2);

        /*
         *
         * Floating Point Numbers
         *
         */
        float myMinFloatValue = Float.MIN_VALUE;
        float myMaxFloatValue = Float.MAX_VALUE;
        System.out.println("Float Minimum Value " + myMinFloatValue);
        System.out.println("Float Maximum Value " + myMaxFloatValue);

        double myMinDoubleValue = Double.MIN_VALUE;
        double myMaxDoubleValue = Double.MAX_VALUE;
        System.out.println("Double Minimum Value " + myMinDoubleValue);
        System.out.println("Double Maximum Value " + myMaxDoubleValue);

        int myIntValue = 5 / 2;
        float myFloatValue = 5f / 2f;
        // float example
        // float myFloatValue = 5.5f // (float)(5.5)
        double myDoubleValue = 5d / 2d;

        System.out.println("MyIntValue " + myIntValue);
        System.out.println("MyFloatValue " + myFloatValue);
        System.out.println("MyDoubleValue " + myDoubleValue);

        /*
         *
         * Char and Boolean
         *
         */
        char myChar = 'N';
        char myUnicodeChar = '\u004E';
        System.out.println(myChar);
        System.out.println(myUnicodeChar);

        boolean myTrueBooleanValue = true;
        boolean myFalseBooleanValue = false;

        /*
         *
         * Primitive Data Types
         *
         * byte
         * short
         * int
         * long
         * float
         * double
         * char
         * boolean
         *
         */

        String myString = "This is a String";
        System.out.println("myString is equal to " + myString);
        myString = myString + ", and this is more.";
        System.out.println("myString is equal to " + myString);
        String numberString = "250.55";
        numberString = numberString + "49.95";
        System.out.println(numberString);
        String lastString = "10";
        int myInt = 50;
        lastString = lastString + myInt;
        System.out.println("lastString is equal to " + lastString);
        double doubleNumber = 120.25d;
        lastString = lastString + doubleNumber;
        System.out.println("lastString is equal to " + lastString);

    }
}
