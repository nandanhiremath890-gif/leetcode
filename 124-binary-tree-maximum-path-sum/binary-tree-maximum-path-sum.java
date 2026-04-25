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

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Get max path sum from left and right (ignore negative sums)
        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));

        // Current path sum including both children
        int currentPath = node.val + left + right;

        // Update global maximum
        maxSum = Math.max(maxSum, currentPath);

        // Return max gain including current node
        return node.val + Math.max(left, right);
    }
}