class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1){
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int dp[][] = new int [m][n];
        for(int i =0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return Solve(obstacleGrid,dp,m-1,n-1);
        
    }
    public int Solve(int[][] grid,int[][]dp,int row,int col){
        if(row == 0 && col==0){
            return 1;
        }
        if(row < 0 || col < 0){
            return 0;
        }
        if(grid[row][col] == 1){
            return 0;
        }
        if(dp[row][col] != -1){
            return dp[row][col];
        }

        int up = Solve(grid,dp,row-1,col);
        int left =  Solve(grid,dp,row,col-1);

        dp[row][col] = up + left;


        return dp[row][col];


    }
}