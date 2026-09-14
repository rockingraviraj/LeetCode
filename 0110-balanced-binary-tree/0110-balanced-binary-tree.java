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
        return Solve(root).isbal;
        
    }
    public BalPair  Solve(TreeNode root){
        if(root == null){
            return new BalPair();
        }

        BalPair lbt = Solve(root.left);
        BalPair rbt = Solve(root.right);
        BalPair sdp = new BalPair();
        boolean balance =  Math.abs(lbt.ht - rbt.ht) <=1;
        sdp.ht = Math.max(lbt.ht,rbt.ht) + 1;
        sdp.isbal = balance && lbt.isbal && rbt.isbal;
        return sdp; 
    }

class BalPair{
    int ht = -1;
    boolean isbal = true;
}
}