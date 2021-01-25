


public class DriveTime {
    // Write a function that takes an array of integers as a parameter and returns a copy of the input array where
    // all elements have been shifted 1 index to the left.
    // Example:
    // input        ouput
    // [1, 2, 3] -> [2, 3, 1]
    // [5, 13, 11, 0] -> [13, 11, 0, 5]
    // NOTE: Your function should NOT modify the input array

    public int[] shiftOne (int[] arr, int n) {

        if (arr == null) return new int[0];

        int[] result = new int [arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (i - n < 0) {
                result[i - n + arr.length] = arr[i];
                continue;
            }
            result[i - n] = arr[i];
        }

        return result;
    }
}
