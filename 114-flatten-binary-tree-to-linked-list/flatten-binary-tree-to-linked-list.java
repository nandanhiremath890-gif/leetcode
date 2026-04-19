// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {

    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        // Flatten right subtree
        flatten(root.right);

        // Flatten left subtree
        flatten(root.left);

        // Modify pointers
        root.right = prev;
        root.left = null;

        // Move prev to current node
        prev = root;
    }
}