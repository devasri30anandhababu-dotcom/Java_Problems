class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        perform(root, result);
        return result;
    }

    private void perform(TreeNode node, List<Integer> result) {
        if (node == null)
            return;

        perform(node.left, result);
        perform(node.right, result);
        result.add(node.val);
    }
}
