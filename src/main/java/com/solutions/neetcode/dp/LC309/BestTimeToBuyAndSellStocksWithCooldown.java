package com.solutions.neetcode.dp.LC309;

public class BestTimeToBuyAndSellStocksWithCooldown {
    class Solution {
        public int maxProfit(int[] prices) {
            return dp_optimized(prices);
        }

        int dp_n_space(int [] prices) {
            int N = prices.length;
            int [] buy_dp = new int[N+2];
            int [] sell_dp = new int[N+1];

            for(int i = N-1; i >= 0; i--) {

                //buy
                buy_dp[i] = Math.max(sell_dp[i+1] - prices[i], buy_dp[i+1]);

                //sell
                sell_dp[i] = Math.max(buy_dp[i+2] + prices[i], sell_dp[i+1]);
            }

            return buy_dp[0];
        }

        int dp_optimized(int [] prices) {
            int SELL_NEXT_MAX_PROFIT = 0;
            int BUY_NEXT_MAX_PROFIT = 0;
            int BUY_DAY_AFTER_TOMORROW_MAX_PROFIT = 0;

            int N = prices.length;
            for(int i = N-1; i >= 0; i--) {
                int dp_buy = Math.max(SELL_NEXT_MAX_PROFIT - prices[i], BUY_NEXT_MAX_PROFIT);
                int dp_sell = Math.max(BUY_DAY_AFTER_TOMORROW_MAX_PROFIT + prices[i], SELL_NEXT_MAX_PROFIT);

                BUY_DAY_AFTER_TOMORROW_MAX_PROFIT = BUY_NEXT_MAX_PROFIT;
                BUY_NEXT_MAX_PROFIT = dp_buy;
                SELL_NEXT_MAX_PROFIT = dp_sell;
            }
            return BUY_NEXT_MAX_PROFIT;
        }

        int dp_2(int [] prices) {
            int N = prices.length;
            int [][] dp = new int [N][N];

            for(int i = N-1; i >= 0; i--) {

                for(int j = N - 1; j >= i; j--) {

                    int todayProfit = prices[j] - prices[i]; //can be a loss

                    int nextBuyProfit = 0;
                    if( (j + 3) < N) {
                        nextBuyProfit = dp[j+2][j+3];
                    }

                    int maxProfitNextDay = 0;
                    if(j < N - 1) {
                        maxProfitNextDay = dp[i][j+1];
                    }

                    int buy = Math.max(maxProfitNextDay, todayProfit + nextBuyProfit);
                    int notBuy = (i + 1) < N ? dp[i+1][i+1] : 0;

                    dp[i][j] = Math.max(buy, notBuy);
                }
            }

            return dp[0][0];
        }
    }
}
