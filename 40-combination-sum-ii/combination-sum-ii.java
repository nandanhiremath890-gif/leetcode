import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Step 1: Sort the array to handle duplicates
        Arrays.sort(candidates);
        
        // Step 2: Start backtracking
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        
        return result;
    }
    
    private void backtrack(int[] candidates, int remaining, int start, 
                           List<Integer> current, List<List<Integer>> result) {
        
        // Base case: if remaining becomes 0, we found a valid combination
        if (remaining == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            
            // Skip duplicates
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            
            // If current number exceeds remaining target, stop (since sorted)
            if (candidates[i] > remaining) {
                break;
            }
            
            // Choose current number
            current.add(candidates[i]);
            
            // Move to next index (i + 1 because each number can be used once)
            backtrack(candidates, remaining - candidates[i], i + 1, current, result);
            
            // Backtrack (remove last element)
            current.remove(current.size() - 1);
        }
    }
}