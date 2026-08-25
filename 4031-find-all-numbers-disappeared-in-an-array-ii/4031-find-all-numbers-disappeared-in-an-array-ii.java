class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        List<List<Integer>> ans = new ArrayList<>();
        int st = -1;

        for(int i = lower; i<=upper;i++){
            if(!set.contains(i)){
                if(st == -1){
                    st = i;
                }
            }
                // Mising 
            else{
                if(st != -1){
                    ans.add(Arrays.asList(st,i-1));
                    st = -1;
                }
            }
        }
        if(st != -1 ){
            ans.add(Arrays.asList(st,upper));
        }
        return ans;
        
    }
}