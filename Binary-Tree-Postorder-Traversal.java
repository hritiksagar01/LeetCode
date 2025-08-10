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
    public List<Integer> postorderTraversal(TreeNode root) {
          List<Integer> result = new ArrayList<>();
        postorder( root , result);
        return result;
    }
    public void postorder(TreeNode root , List<Integer> result){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr= root;
        while(curr != null || !stack.isEmpty()){
            while( curr != null){
                result.add(0 ,curr.val);
                stack.push(curr);
                curr = curr.right;
            }
            curr = stack.pop();
            curr = curr.left;
        }
    }
}