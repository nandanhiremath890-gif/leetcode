public class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1]) {
                right = mid; // peak is on left side
            } else {
                left = mid + 1; // peak is on right side
            }
        }

        return left; // or right (both are same)
    }
}