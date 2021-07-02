class Profit {
    private int[] mPrices;

    public Profit(int[] prices) {
         mPrices = prices;
    }

    public int getMaxProfit() {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < mPrices.length; i++) {
            if (mPrices[i] < minPrice) {
                minPrice = mPrices[i];
            } else if (mPrices[i] - minPrice > maxProfit) {
                maxProfit = mPrices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}
