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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
         return Solve(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
        
    }
    public TreeNode Solve(int[]pre,int plo,int phi,int[] ino,int Ilo,int Ihi){
        if(plo > phi || Ilo > Ihi){
            return null;
        }
        TreeNode node = new TreeNode(pre[plo]);

        int idx = Search(ino,Ilo,Ihi,pre[plo]);
        int ne = idx - Ilo;
        node.left = Solve(pre,plo+1,plo+ne,ino,Ilo,idx);
        node.right = Solve(pre,plo+ne+1,phi,ino,idx+1,Ihi);
        return node;
    }
    private int Search(int[] arr,int st,int end,int value){
        for(int i = st;i<=end;i++){
            if(value == arr[i]){
                return i;
                
            }
        }
        return -1;
    }
}