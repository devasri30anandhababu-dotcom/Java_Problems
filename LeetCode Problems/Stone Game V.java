class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;

        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }

        Integer[][] dp = new Integer[n][n];

        return solve(0, n - 1, prefix, dp);
    }

    private int solve(int l, int r, int[] prefix, Integer[][] dp) {
        if (l == r) {
            return 0;
        }

        if (dp[l][r] != null) {
            return dp[l][r];
        }

        int ans = 0;

        for (int k = l; k < r; k++) {
            int leftSum = prefix[k + 1] - prefix[l];
            int rightSum = prefix[r + 1] - prefix[k + 1];

            if (leftSum < rightSum) {
                ans = Math.max(ans, leftSum + solve(l, k, prefix, dp));
            } else if (leftSum > rightSum) {
                ans = Math.max(ans, rightSum + solve(k + 1, r, prefix, dp));
            } else {
                ans = Math.max(ans,
                        leftSum + Math.max(
                                solve(l, k, prefix, dp),
                                solve(k + 1, r, prefix, dp)
                        ));
            }
        }

        return dp[l][r] = ans;
    }
}
