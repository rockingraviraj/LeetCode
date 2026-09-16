class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        boolean[] used = new boolean[m];
        ArrayList<Integer> mylist = new ArrayList<>();
       for(int i =0;i<n;i++){
        for(int j =0;j<m;j++){
            if(!used[j] && nums1[i]==nums2[j]){
                mylist.add(nums1[i]); 
               used[j] = true;
                break;}
            }
        }
        int arr[] = new int[(mylist.size())];
        for(int i =0;i<mylist.size();i++){
            arr[i] = mylist.get(i);
        }
        
       
       return arr;
}
}