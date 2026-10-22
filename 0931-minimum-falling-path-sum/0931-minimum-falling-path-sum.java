class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int dp[][] = new int[n][n];
        for(int i = 0;i<n;i++){
            Arrays.fill(dp[i],(int) -1e9);
        }
        int ans = Integer.MAX_VALUE;

        for(int i = 0;i<n;i++){
            ans = Math.min(ans,Solve(0,i,n,matrix,dp));

        }
        return ans;
        
    }
    private int Solve(int i,int j,int n,int[][] matrix,int[][] dp){
        if(j<0 || j>=n){
            return (int) 1e9;
        }
        if(i == n-1){
            return matrix[i][j];
        }
        if(dp[i][j] != (int) -1e9){
            return dp[i][j];
        }
        int leftd = matrix[i][j] + Solve(i+1,j-1,n,matrix,dp);
        int down  = matrix[i][j] + Solve(i+1,j,n,matrix,dp);
        int rightd = matrix[i][j] + Solve(i+1,j+1,n,matrix,dp);

        return dp[i][j] = Math.min(leftd,Math.min(down,rightd));


    }
}