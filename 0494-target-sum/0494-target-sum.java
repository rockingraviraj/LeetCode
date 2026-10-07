class Solution {
    public int findTargetSumWays(int[] arr, int target) {
        int n = arr.length;
        int totsum = 0;
        for(int i = 0;i<n;i++){
            totsum = totsum+arr[i];
        }
        int s1 = (totsum - target)/2;
        if((totsum - target) %2 != 0 || (totsum - target) < 0){
            return 0;
        }
        return solve(n-1,arr,s1);
        
    }
    private int solve(int index,int[] arr,int target){
        if(index == 0){
            if(target ==0 && arr[0] ==0){
                return 2;
            }
            if(target == arr[0]||target ==0){
                return 1;
            }
            else{
                return 0;
            }
        }

        int include = 0;
        int exclude = solve(index-1,arr,target);
        if(target >= arr[index]){
            include = solve(index-1,arr,target-arr[index]);
        }
        return include + exclude;

    }
}