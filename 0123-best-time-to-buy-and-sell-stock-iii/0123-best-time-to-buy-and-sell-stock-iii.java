class Solution {
    public int maxProfit(int[] prices) {
    int n = prices.length;
    int buy = Integer.MAX_VALUE;
    int buy2 = Integer.MAX_VALUE;
    int sell  = 0;
    int sell2 = 0;
    for(int i=0;i<n;i++){
        buy = Math.min(buy,prices[i]);
        sell = Math.max(prices[i]-buy,sell);

        buy2 = Math.min(buy2,prices[i]-sell);
        sell2 = Math.max(sell2,prices[i]-buy2);
    }   
     return sell2 ;
        
    }   
}