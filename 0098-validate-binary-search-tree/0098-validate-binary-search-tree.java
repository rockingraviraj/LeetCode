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
    public boolean isValidBST(TreeNode root) {
        return Solve(root).isbst;
        
    }
    public Pair Solve(TreeNode root){
        if(root == null){
            return new Pair();
        }
        Pair lbp = Solve(root.left);
        Pair rbp = Solve(root.right);
        Pair sbp = new Pair();
        sbp.min = Math.min(lbp.min,Math.min(rbp.min,root.val));
        sbp.max = Math.max(lbp.max,Math.max(rbp.max,root.val));
        if(lbp.isbst && rbp.isbst && lbp.max < root.val && rbp.min > root.val){
            sbp.isbst = true;
        }
        else{
            sbp.isbst = false;
        }
    
    return sbp;
    }

}
class Pair{
    boolean isbst = true;
    long min = Long.MAX_VALUE;
    long max = Long.MIN_VALUE;
}