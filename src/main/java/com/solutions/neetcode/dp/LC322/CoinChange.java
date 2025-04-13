package com.solutions.neetcode.dp.LC322;

import java.util.Arrays;

public class CoinChange {

    class Solution {
        public int coinChange(int[] coins, int amount) {

            int [] dp = new int [amount + 1];
            Arrays.fill(dp, amount + 1);
            dp[0] = 0;

            for(int i = 1; i <= coins.length; i++) {
                for(int j = coins[i - 1]; j <= amount; j++) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i - 1]] + 1);
                }
            }

            if(dp[amount] > amount) return -1;

            return dp[amount];
        }
    }


}
