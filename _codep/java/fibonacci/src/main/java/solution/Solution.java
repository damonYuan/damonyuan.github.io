package solution;

import java.lang.*;
import java.util.*;

class Solution {
    public static long fibonacci(long n) {
        return _fibonacciHelper(n)[0];
    }

    private static long[] _fibonacciHelper(long n) {
        if (n <= 1) {
            return new long[] {1, 0};
        } else {
            long[] tmp = _fibonacciHelper(n - 1);
            return new long[] {tmp[0] + tmp[1], tmp[0]};
        }
    }

    public static long dpFibonacci(int n) {
        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}