package solution;

import java.lang.*;
import java.util.*;

public class Solution {
    public int rob(int[] nums) {
        int preYes = 0;
        int preNo = 0;
        for (int i : nums) {
            int tmp = preNo;
            preNo = Math.max(preNo, preYes);
            preYes = tmp + i;
        }
        return Math.max(preNo, preYes);
    }

    public int rob2(int[] nums) {
        int[][] dp = new int[nums.length + 1][2];
        for (int i = 1; i <= nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = nums[i - 1] + dp[i - 1][0];
        }
        return Math.max(dp[nums.length][0], dp[nums.length][1]);
    }
}