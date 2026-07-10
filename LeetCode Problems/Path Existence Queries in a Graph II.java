class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) order[i] = i;
        Arrays.sort(order, (a, b) -> nums[a] - nums[b]);

        int[] sortedVal = new int[n];
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            sortedVal[i] = nums[order[i]];
            pos[order[i]] = i;
        }

        int[] reach = new int[n];
        int right = 0;
        for (int i = 0; i < n; i++) {
            if (right < i) right = i;
            while (right + 1 < n && sortedVal[right + 1] - sortedVal[i] <= maxDiff) right++;
            reach[i] = right;
        }

        int LOG = 1;
        while ((1 << LOG) < n) LOG++;
        LOG++;

        int[][] jump = new int[LOG][n];
        jump[0] = reach;
        for (int k = 1; k < LOG; k++) {
            for (int i = 0; i < n; i++) {
                jump[k][i] = jump[k - 1][jump[k - 1][i]];
            }
        }

        int q = queries.length;
        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            int u = queries[i][0], v = queries[i][1];
            int pu = pos[u], pv = pos[v];
            int l = Math.min(pu, pv), r = Math.max(pu, pv);

            if (l == r) {
                ans[i] = 0;
                continue;
            }

            int cur = l;
            int steps = 0;
            for (int k = LOG - 1; k >= 0; k--) {
                if (jump[k][cur] < r) {
                    cur = jump[k][cur];
                    steps += (1 << k);
                }
            }

            ans[i] = (reach[cur] >= r) ? steps + 1 : -1;
        }
        return ans;
    }
}
