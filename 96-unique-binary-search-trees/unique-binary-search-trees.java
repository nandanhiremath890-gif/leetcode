class Solution {
    public int numTrees(int n) {
        // dp[i] will store number of unique BSTs with i nodes
        int[] dp = new int[n + 1];

        // Base cases
        dp[0] = 1; // Empty tree
        dp[1] = 1; // One node

        for (int nodes = 2; nodes <= n; nodes++) {
            for (int root = 1; root <= nodes; root++) {

                dp[nodes] += dp[root - 1] * dp[nodes - root];
            }
        }

        return dp[n];
    }
}