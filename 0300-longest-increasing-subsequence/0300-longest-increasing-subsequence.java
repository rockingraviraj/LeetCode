class Solution {
    public int lengthOfLIS(int[] nums) {
        int n =  nums.length;
        int dp[][] = new int[n][n+1];
        for(int i =0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
       
        return Solve(n-1,-1,nums,dp);
        
        
    }
    private int Solve(int idx,int last,int[] arr,int[][]dp){
        if(idx < 0){
            return 0;
        }
        if(dp[idx][last+1] != -1){
            return dp[idx][last+1];
        }
        int notpick = 0 + Solve(idx-1,last,arr,dp);
        int pick = 0;
        if(last == -1 || arr[idx] < arr[last]){
            pick =  1 + Solve(idx-1,idx,arr,dp);
        }
        return dp[idx][last+1] = Math.max(pick,notpick);

        
    }
}