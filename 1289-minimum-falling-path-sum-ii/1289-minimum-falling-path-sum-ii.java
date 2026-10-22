class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int dp[][] = new int[n][n];
        for(int i = 0;i<n;i++){
            Arrays.fill(dp[i],(int) -1e9);
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0;i<n;i++){
            ans = Math.min(ans,Solve(0,i,-1,n,grid,dp));


        }
        return ans;
        
    }
    private int Solve(int i,int j,int last,int n, int [][] grid,int[][]dp){
        if(j<0 || j>=n || j == last){
            return (int) 1e9;
        }
        if(i == n-1){
           return grid[i][j];
        }
        if(dp[i][j] != (int) -1e9){
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;

        for(int k = 0;k<n;k++){
            if(k==j){
                continue;
            }
           int rec = grid[i][j] + Solve(i+1,k,j,n,grid,dp);
           ans = Math.min(ans,rec);
            
        }
        return dp[i][j] = ans;
    }
}
