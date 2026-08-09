class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;


        int[] suffix = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        Integer[][] dp = new Integer[n][n + 1];
        return solve(0, 1, piles, suffix, dp);
    }

    private int solve(int i, int m, int[] piles, int[] suffix, Integer[][] dp) {
        int n = piles.length;

        if (i >= n) return 0;

        if (i + 2 * m >= n) {
            return suffix[i];
        }

        if (dp[i][m] != null) return dp[i][m];

        int best = 0;

        for (int x = 1; x <= 2 * m; x++) {
         
            best = Math.max(best,
                    suffix[i] - solve(i + x, Math.max(m, x), piles, suffix, dp));
        }

        return dp[i][m] = best;
    }
}
