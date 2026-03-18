import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;
        
        while (i < words.length) {
            int j = i;
            int lineLength = 0;
            
            // Find how many words fit in this line
            while (j < words.length && 
                   lineLength + words[j].length() + (j - i) <= maxWidth) {
                lineLength += words[j].length();
                j++;
            }
            
            int numWords = j - i;
            int totalSpaces = maxWidth - lineLength;
            
            StringBuilder line = new StringBuilder();
            
            // Last line or single word → left justify
            if (j == words.length || numWords == 1) {
                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1) line.append(" ");
                }
                
                // Fill remaining spaces
                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            } else {
                int spacesBetween = totalSpaces / (numWords - 1);
                int extraSpaces = totalSpaces % (numWords - 1);
                
                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    
                    if (k < j - 1) {
                        int spacesToApply = spacesBetween + 
                                            (extraSpaces > 0 ? 1 : 0);
                        for (int s = 0; s < spacesToApply; s++) {
                            line.append(" ");
                        }
                        extraSpaces--;
                    }
                }
            }
            
            result.add(line.toString());
            i = j;
        }
        
        return result;
    }
}