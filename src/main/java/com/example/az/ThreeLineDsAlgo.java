package com.example.az;

public class ThreeLineDsAlgo {

    public static void main(String[] args) {

    }

    /**
     * The idea is to :
     * 1) reverse the whole array first,
     * 2) then reverse the first n element
     * 3) followed by reversing from n to array.length  - 1;
     *
     *
     * e.g [2,3,4,5,6]
     * 1) Reverse the full array: [6, 5, 4, 3, 2]
     * 2) Reverse the first n  [4, 5, 6, 3, 2]
     * 3) Reverse from index n to last[4,5,6,2,3]
     * @param array
     * @param n
     * @return
     */
    public static int[] circularRotation(int[] array, int n) {

        reverse(array, 0, array.length - 1);
        reverse(array, 0, array.length);
        reverse(array, n, array.length - 1);
        return array;
    }

    private static void reverse(int[] array, int start, int end) {
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
}
