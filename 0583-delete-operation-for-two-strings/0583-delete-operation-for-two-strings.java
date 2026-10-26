class Solution {
    public int minDistance(String s1, String s2) {

        // code here
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n+1][m+1];
        for(int i = 0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        
        return Solve(0,0,s1,s2,dp);
    }
    private static int Solve(int i,int j,String s1,String s2,int[][] dp){
        if(i == s1.length()){
            return s2.length() - j;
        }
        
        if(j == s2.length()){
            return s1.length()-i;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
    
        
        if(s1.charAt(i) == s2.charAt(j)){
            return   Solve(i+1,j+1,s1,s2,dp);
        }
        
        int delete1 = 1 + Solve(i+1,j,s1,s2,dp);
        int delete2 = 1 + Solve(i,j+1,s1,s2,dp);
        
        return dp[i][j] = Math.min(delete1,delete2);
    }

}