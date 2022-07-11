class Solution {
    // want: max difference between one
    // price[i] and a future price[i]
    // give the profit (price[sell] - price[buy])
    // can we have negative profits - 
    // No. Max is 0, i.e no profit.
    // we want to find a max and min,
    // such that the max is on right
    // method 1: check index and then look 
    // at all future steps while keeping a 
    // variable for the best profit
    
    // 7 1 5 3 6 4
    // * *
    // *   *
    // if you have a start date, and anything
    // to the right is smaller, stop checking
    // that start date
    // 
    // 7 1 5 3 6 4 0 0 0 0 0 0 
    // b           * *       s
    

    public int maxProfit(int[] prices) {
        int bestProfit = 0;
        // Check all future dates for a given buy date.
        for (int i = 0; i < prices.length - 1 ; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                // Impossible that starting price will
                // yield any profit.
                if (prices[j] <= prices[i]) {
                    break;
                } 
                // Found a better profit at these steps.
                int diff = prices[j] - prices[i];
                if (diff > bestProfit) {
                    bestProfit = diff;
                }
            }
        }
        return bestProfit;
    }
}