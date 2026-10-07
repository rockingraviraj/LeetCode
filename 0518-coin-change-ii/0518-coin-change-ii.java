class Solution {
    public int change(int amount, int[] arr) {
        int n = arr.length;
        int totsum = 0;
        // int dp[][] = new int[n][amount+1];
        // for(int i =0;i<n;i++){
        //     Arrays.fill(dp[i],-1);
        // }

        int[]  prev = new int[amount+1];
        int[]curr = new int[amount+1];
        for(int t = 0;t<=amount;t++){
            if(t%arr[0] == 0 || t == 0){
                prev[t] = 1;
            }
            else{
                prev[t] = 0;
            }
        }

        for(int i = 1;i<n;i++){
            for(int target = 0;target<=amount;target++){
                int pick = 0;
                int no= prev[target];
                if(target>=arr[i]){
                    pick = curr[target - arr[i]];

                }
                curr[target] = pick + no;
                    }
                    prev = curr;
        }

      
        return prev[amount];
    }
    private int Solve(int i , int[] arr,int target,int[][]dp){
        if(i==0){
            if(target % arr[0] == 0 || target==0){
                return 1;
            }
            else{
                return 0;
            }
        }
        if(dp[i][target]!=-1){
            return dp[i][target];
        }

        int pick = 0;
        int no = Solve(i-1,arr,target,dp);

        if(arr[i]<=target){
            pick = Solve(i,arr,target-arr[i],dp);
        }

        return dp[i][target] = pick + no;
    }
}