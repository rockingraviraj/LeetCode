class Solution {
    public int minimumTotal(List<List<Integer>> tri) {
        int n = tri.size();
        int dp[][] = new int[n][n];
        dp[0][0] = tri.get(0).get(0);
        
        
       for(int i = 0;i<n;i++){
        for(int j = 0;j<i+1;j++){
            if(i == 0){
                continue;
            }
            int down = Integer.MAX_VALUE;
            int ldd = Integer.MAX_VALUE;
            if(i>j){
             down = tri.get(i).get(j) + dp[i-1][j];}
            if( j>0){
                ldd = tri.get(i).get(j) +  dp[i-1][j-1];

            }

            dp[i][j] = Math.min(down,ldd);

        }
       }
       int ans = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, dp[n - 1][j]);
        }

        return ans;
    }
   
}