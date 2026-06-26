class Solution {

    class BIT {
        int[] bit;
        int n;

        BIT(int n) {
            this.n = n;
            bit = new int[n + 1];
        }

        void add(int idx, int val) {
            while (idx <= n) {
                bit[idx] += val;
                idx += idx & -idx;
            }
        }

        int query(int idx) {
            int res = 0;
            while (idx > 0) {
                res += bit[idx];
                idx -= idx & -idx;
            }
            return res;
        }
    }

    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        int offset = n + 2;
        BIT bit = new BIT(2 * n + 5);

        long ans = 0;
        int pref = 0;

        bit.add(offset, 1);

        for (int x : nums) {
            pref += (x == target) ? 1 : -1;
            ans += bit.query(pref + offset - 1);
            bit.add(pref + offset, 1);
        }

        return ans;
    }
}
