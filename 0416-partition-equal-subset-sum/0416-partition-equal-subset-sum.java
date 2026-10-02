class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        

        int sum = 0;
        for(int num : nums){
            sum = sum + num;
        }
        int target = sum/2;
        int index = 0;
        if((sum & 1)==1){
            return false;
        }
        int dp[][] = new int[n][target+1];
        for(int i = 0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }

        boolean ans = Solve(n-1,target,nums,dp);
        return ans;


        
    }
    private static boolean Solve(int index,int target,int [] nums,int[][]dp){
        if(target == 0){
            return true;
        }
        if(index == 0){
            return target == nums[0];
        }
        if(target < 0){
            return false;
        }
        if(dp[index][target] != -1){
            return dp[index][target] == 1;
        }

        
        boolean include = Solve(index - 1,target - nums[index], nums,dp);
        boolean exclude = Solve(index - 1,target,nums,dp);
         if(include || exclude){
            dp[index][target] = 1;
         }
         else{
            dp[index][target] = 0;
         }

         return dp[index][target] == 1;
    }
}