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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> li1 = new ArrayList<>();
        List<Integer> li2 = new ArrayList<>();
        if( root1 == null || root2 == null) return false;
                dfs(root1 , li1);
                dfs(root2, li2);
                if( li1.equals(li2)){
                    return true;
                }
                return false;
    }
  void  dfs( TreeNode root , List<Integer> list){
        if( root == null) return;

       
        if( root.left == null && root.right == null){
            list.add(root.val);
        }
        else{
            dfs( root.left , list);
            dfs( root.right , list);
        }
    }
}