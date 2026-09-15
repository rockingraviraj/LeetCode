class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        dp[0][0] = 1;

        if(grid[0][0] == 1) {
           return 0;
        }

        for(int i =0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(i==0 && j==0){
                    continue;
                }
                if(grid[i][j] == 1){
                    continue;
                }
                int up =0;
                int left = 0;
                if(i>0) up = dp[i-1][j];
                if(j>0) left = dp[i][j-1];
                dp[i][j] = up+left;
            }
        }
        return dp[m-1][n-1];


    }
}