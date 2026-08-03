import java.util.*;

class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        solve(nums, used, new ArrayList<>());
        return result;
    }

    public void solve(int[] nums, boolean[] used, List<Integer> temp) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;

            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;

            used[i] = true;
            temp.add(nums[i]);

            solve(nums, used, temp);

            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }
}
