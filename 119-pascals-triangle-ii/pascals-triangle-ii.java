import java.util.*;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();

        // Build row step by step
        for (int i = 0; i <= rowIndex; i++) {
            // Add 1 at the end
            row.add(1);

            // Update middle elements from right to left
            for (int j = i - 1; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }

        return row;
    }
}