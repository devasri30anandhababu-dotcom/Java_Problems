class Solution {
    public int maximumLength(int[] nums) {
        java.util.HashMap<Long, Integer> map = new java.util.HashMap<>();

        for (int n : nums) {
            map.put((long)n, map.getOrDefault((long)n, 0) + 1);
        }

        int ans = 1;

        for (long x : map.keySet()) {

            if (x == 1) {
                int c = map.get(1L);
                ans = Math.max(ans, c % 2 == 0 ? c - 1 : c);
                continue;
            }

            int len = 1;
            long val = x;

            while (map.getOrDefault(val, 0) >= 2) {

                if (val > 1000000000L / val)
                    break;

                val = val * val;

                if (map.getOrDefault(val, 0) >= 1) {
                    len += 2;
                } else {
                    break;
                }
            }

            ans = Math.max(ans, len);
        }

        return ans;
    }
}
