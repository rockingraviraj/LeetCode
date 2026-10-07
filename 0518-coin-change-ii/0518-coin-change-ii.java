class Solution {
    public int change(int amount, int[] arr) {
        int n = arr.length;
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
   
}