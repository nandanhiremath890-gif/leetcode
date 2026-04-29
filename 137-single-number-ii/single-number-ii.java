class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;

        for (int num : nums) {
            // Add number to 'twos' if it already exists in 'ones'
            twos |= ones & num;

            // XOR will add number to 'ones' if not present,
            // remove if already present
            ones ^= num;

            // 'threes' contains bits appearing 3 times
            int threes = ones & twos;

            // Remove bits that appeared 3 times
            ones &= ~threes;
            twos &= ~threes;
        }

        return ones;
    }
}