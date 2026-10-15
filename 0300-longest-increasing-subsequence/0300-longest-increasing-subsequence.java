
import java.util.*;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return Solve(0, -1, nums, dp);
    }

    private int Solve(int idx, int prev, int[] nums, int[][] dp) {
        if (idx == nums.length) {
            return 0;
        }

        if (dp[idx][prev + 1] != -1) {
            return dp[idx][prev + 1];
        }

        int notTake = Solve(idx + 1, prev, nums, dp);

        int take = 0;

        if (prev == -1 || nums[idx] > nums[prev]) {
            take = 1 + Solve(idx + 1, idx, nums, dp);
        }

        return dp[idx][prev + 1] = Math.max(take, notTake);
    }
}
