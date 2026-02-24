import java.util.*;

public class Solution {
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        
        backtrack(candidates, target, 0, current, result);
        return result;
    }
    
    private void backtrack(int[] candidates, int target, int start, 
                           List<Integer> current, List<List<Integer>> result) {
        
        // Base case: if target becomes 0, add current combination
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        // Try each candidate starting from 'start'
        for (int i = start; i < candidates.length; i++) {
            
            // If current number exceeds target, skip
            if (candidates[i] > target) continue;
            
            // Choose the number
            current.add(candidates[i]);
            
            // Recurse with reduced target
            backtrack(candidates, target - candidates[i], i, current, result);
            
            // Backtrack (remove last element)
            current.remove(current.size() - 1);
        }
    }
}