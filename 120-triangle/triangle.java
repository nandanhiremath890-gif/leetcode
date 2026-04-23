import java.util.*;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // Start from the last row
        int n = triangle.size();
        int[] dp = new int[n];

        // Copy last row into dp array
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }

        // Bottom-up calculation
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = triangle.get(i).get(j) 
                        + Math.min(dp[j], dp[j + 1]);
            }
        }

        return dp[0];
    }
}