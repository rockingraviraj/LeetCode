
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int last = -1; last < n; last++) {
                int notpick = dp[i + 1][last + 1];

                int pick = 0;

                if (last == -1 || nums[i] > nums[last]) {
                    pick = 1 + dp[i + 1][i + 1];
                }

                dp[i][last + 1] = Math.max(pick, notpick);
            }
        }

        return dp[0][0];
    }
}
