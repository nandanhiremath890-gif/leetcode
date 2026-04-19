import java.util.ArrayList;
import java.util.List;

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

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();

        dfs(root, targetSum, currentPath, result);

        return result;
    }

    private void dfs(TreeNode node, int targetSum,
                     List<Integer> currentPath,
                     List<List<Integer>> result) {

        if (node == null) {
            return;
        }

        // Add current node to path
        currentPath.add(node.val);

        // Check if it's a leaf and sum matches
        if (node.left == null && node.right == null
                && targetSum == node.val) {

            result.add(new ArrayList<>(currentPath));
        } else {
            // Continue searching
            dfs(node.left, targetSum - node.val,
                currentPath, result);

            dfs(node.right, targetSum - node.val,
                currentPath, result);
        }

        // Backtrack
        currentPath.remove(currentPath.size() - 1);
    }
}