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
    TreeNode node;
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        dfs(root , val);
        return node;
    }
   void  dfs( TreeNode root , int val){
        if( root == null) return;
        if(  root.val > val){
            dfs( root.left , val );
        }
        else if(  root.val < val){
            dfs(root.right , val);
        }
        if( root.val == val){
           node = root;
            return ;
    }
   }
}