class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][][] opt = new int[k+1][prices.length][2];
        for (int i = 0; i < k+1; i ++) {
            if(i == 0) {
                continue;
            } else {
                for (int j = 0; j < prices.length; j ++) {
                    if (j == 0) {
                        opt[i][j][0] = 0;
                        opt[i][j][1] = -prices[j];
                    } else {
                        opt[i][j][0] = Math.max(opt[i][j-1][0], opt[i][j-1][1] + prices[j]);
                        opt[i][j][1] = Math.max(opt[i][j-1][1], opt[i-1][j-1][0] - prices[j]);
                    }
                }
            }
        }
        return Math.max(opt[k][prices.length-1][0],opt[k][prices.length-1][1]);
    }
}