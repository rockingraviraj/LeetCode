class Solution {
    public List<List<Integer>> combine(int n, int k) {
        int index = 1;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        Solve(index,ans,out,k,n);
        return ans;

        
    }
    public static void Solve(int index,List<List<Integer>> ans,List<Integer> out,int k,int n){
        if(out.size() == k){
            ans.add(new ArrayList<>(out));
            return;
        }
        for(int i=index;i<=n;i++){         
        out.add(i);
        Solve(i+1,ans,out,k,n);
        out.remove(out.size()-1); 
        }
       

    }
}