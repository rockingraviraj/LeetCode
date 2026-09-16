class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        for(int i = 0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }

        return Solve(grid,dp,m-1,n-1);
        
    }
    private int Solve(int[][]grid,int[][]dp,int row,int col){
        if(row ==0 && col==0){
            return grid[0][0];
        }
        if(row <0 || col<0){
            return Integer.MAX_VALUE;
        }
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        int up = Solve(grid,dp,row-1,col) ;
        int left =  Solve(grid,dp,row,col-1);

        return dp[row][col] = Math.min(up,left) + grid[row][col];
    }
}