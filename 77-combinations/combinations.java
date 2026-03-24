import java.util.*;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 1, n, k);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int start, int n, int k) {
        if (tempList.size() == k) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = start; i <= n; i++) {
            tempList.add(i);                      
            backtrack(result, tempList, i + 1, n, k); 
            tempList.remove(tempList.size() - 1); 
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 4, k = 2;
        List<List<Integer>> combinations = sol.combine(n, k);

        System.out.println("Combinations:");
        for (List<Integer> combo : combinations) {
            System.out.println(combo);
        }
    }
}