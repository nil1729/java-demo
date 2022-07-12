import java.util.ArrayList;

class intClass {
    private int myValue;

    public intClass(int myValue) {
        this.myValue = myValue;
    }

    public int getMyValue() {
        return myValue;
    }

    public void setMyValue(int myValue) {
        this.myValue = myValue;
    }
}

public class Main {
    public static void main(String[] args) {
        String[] strArray = new String[10];
        int[] intArray = new int[10];

        ArrayList<String> stringArrayList = new ArrayList<String>();
        stringArrayList.add("Tim");

        // Type argument cannot be of primitive type
        // ArrayList<int> intArrayList = new ArrayList<int>();

        // Using Wrapper class
        ArrayList<intClass> intClassArrayList = new ArrayList<intClass>();
        intClassArrayList.add(new intClass(1729));

        // Integer and Double
        Integer integer = new Integer(1729);
        Double doubleValue = new Double(55.55);

        ArrayList<Integer> integerArrayList = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            integerArrayList.add(Integer.valueOf(i)); // autoboxing
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " --> " + integerArrayList.get(i).intValue()); // unboxing
        }

        Integer myIntValue = 1729; // Integer.valueOf(1729); // autoboxing
        int myInt = myIntValue; // myIntValue.intValue(); // unboxing

        ArrayList<Double> doubleArrayList = new ArrayList<Double>();
        for (double dbl = 0.0; dbl < 10.0; dbl += 0.5) {
            doubleArrayList.add(dbl);
        }
        for (int i = 0; i < doubleArrayList.size(); i++) {
            System.out.println(i + " --> " + doubleArrayList.get(i));
        }
    }
}
