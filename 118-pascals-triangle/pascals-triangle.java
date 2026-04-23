import java.util.*;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        // Handle edge case
        if (numRows <= 0) {
            return triangle;
        }

        // First row
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        // Generate remaining rows
        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = triangle.get(i - 1);
            List<Integer> currRow = new ArrayList<>();

            // First element
            currRow.add(1);

            // Middle elements
            for (int j = 1; j < i; j++) {
                currRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            // Last element
            currRow.add(1);

            triangle.add(currRow);
        }

        return triangle;
    }
}