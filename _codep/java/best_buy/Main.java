/*
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * Example 1: 
 * Input: [7, 1, 5, 3, 6, 4]
 * Output: 5
 *
 * max. difference = 6 -1 = = 5 (not 7 -1 = 6, as selling price needs to be larger than buying price)
 *
 * Example 2:
 * Input: [7, 6, 4, 3, 1]
 * Output: 0
 *
 * In this case, no transaction is done, i.e. max profix = 0.
 *
 */
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String [] args) {
        int[] prices1 = new int[] {7, 1, 5, 3, 6, 4};
        int[] prices2 = new int[] {7, 6, 4, 3, 1};

        Profit profit = new Profit(prices1);
        System.out.printf("max profit: " + Integer.valueOf(profit.getMaxProfit()) + "\n");
        profit = new Profit(prices2);
        System.out.printf("max profit: " + Integer.valueOf(profit.getMaxProfit()) + "\n");
    }
}
