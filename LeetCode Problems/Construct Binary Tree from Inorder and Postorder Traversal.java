/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if (inorder == null || postorder == null || inorder.length == 0)
            return null;

        int iIndex = inorder.length - 1;
        int pIndex = postorder.length - 1;

        Stack<TreeNode> stk = new Stack<>();

        TreeNode root = new TreeNode(postorder[pIndex]);
        pIndex--;

        stk.push(root);

        while (pIndex >= 0) {

            TreeNode node = stk.peek();

            if (node.val != inorder[iIndex]) {

                TreeNode right = new TreeNode(postorder[pIndex]);
                pIndex--;

                node.right = right;
                stk.push(right);

            } else {

                while (!stk.isEmpty() && stk.peek().val == inorder[iIndex]) {
                    node = stk.pop();
                    iIndex--;
                }

                if (pIndex >= 0) {
                    TreeNode left = new TreeNode(postorder[pIndex]);
                    pIndex--;

                    node.left = left;
                    stk.push(left);
                }
            }
        }

        return root;
    }
}
