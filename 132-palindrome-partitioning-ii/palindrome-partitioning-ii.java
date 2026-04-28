class Solution {

    public int minCut(String s) {
        int n = s.length();

        // cuts[i] = min cuts needed for s[0..i]
        int[] cuts = new int[n];

        // palindrome[i][j] = true if s[i..j] is palindrome
        boolean[][] palindrome = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            cuts[i] = i; // maximum cuts

            for (int j = 0; j <= i; j++) {

                if (s.charAt(i) == s.charAt(j) &&
                   (i - j <= 2 || palindrome[j + 1][i - 1])) {

                    palindrome[j][i] = true;

                    if (j == 0) {
                        cuts[i] = 0;
                    } else {
                        cuts[i] = Math.min(cuts[i], cuts[j - 1] + 1);
                    }
                }
            }
        }

        return cuts[n - 1];
    }
}