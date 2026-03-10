class Solution {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        // Skip trailing spaces
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        int lastIndex = i;
        // Move left until hitting a space or start
        while (i >= 0 && s.charAt(i) != ' ') {
            i--;
        }
        return lastIndex - i;
    }
}