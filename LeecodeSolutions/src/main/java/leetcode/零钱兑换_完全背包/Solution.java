package leetcode.零钱兑换_完全背包;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solution_4(new int[]{1, 2}, 11));
    }

    /**
     * {@动态规划（01背包思想）}
     * {@注意：为什么是与dp[j][j]取min，这里其实是在不断的与自身比较迭代更新，i-1的所有case都在后面的dp[i-1][xxx]了}
     */
    public int solution_1(int[] coins, int amount) {
        int ln = coins.length;
        int[][] dp = new int[ln + 1][amount + 1];
        for (int i = 0; i <= ln; i++) {
            Arrays.fill(dp[i], amount + 1);
            dp[i][0] = 0;
        }
        for (int i = 1; i <= ln; i++) {
            for (int j = 1; j <= amount; j++) {
                for (int k = 0; k * coins[i - 1] <= amount; k++) {
                    if (j - k * coins[i - 1] >= 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - k * coins[i - 1]] + k);
                    }
                }
            }
        }
        return dp[ln][amount] == amount + 1 ? -1 : dp[ln][amount];
    }

    /**
     * {@动态规划（01背包思想）+空间压缩}
     */
    public int solution_2(int[] coins, int amount) {
        int ln = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= ln; i++) {
            for (int j = 1; j <= amount; j++) {
                for (int k = 0; k * coins[i - 1] <= amount; k++) {
                    if (j - k * coins[i - 1] >= 0)
                        dp[j] = Math.min(dp[j], dp[j - k * coins[i - 1]] + k);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    /**
     * {@动态规划（完全背包思想）-不选第i件，选的话因为可能是选多件，就直接基于i的结果考虑是否再加一件}
     */
    private int solution_3(int[] coins, int amount) {
        int ln = coins.length;
        int[][] dp = new int[ln + 1][amount + 1];
        for (int i = 0; i <= ln; i++) {
            Arrays.fill(dp[i], amount + 1);
            dp[i][0] = 0;
        }
        for (int i = 1; i <= ln; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] >= 0)
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                else dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[ln][amount] == amount + 1 ? -1 : dp[ln][amount];
    }

    /**
     * {@完全背包的思想+空间压缩}
     */
    public int solution_4(int[] coins, int amount) {
        int ln = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) dp[i] = amount + 1;
        for (int i = 1; i <= ln; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] >= 0) dp[j] = Math.min(dp[j], dp[j - coins[i - 1]] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
