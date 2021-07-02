package solution;

import java.util.*;
import java.lang.*;

class WrongSolution {
    public static void main(String[] args) {
        int[] input = new int[] {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11,4,5,6, 7, 15, 8, 9};
        int result = DpSolution.lis(input, input.length);
        System.out.println(result);
    }

    // NOT SURE WHY
    public static int lis(int[] arr, int l) {
        if (l <= 0) {
            return 0;
        }
        if (l == 1) {
            return 1;
        }

        if(arr[l -  1] >= arr[l - 2]) {
            return lis(arr, l - 1) + 1;
        } else {
            return Math.max(lis(arr, l - 1), lis(arr, l - 2) + 1); // TODO: EXPECTING 9, BUT GET 13
        }
    }
}