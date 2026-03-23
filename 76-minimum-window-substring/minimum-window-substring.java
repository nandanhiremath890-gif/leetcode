import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";

        Map<Character, Integer> targetMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int formed = 0;
        int required = targetMap.size();

        Map<Character, Integer> windowMap = new HashMap<>();

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {
            char ch = s.charAt(right);
            windowMap.put(ch, windowMap.getOrDefault(ch, 0) + 1);

            if (targetMap.containsKey(ch) &&
                windowMap.get(ch).intValue() == targetMap.get(ch).intValue()) {
                formed++;
            }

            while (left <= right && formed == required) {
                char c = s.charAt(left);

                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                windowMap.put(c, windowMap.get(c) - 1);

                if (targetMap.containsKey(c) &&
                    windowMap.get(c).intValue() < targetMap.get(c).intValue()) {
                    formed--;
                }

                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}