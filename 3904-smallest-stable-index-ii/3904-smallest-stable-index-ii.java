class Solution {
    public int firstStableIndex(int[] nums, int t) {
      int n= nums.length;
         int max[] = new int[n];
         int min[] = new int[n];

        max[0] = nums[0];
        for(int i= 1;i<n;i++){
            max[i] = Math.max(max[i-1],nums[i]);}

        min[n-1] = nums[n-1];
        for(int i = n-2;i>=0;i--){
            min[i] = Math.min(min[i+1],nums[i]);}
        
    
          for(int j = 0;j<n;j++){
            
            if((max[j] - min[j]) <= t){
                return j;
            }
        }
        return -1;
    }
}