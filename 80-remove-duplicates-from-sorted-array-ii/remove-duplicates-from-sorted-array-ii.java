public class Solution {

    public int removeDuplicates(int[] nums) {
        int k = 0; 

        for (int i = 0; i < nums.length; i++) {
            if (k < 2 || nums[i] != nums[k - 2]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {0,0,1,1,1,1,2,3,3};

        int k = sol.removeDuplicates(nums);

        System.out.println("New length: " + k);
        System.out.print("Array: ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}