class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        perform(root,result);
        return result;
    }
    private static void perform (TreeNode node,List<Integer> result)
    {
        if(node==null) return;
        result.add(node.val);
        perform(node.left,result);
        perform(node.right,result);
    }

}
