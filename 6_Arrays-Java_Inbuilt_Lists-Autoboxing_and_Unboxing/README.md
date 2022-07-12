### Arrays
- An array is a data structure that allows us to store multiple values of the same type into a single variable.
- The default values of numeric array elements are set to `zero`.
- Arrays are `zero indexed`: an array with `n elements` is indexed `from o to n-1`; for example `10 elements index range is from 0 to 9`.
- If we try to access index that is out of range Java will give us an `ArrayIndexOutOfBoundsException`, which indicates that the index is out of range in other words out of bounds.
- To access array elements we use the square braces `[` and `]`, also known as array access operator.

### Example of creating new array
- ```
    int[] array = new int[5];
  ```
- This array contains the elements from `array[0]` to `array[4]`.
- It has `5 elements` and index range `0` to `4`.
- The `new` operator or keyword is used to create the array and initialize the array elements to their default values.
- In this example, all the array elements are initialized to zero since this is an int array.
- For `boolean` array they would be initialized to `false`.
- For `string or other objects` that would be `null`.
- ```
    int[] myNumbers = {1, 2, 3, 4, 5};
  ```
- We can also initialize an array inline by using array initializer block `{` and `}`. Values we defined need to be separated by a comma.
- This way of initializing an array is also known as an `anonymous array`.
- It has `5 elements` and index range `0` to `4`.
- In this example, array elements are initialized to `1, 2, 3, 4, 5`.
- **1st Common Error**
  - Accessing index out of range will cause error in other words `ArrayIndexOutOfBoundException`
  - We have `5 elements` and `index range is 0 to 4`
- **2nd Common Error**
  - ```
        int[] myArray = {1, 2, 3, 4, 5};
        for(int i = 1; i < myArray.length; i++) { // i should not start from 1
            System.out.println("value= " + myArray[i]);
        }
    ```
- **3rd Common Error**
  - ```
        int[] myArray = {1, 2, 3, 4, 5};
        for(int i = 1; i <= myArray.length; i++) { // i should not be equal to myArray.length
            System.out.println("value= " + myArray[i]);
        }
    ```

