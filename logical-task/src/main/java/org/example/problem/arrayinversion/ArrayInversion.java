package org.example.problem.arrayinversion;

/**
 * @author Bibash Bogati
 * @created 2024-12-11
 */

public class ArrayInversion {
    public static int countInversions(int[] arr) {
        // Any divide and conquer algorithm such as quick sort can be used for better performence
        int n = arr.length;
        int inversionCount = 0;

        // Compare each pair (i, j) where i < j
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    inversionCount++; // Increment count if A[i] > A[j]
                    System.out.printf("------------\n Value %d is greater than value %d . So we need to inverse to order %n", arr[i], arr[j]);
                    System.out.printf("Reached Count is %d \n", inversionCount);
                }
            }
        }

        return inversionCount;
    }

    public static void main(String[] args) {
        int[] arr = {1, 9, 6, 4, 5};
        int result = countInversions(arr);
        System.out.println("Total number of inversions: " + result);
    }
}
