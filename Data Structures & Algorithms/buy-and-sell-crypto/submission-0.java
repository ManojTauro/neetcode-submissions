class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        int minSoFar = prices[0];

        for (int price: prices) {
            if (price < minSoFar) {
                minSoFar = price;
            }

            int curProfit = price - minSoFar;
            maxProfit = Math.max(curProfit, maxProfit);
        }

        return maxProfit;
    }
}
