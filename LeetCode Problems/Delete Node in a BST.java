class Solution {

    public TreeNode minFind(TreeNode node) {
        while (node.left != null)
            node = node.left;
        return node;
    }

    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null)
            return null;

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {

            if (root.left == null)
                return root.right;

            if (root.right == null)
                return root.left;

            TreeNode rep = minFind(root.right);
            root.val = rep.val;
            root.right = deleteNode(root.right, rep.val);
        }

        return root;
    }
}
