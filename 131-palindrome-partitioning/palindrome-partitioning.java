import java.util.*;

class Solution {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();
        
        backtrack(s, 0, current, result);
        
        return result;
    }

    private void backtrack(String s, int start, 
                           List<String> current, 
                           List<List<String>> result) {

        // If we reached the end, add current partition
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Try all possible substrings
        for (int end = start; end < s.length(); end++) {
            
            // Check palindrome
            if (isPalindrome(s, start, end)) {
                
                // Choose
                current.add(s.substring(start, end + 1));

                // Explore
                backtrack(s, end + 1, current, result);

                // Backtrack
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}