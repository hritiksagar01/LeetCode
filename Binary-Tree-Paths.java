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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ls = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        if( root == null) return ls;
        dfs( root , sb , ls);
        return ls;
    }
    void dfs ( TreeNode root , StringBuilder sb ,List<String> ls){
        if( root == null) return ;
        int len = sb.length(); 

         if (len > 0) sb.append("->");
        sb.append(root.val);

        if (root.left == null && root.right == null) {
        ls.add(sb.toString());
        } else {
            dfs(root.left, sb, ls);
            dfs(root.right, sb, ls);
        } 
      sb.setLength(len); 
    }
}