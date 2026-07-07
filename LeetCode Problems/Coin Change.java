import java.util.*;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int def = amount + 1;
        int[] dp = new int[def];
        Arrays.fill(dp, def);
        dp[0] = 0;

        for (int cur : coins) {
            for (int index = cur; index <= amount; index++) {
                dp[index] = Math.min(dp[index], 1 + dp[index - cur]);
            }
        }

        return (dp[amount] == def) ? -1 : dp[amount];
    }
}
