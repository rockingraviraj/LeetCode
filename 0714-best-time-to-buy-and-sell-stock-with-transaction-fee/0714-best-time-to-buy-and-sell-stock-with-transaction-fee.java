class Solution {
    public int maxProfit(int[] prices, int fee) {
               int n = prices.length;
        int buy = 1;
        int dp[][] = new int [n][2];
        for(int i = 0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }

        return Solve(0,1,fee,prices,dp);

        
    }
    private int Solve(int ind,int trans,int fee,int[] prices,int [][]dp){
        if(ind >= prices.length ) return 0;

        if(dp[ind][trans] != -1) return dp[ind][trans];
        int profit = 0;

        if(trans == 1){

            dp[ind][trans] = Math.max(-prices[ind] + Solve(ind+1,0,fee,prices,dp), 0 + Solve(ind+1,1,fee,prices,dp));

        }
        else{
            dp[ind][trans] = Math.max(prices[ind] - fee + Solve(ind+1,1,fee,prices,dp),0 + Solve(ind+1,0,fee,prices,dp));
        }
        return dp[ind][trans] ;
        
    }
        
    }
