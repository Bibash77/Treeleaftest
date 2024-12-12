package org.example.problem.equalsum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Bibash Bogati
 * @created 2024-12-11
 */

/* Q2. Write a program to find all n-digit numbers with an equal sum where n varies from 1 to 9 and sum <= 81 (Maximum possible sun in a 9-digit number).
Eg: 5–digit numbers with sum 42 are
69999 78999 79899 79989 79998 87999 88899 88989 88998 89799 89889 89898 89979 89988 89997 96999 97899 97989 97998 98799 98889 98898 98979 98988 98997 99699 99789 99798 99879 99888
        99897 99969 99978 99987 99996 */

public class EqualSumProblem {
    /*
     -------Basic Idea ---------
   - Since we need to find all possible sum until 81 and how many numbers combination can make it up from
     we can put data in map for each number sum and put the numbers that sums up as list of value in map

     Now the trick to find n numbers  permutation
     eg: 2 means 10- 99 .but excluding zero it would be 11-99 without having zero number / we can simply omit if it contains zero in the loop
     Now we can loop start value to end  and check for its individual sum
     */

    public static void main(String[] args) {
        int n = 2;
        Map<Integer, List<String>> sumMap = findNDigitWithEqualSum(n);
        sumMap.forEach((key, v) -> {
            System.out.println("Possible combination for key " + key);
            v.forEach(System.out::println);
        });
    }

    private static Map<Integer, List<String>> findNDigitWithEqualSum(int n) {
        HashMap<Integer, List<String>> sumMap = new HashMap<>();
        int start = (int) Math.pow(10, n - 1);  // Smallest n-digit number (e.g., 100 for n=3)
        int end = (int) (Math.pow(10, n) - 1);


        for (int num = start; num <= end; num++) {
            String numStr = String.valueOf(num);
            if (numStr.contains("0")) {
                System.out.println("--- Excluding number containing Zero " + numStr);
            }
            int sum = 0;
            for (char digit : numStr.toCharArray()) {
                sum += digit - '0';  // Sum the digits
            }

            // if sum is less than 81 add the digit
            if (sum <= 81) {
                sumMap.computeIfAbsent(sum, k -> new ArrayList<>()).add(numStr);
            }

        }

        return sumMap;
    }
}
