class Solution {
    static final int MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        int[] pos = new int[n];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != '0') {
                pos[cnt++] = i;
            }
        }

        int[] digit = new int[cnt];
        int[] prefixSum = new int[cnt + 1];
        long[] prefixNum = new long[cnt + 1];
        long[] pow10 = new long[cnt + 1];

        pow10[0] = 1;

        for (int i = 0; i < cnt; i++) {
            digit[i] = s.charAt(pos[i]) - '0';
            prefixSum[i + 1] = prefixSum[i] + digit[i];
            pow10[i + 1] = (pow10[i] * 10) % MOD;
            prefixNum[i + 1] = (prefixNum[i] * 10 + digit[i]) % MOD;
        }

        int[] ans = new int[queries.length];

        for (int k = 0; k < queries.length; k++) {
            int l = queries[k][0];
            int r = queries[k][1];

            int left = lowerBound(pos, cnt, l);
            int right = upperBound(pos, cnt, r);

            if (left >= right) {
                ans[k] = 0;
                continue;
            }

            int len = right - left;

            long x = (prefixNum[right]
                    - (prefixNum[left] * pow10[len]) % MOD + MOD) % MOD;

            long sum = prefixSum[right] - prefixSum[left];

            ans[k] = (int) ((x * sum) % MOD);
        }

        return ans;
    }

    private int lowerBound(int[] arr, int n, int target) {
        int l = 0, r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] >= target)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    private int upperBound(int[] arr, int n, int target) {
        int l = 0, r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] > target)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}
