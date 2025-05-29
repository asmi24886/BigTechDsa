package com.solutions.neetcode.binarysearch.LC875;

import java.util.Arrays;

public class KokoEatingBananas {
    class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            Arrays.sort(piles);
            return search(1, piles[piles.length-1], piles, h);
        }

        public int search(int minb, int maxb, int [] piles, int h) {
            if(maxb < minb) return minb;
            int midb = minb + (maxb-minb)/2;
            long totalHours = calculateHours(midb, piles);
            if(totalHours <= (long)h) return search(minb, midb-1, piles, h);
            else return search (midb + 1, maxb, piles, h);
        }

        public long calculateHours(int k, int [] piles) {
            long totalHours = 0;
            for(int b : piles) {
                totalHours+= b/k + (b%k == 0?0:1);
            }
            return totalHours;
        }
    }
}
