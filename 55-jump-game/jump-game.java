class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {

            // If current index is beyond the maximum reachable index
            if (i > maxReach) {
                return false;
            }

            // Update the farthest we can reach
            maxReach = Math.max(maxReach, i + nums[i]);
        }

        return true;
    }
}
