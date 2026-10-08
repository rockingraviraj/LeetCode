class Solution {
    public int rob(int[] arr) {
        int n = arr.length;
        int dp[] = new int[n+1]; 
        // Arrays.fill(dp,-1);
        for(int i = 0;i<n;i++){
            
             int in = arr[i];
            if(i>1){
                in = arr[i] + dp[i-2];

            }
            int ex = 0;
            if(i>0){
                ex = 0 + dp[i-1];
            }
            dp[i] = Math.max(in,ex);
        }


        // int ans = Solve(n-1,arr',dp);
         return dp[n-1];
        
    }
    private int Solve(int index,int[] arr,int[]dp){
        if(index<0){
            return 0;
        }
        if(dp[index]!= -1){
            return dp[index];
        }
        int include = arr[index] + Solve(index-2,arr,dp);
        int exclude = 0 + Solve(index-1,arr,dp);
        return dp[index] = Math.max(include,exclude);
    }
}