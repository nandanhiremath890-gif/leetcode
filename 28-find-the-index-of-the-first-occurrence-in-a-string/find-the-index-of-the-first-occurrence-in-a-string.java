class Solution {
    public int strStr(String haystack, String needle) {
        // If needle is empty
        if (needle.length() == 0) {
            return 0;
        }

        int n = haystack.length();
        int m = needle.length();

        // Traverse haystack
        for (int i = 0; i <= n - m; i++) {
            int j = 0;

            // Compare substring
            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            // If full match found
            if (j == m) {
                return i;
            }
        }

        return -1;  // Not found
    }
}