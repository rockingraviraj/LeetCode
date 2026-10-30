class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int dp[][] = new int[n+1][m+1];
        // for(int i = 0;i<=n;i++){
        //     Arrays.fill(dp[i],-1);
        // }
        for(int i = 0;i<=n;i++){
            dp[i][0] = i;
        }
        for(int j = 1;j<=m;j++){
            dp[0][j] = j;
        }
        for(int i = 1;i<=n;i++){
            for(int j =1;j<=m;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = 0 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1])) + 1;
                }
            }
        }
        
        return dp[n][m];
        
    }
    // private int Solve(int i,int j,String s,String t,int[][] dp){
    //     if( i<0) return j+1;
    //     if(j<0) return i+1;

    //     if(dp[i][j] != -1){
    //         return dp[i][j];
    //     }

    //     if(s.charAt(i) == t.charAt(j)){
    //         return dp[i][j] = 0 + Solve(i-1,j-1,s,t,dp);
    //     }
    //     int insert = 1+ Solve(i,j-1,s,t,dp);
    //     int delete  = 1 + Solve(i-1,j,s,t,dp);
    //     int replace = 1+ Solve(i-1,j-1,s,t,dp);

    //     return dp[i][j] = Math.min(insert,Math.min(delete,replace));
    // }
}