import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        HashSet<String> seen = new HashSet<>();
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                
                char current = board[i][j];
                
                if (current != '.') {
                    
                    String row = current + " in row " + i;
                    String col = current + " in col " + j;
                    String box = current + " in box " + (i/3) + "-" + (j/3);
                    
                    if (!seen.add(row) || 
                        !seen.add(col) || 
                        !seen.add(box)) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
}