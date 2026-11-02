class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n];
        for(int i = 0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }

        return Solve(0,n-1,nums,dp)>=0;

        

    }
         private int Solve(int i,int j,int[] arr,int[][] dp){
                if (i > j) {
                   return 0;
               }

               if (i == j) {
                   return arr[i];
               }

               
			
			if(dp[i][j] != -1){
			    return dp[i][j];
			}
			
			int val1 = arr[i] - Solve(i+1,j,arr,dp);
			int val2 = arr[j] - Solve(i,j-1,arr,dp);
			
			return dp[i][j] = Math.max(val1,val2);


    }
}