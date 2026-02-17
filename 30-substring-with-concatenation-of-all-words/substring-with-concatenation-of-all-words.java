import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        
        if (s == null || s.length() == 0 || words == null || words.length == 0)
            return result;
        
        int wordLength = words[0].length();
        int wordCount = words.length;
        int totalLength = wordLength * wordCount;
        
        if (s.length() < totalLength)
            return result;
        
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }
        
        // Try each possible starting offset
        for (int i = 0; i < wordLength; i++) {
            int left = i;
            int count = 0;
            Map<String, Integer> seenMap = new HashMap<>();
            
            for (int right = i; right + wordLength <= s.length(); right += wordLength) {
                String word = s.substring(right, right + wordLength);
                
                if (wordMap.containsKey(word)) {
                    seenMap.put(word, seenMap.getOrDefault(word, 0) + 1);
                    count++;
                    
                    // If word frequency exceeds, move left pointer
                    while (seenMap.get(word) > wordMap.get(word)) {
                        String leftWord = s.substring(left, left + wordLength);
                        seenMap.put(leftWord, seenMap.get(leftWord) - 1);
                        left += wordLength;
                        count--;
                    }
                    
                    // If all words matched
                    if (count == wordCount) {
                        result.add(left);
                    }
                } else {
                    // Reset window
                    seenMap.clear();
                    count = 0;
                    left = right + wordLength;
                }
            }
        }
        
        return result;
    }
}