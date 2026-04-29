import java.util.*;

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Map<String, List<String>> memo = new HashMap<>();

        return dfs(s, wordSet, memo);
    }

    private List<String> dfs(String s, Set<String> wordSet,
                             Map<String, List<String>> memo) {

        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        List<String> result = new ArrayList<>();

        if (s.length() == 0) {
            result.add("");
            return result;
        }

        for (String word : wordSet) {
            if (s.startsWith(word)) {
                List<String> subList =
                        dfs(s.substring(word.length()), wordSet, memo);

                for (String sub : subList) {
                    if (sub.isEmpty()) {
                        result.add(word);
                    } else {
                        result.add(word + " " + sub);
                    }
                }
            }
        }

        memo.put(s, result);
        return result;
    }
}