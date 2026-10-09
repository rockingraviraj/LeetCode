class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int dp[] = new int[n];
      
            Arrays.fill(dp,-1);
        
        return solve(0, days, costs,dp);
    }

    private int solve(int i, int[] days, int[] costs,int[] dp) {
        if (i >= days.length) {
            return 0;
        }
       if(dp[i]!=-1){
        return dp[i];
       }

        int j = i;
        while (j < days.length && days[j] < days[i] + 1) {
            j++;
        }
        int one = costs[0] + solve(j, days, costs,dp);

        j = i;
        while (j < days.length && days[j] < days[i] + 7) {
            j++;
        }
        int seven = costs[1] + solve(j, days, costs,dp);

        j = i;
        while (j < days.length && days[j] < days[i] + 30) {
            j++;
        }
        int thirty = costs[2] + solve(j, days, costs,dp);

        return dp[i] = Math.min(one, Math.min(seven, thirty));
    }
}