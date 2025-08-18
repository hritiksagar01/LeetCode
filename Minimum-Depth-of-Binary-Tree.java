import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    /**
     * Calculates minimum depth using Breadth-First Search (BFS).
     * This is efficient because it explores level by level and stops
     * as soon as the first leaf node is found.
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 1;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            // Iterate through all nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                // Check if it's a leaf node. If so, we're done.
                if (node.left == null && node.right == null) {
                    return depth;
                }

                // Add children for the next level
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            // Move to the next level
            depth++;
        }
        return depth; // Should not be reached if tree is valid
    }
}