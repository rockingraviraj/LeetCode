class Solution {
    public int minPathSum(int[][] grid) {
        int dp[][] = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            Arrays.fill(dp[i],-1);
        }

        return Solve(grid,dp,0,0);
        
    }
    public int Solve(int[][] grid,int[][] dp ,int row,int col  ){
        if(row>=grid.length || col>=grid[0].length){
            return Integer.MAX_VALUE;
        }
        if(row == grid.length-1 && col == grid[0].length-1){
            return grid[row][col];
        }

        if(dp[row][col]!=-1){
            return dp[row][col];
        }

        int right = Solve(grid,dp,row,col+1);
        int down =  Solve(grid,dp,row+1,col);

        dp[row][col] = grid[row][col] + Math.min(down,right);

        return dp[row][col];
    }
}