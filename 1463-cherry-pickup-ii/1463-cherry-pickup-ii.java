class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int row = 0;
        int dp[][][] = new int[n][m][m];
        for (int i = 0; i < n; i++) {
           for (int j = 0; j < m; j++) {
                   Arrays.fill(dp[i][j], -1);
                }
            }
        return Solve(row,0,m-1,grid,dp);
        
    }
    private int Solve(int row,int col1,int col2,int[][]grid,int[][][] dp ){
        if(col1 < 0 || col1>=grid[0].length || col2 < 0 || col2 >=grid[0].length){
            return -1000000000;
        }
        if(dp[row][col1][col2] != -1){
            return dp[row][col1][col2];
        }
        if(row == grid.length-1){
            if(col1 == col2){
                return grid[row][col1];
            }
            else{
                return grid[row][col1] + grid[row][col2];
            }
        }

        int maxi = 0;

        for(int r1 = -1;r1<=1;r1++){
             for(int r2 = -1;r2<=1;r2++){
                if(col1 == col2){
                    maxi = Math.max(maxi,grid[row][col1] + Solve(row+1,col1+r1,col2+r2,grid,dp));
                }
                else{
                    maxi = Math.max(maxi,grid[row][col1]+grid[row][col2] + Solve(row+1,col1+r1,col2+r2,grid,dp) );
                }

                dp[row][col1][col2] = maxi;

            }
        }
        return dp[row][col1][col2];

    }
}