class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int buy = 1;
        int dp[][] = new int [n][2*k];
        for(int i = 0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }

        return Solve(0,0,k,prices,dp);

        
    }
    private int Solve(int ind,int trans,int k,int[] prices,int [][]dp){
        if(ind == prices.length || trans == 2*k) return 0;

        if(dp[ind][trans] != -1) return dp[ind][trans];
        int profit = 0;

        if(trans % 2 == 0){

            dp[ind][trans] = Math.max(-prices[ind] + Solve(ind+1,trans+1,k,prices,dp), 0 + Solve(ind+1,trans,k,prices,dp));

        }
        else{
            dp[ind][trans] = Math.max(prices[ind] + Solve(ind+1,trans+1,k,prices,dp),0 + Solve(ind+1,trans,k,prices,dp));
        }
        return dp[ind][trans] ;
    }
}