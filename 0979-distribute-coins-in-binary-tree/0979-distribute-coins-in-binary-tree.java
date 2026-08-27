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
    int count = 0;
    public int distributeCoins(TreeNode root) {
        Solve(root);
        return count;
        
    }
    public int Solve(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = Solve(root.left);
        int r = Solve(root.right);
        count = count + Math.abs(r) + Math.abs(l);
        return r + l + root.val - 1;
    }
}