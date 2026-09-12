/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        

        Solve(root,targetSum,out,ans);
        return ans;
            
        
        
    }
    static void Solve(TreeNode root,int target,List<Integer> out,List<List<Integer>> ans){
        if(root == null){
                return;
            }
            out.add(root.val);
            if(root.left == null && root.right == null){
                if(target == root.val){
                ans.add(new ArrayList<>(out));
                 out.remove(out.size()-1);
                return; 
                }
            }
            

            Solve(root.right,target - root.val,out,ans);
            Solve(root.left,target - root.val,out,ans);
            

             out.remove(out.size()-1);



            

    

    }
}