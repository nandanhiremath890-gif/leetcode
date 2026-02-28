public class Solution {

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

      
        boolean[][] dp = new boolean[m + 1][n + 1];

    
        dp[0][0] = true;

        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);

                if (pc == '?' || pc == sc) {
                    dp[i][j] = dp[i - 1][j - 1];
                } 
                else if (pc == '*') {
                   
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } 
                else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[m][n];
    }

  
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.isMatch("aa", "a"));       
        System.out.println(sol.isMatch("aa", "*"));      
        System.out.println(sol.isMatch("cb", "?a"));      
        System.out.println(sol.isMatch("adceb", "*a*b")); 
        System.out.println(sol.isMatch("acdcb", "a*c?b"));
    }
}