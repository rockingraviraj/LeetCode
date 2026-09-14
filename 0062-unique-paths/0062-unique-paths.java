class Solution {
    public int uniquePaths(int m, int n) {
        int path[][] = new int [m][n];
        int dp[][] = new int[m][n];
        for(int i = 0;i<m;i++){
            Arrays.fill(dp[i],-1);

        }
        
        return Solve(dp,path,m-1,n-1);
    }
    private int Solve(int[][] dp,int [][] path,int row,int col ){
        if(row == 0 && col == 0){
            return 1;
        }
        if(row<0 || col<0){
            return 0;
        }
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        int up = Solve(dp,path,row-1,col);
        int left = Solve(dp,path,row,col-1);
        dp[row][col]= up+left;

        return dp[row][col];

    }
}