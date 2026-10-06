class Solution {
    public int coinChange(int[] arr, int amount) {
        int n = arr.length;
        int target = amount;
        // int dp[][]  = new int[n][amount+1];

        // for(int i = 0;i<n;i++){
        //     Arrays.fill(dp[i] ,-1);
        // } 
        // dp[n][0] = 0;
        int prev[] = new int[target+1];
        int curr[] = new int[target+1];

        for(int T = 0;T<=target;T++){
            if(T % arr[0] == 0){
                prev[T] = T/arr[0];
            }
            else{
                prev[T] = (int) 1e9;
            }
        }

        for(int i = 1;i<n;i++){
            for(int t= 0;t<=target;t++){
                int notpick = prev[t];
                int pick = (int) 1e9;
                if(t>=arr[i]){

                 pick = 1+curr[t-arr[i]];}

                 curr[t] = Math.min(pick,notpick);
            }
            prev= curr;

        }



        int ans = -1;
        int f = prev[target];

        if(  f == (int) 1e9){
           return ans;}
           return f;
        
    }
    private int Solve(int index,int[] arr,int target,int[][] dp){
        if(target == 0){
            return 0;
        }
        if(index == 0){
            if(target % arr[0] == 0){
                return target/arr[0];
            }
            else{
                return (int) 1e9;
            }
        }
        if(dp[index][target] != -1){
            return dp[index][target];
        }
        int notpick = 0 + Solve(index-1,arr,target,dp);
        int pick = Integer.MAX_VALUE;
        if(target>=arr[index]){
            pick = 1+Solve(index,arr,target-arr[index],dp);
        }
        dp[index][target] = Math.min(pick,notpick);
        return dp[index][target];
    }
}