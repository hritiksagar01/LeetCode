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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result  = new ArrayList<List<Integer>>();
        if(root == null) return result;
        bfs(root , result);
        return result;
    }
   void bfs( TreeNode root, List<List<Integer>> result ){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int size = queue.size();
            for( int i = 0; i<size ; i++){
               root  = queue.poll();
                temp.add(root.val);
          
            if(root.left != null){
                queue.offer(root.left);
            }

            if(root.right != null){
              queue.offer(root.right);
            }
              }
            result.add(0 , temp);

        }
    }
}