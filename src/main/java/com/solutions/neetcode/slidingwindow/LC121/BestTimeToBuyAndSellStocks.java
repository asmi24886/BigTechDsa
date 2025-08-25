package com.solutions.neetcode.slidingwindow.LC121;

public class BestTimeToBuyAndSellStocks {

    class Solution {
        public int maxProfit(int[] prices) {

            int maxProfit = 0;
            int lo = 0;
            int hi = 1;

            if(prices.length == 1) {
                return 0;
            }

            while(hi < prices.length) {

                int profit = prices[hi] - prices[lo];
                maxProfit = Math.max(maxProfit, profit);
                if(prices[hi] < prices[lo]) {
                    //this is the new lowest I can buy
                    lo = hi;
                }
                hi++;

            }

            return maxProfit;
        }
    }
}
