class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][]  = new int[n][amount+1];

        for(int i = 0;i<n;i++){
            Arrays.fill(dp[i] ,-1);
        } 
        int ans = -1;
        int f = Solve(n-1,coins, amount,dp);

        if(  f == (int) 1e9){
           return ans;}
           return f;
        
    }
    private int Solve(int index,int[] arr,int target,int[][] dp){
        if(target == 0){
            return 0;
        }
        if(index == 0){
            if(target % arr[0] == 0){
                return target/arr[0];
            }
            else{
                return (int) 1e9;
            }
        }
        if(dp[index][target] != -1){
            return dp[index][target];
        }
        int notpick = 0 + Solve(index-1,arr,target,dp);
        int pick = Integer.MAX_VALUE;
        if(target>=arr[index]){
            pick = 1+Solve(index,arr,target-arr[index],dp);
        }
        dp[index][target] = Math.min(pick,notpick);
        return dp[index][target];
    }
}