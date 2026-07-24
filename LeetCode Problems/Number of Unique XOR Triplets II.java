class Solution {
    public int uniqueXorTriplets(int[] nums) {
        boolean[] present = new boolean[2048];
        boolean[] pair = new boolean[2048];
        boolean[] ans = new boolean[2048];

        for (int x : nums) {
            present[x] = true;
        }

        for (int a = 0; a < 2048; a++) {
            if (!present[a]) continue;
            for (int b = 0; b < 2048; b++) {
                if (!present[b]) continue;
                pair[a ^ b] = true;
            }
        }

        for (int x = 0; x < 2048; x++) {
            if (!present[x]) continue;
            for (int y = 0; y < 2048; y++) {
                if (pair[y]) {
                    ans[x ^ y] = true;
                }
            }
        }

        int count = 0;
        for (boolean v : ans) {
            if (v) count++;
        }

        return count;
    }
}
