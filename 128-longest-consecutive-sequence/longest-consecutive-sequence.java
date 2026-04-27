import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();

        // Add all numbers to set
        for (int num : nums) {
            set.add(num);
        }

        int longestStreak = 0;

        for (int num : set) {

            // Check if it is start of sequence
            if (!set.contains(num - 1)) {

                int currentNum = num;
                int currentStreak = 1;

                // Count consecutive numbers
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}