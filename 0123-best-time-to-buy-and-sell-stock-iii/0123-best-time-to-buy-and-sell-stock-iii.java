class Solution {
    public int maxProfit(int[] prices) {
    int n = prices.length;
    int buy = 1;
    int cap = 2;
    int dp[][][] = new int [n][2][3];

    for(int i = 0;i<n;i++){
        for(int j =0;j<2;j++){
            Arrays.fill(dp[i][j],-1);
        }
    }

    return Solve(0,prices,buy,cap,dp);
        
    }   
    private int Solve(int ind,int[] prices,int buy,int cap,int [][][]dp){
        if(ind == prices.length) return 0;
        if(cap == 0) return 0;

        if(dp[ind][buy][cap] != -1){
            return dp[ind][buy][cap] ;
        }
        int profit = 0;
        if(buy == 1){
            profit = Math.max(-prices[ind] + Solve(ind+1,prices,0,cap,dp),0+Solve(ind+1,prices,1,cap,dp));
        }
        else{
            profit = Math.max(prices[ind] + Solve(ind+1,prices,1,cap-1,dp),0+Solve(ind+1,prices,0,cap,dp));
        }
        return dp[ind][buy][cap] = profit;

    }
}