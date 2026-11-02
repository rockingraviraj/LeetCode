class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int dp[][] = new int[n][m];
        for(int i =0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return Solve(n-1,m-1,s,p,dp);
        
    }
    private boolean Solve(int i,int j,String s,String p,int [][] dp ){
        if(j<0 && i<0){
            return true;
        }
        if(j<0 && i >=0) return false;
        if(j>=0 && i<0){
            for(int jj =0;jj<=j;jj++ ){
                if(p.charAt(jj) != '*'){
                    return false;
                }

            }
            return true;
        }
        if(dp[i][j] != -1){
            return dp[i][j] == 1 ;
        }
        if(p.charAt(j) == s.charAt(i) || p.charAt(j) == '?'){
            if(Solve(i-1,j-1,s,p,dp)){
                dp[i][j] = 1;
            }
            else{
                dp[i][j] =0;
            }
        }
        else if(p.charAt(j) == '*'){
            if(Solve(i-1,j,s,p,dp) || Solve(i,j-1,s,p,dp)){
                dp[i][j] = 1;
            }
            else{
                dp[i][j] = 0;
            }
        }
        else{
            dp[i][j] = 0;
        }
        return dp[i][j] == 1;
    }

}