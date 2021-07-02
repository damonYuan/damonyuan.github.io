package solution;

import java.lang.*;
import java.util.*;

class Solution {
    public int subsequence(int[] input) {
        return helper(input, 0);
    }

    private int helper(int[] input, int count) {
        if (input.length == 0) {
            return count;
        }
        for (int i = 0; i < input.length; i++) {
            if (doesSatisfy(Arrays.copyOfRange(input, 0, i + 1))) {
                count++;
            }
        }
        return helper(Arrays.copyOfRange(input, 1, input.length), count);
    }

    private boolean doesSatisfy(int[] input) {
        return (max(input) - min(input)) == (input.length - 1);
    }

    private int max(int[] input) {
        int max = Integer.MIN_VALUE;
        for (int i : input) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    private int min(int[] input) {
        int min = Integer.MAX_VALUE;
        for (int i : input) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }
}