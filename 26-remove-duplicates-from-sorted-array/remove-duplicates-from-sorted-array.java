class Solution {
    public int removeDuplicates(int[] nums) {
        // If array is empty
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Pointer for unique element position
        int i = 0;

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        // Length of unique elements
        return i + 1;
    }
}