class Solution {
    public int longestCommonSubsequence(String text1, String text2) {  
        int n = text1.length();
        int m = text2.length();
        int dp[][] = new int[n][m];
        for(int i = 0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return Solve(0,text1,0,text2,dp);
        
    }
    private int Solve(int i,String str1,int j,String str2,int[][] dp){
        if(str1.length() <= i || str2.length() <= j){
            return 0;
        }
        if(str1.charAt(i) == str2.charAt(j)){
            return 1 + Solve(i+1,str1,j+1,str2,dp);
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        
        int skipIn1 = Solve(i+1,str1,j,str2,dp);
        int skipIn2 = Solve(i,str1,j+1,str2,dp);

        return dp[i][j] = Math.max(skipIn1,skipIn2);
    }
}