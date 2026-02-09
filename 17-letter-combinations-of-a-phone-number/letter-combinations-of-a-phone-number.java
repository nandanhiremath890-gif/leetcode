import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        // Edge case
        if (digits == null || digits.length() == 0) {
            return result;
        }

        // Digit to letters mapping
        String[] phoneMap = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };

        backtrack(digits, 0, new StringBuilder(), phoneMap, result);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder current,
                           String[] phoneMap, List<String> result) {

        // If combination is complete
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        String letters = phoneMap[digits.charAt(index) - '0'];

        for (char ch : letters.toCharArray()) {
            current.append(ch);                 // choose
            backtrack(digits, index + 1, current, phoneMap, result); // explore
            current.deleteCharAt(current.length() - 1); // un-choose
        }
    }
}
