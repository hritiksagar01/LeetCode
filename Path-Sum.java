class Solution {
    boolean flag = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        dfs(root, targetSum, 0);
        return flag;
    }

    void dfs(TreeNode root, int targetSum, int current) {
        if (root == null) return;

        current += root.val;

        if (root.left == null && root.right == null) {
            if (current == targetSum) {
                flag = true;
            }
            return; 
        }

        dfs(root.left, targetSum, current);
        dfs(root.right, targetSum, current);
    }
}
