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
    public boolean isBalanced(TreeNode root) {

        return Solve(root);
        
    }
    public boolean Solve(TreeNode root){
        if(root == null){
            return true;
        }
        boolean left = Solve(root.left);
        boolean right = Solve(root.right);
        if(left && right && Math.abs(ht(root.left) - ht(root.right)) <=1){
            return true;
        }
        return false;

    }
    public int ht(TreeNode root){
        if(root == null){
            return -1;
        }
        int left = ht(root.left);
        int right = ht(root.right);
        return Math.max(left,right) + 1;
    }
}