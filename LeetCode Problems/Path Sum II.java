import java.util.*;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        findPath(root, targetSum, new ArrayList<>(), ans);
        return ans;
    }

    public void findPath(TreeNode root, int sum, List<Integer> path, List<List<Integer>> ans) {
        if (root == null)
            return;

        path.add(root.val);
        sum -= root.val;

        if (root.left == null && root.right == null && sum == 0) {
            ans.add(new ArrayList<>(path));
        }

        findPath(root.left, sum, path, ans);
        findPath(root.right, sum, path, ans);

        path.remove(path.size() - 1);
    }
}
