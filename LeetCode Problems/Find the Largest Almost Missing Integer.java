import java.util.*;

class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        if (k == n) {
            int max = Integer.MIN_VALUE;
            for (int num : nums) {
                max = Math.max(max, num);
            }
            return max;
        }

        if (k == 1) {
            int max = -1;

            for (int num : nums) {
                if (map.get(num) == 1) {
                    max = Math.max(max, num);
                }
            }

            return max;
        }

        int ans = -1;

        if (map.get(nums[0]) == 1) {
            ans = Math.max(ans, nums[0]);
        }

        if (map.get(nums[n - 1]) == 1) {
            ans = Math.max(ans, nums[n - 1]);
        }

        return ans;
    }
}
