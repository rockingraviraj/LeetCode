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
    public TreeNode deleteNode(TreeNode root, int key) {
        return Solve(root,key);
        
    }
    public TreeNode Solve(TreeNode root,int key){
        if(root == null){
            return root;
        }
        if(root.val > key){
            root.left = Solve(root.left,key);
        }
        else if(root.val < key){
            root.right = Solve(root.right,key); 
        }
        else if(root.val == key){
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            else{
                if(root.val == key){
                    int lmax = max(root.left);
                    root.left = Solve(root.left,lmax);
                    root.val = lmax;
                }
            }
            
        }
        return root;


        
    }
    public static int max(TreeNode root){
        if(root ==null){
            return Integer.MIN_VALUE;
        }        
			int rmax = max(root.right);
			return Math.max(rmax, root.val);
    }
}