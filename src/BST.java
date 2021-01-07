public class BST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        DFS(root, low, high);
        return sum;
    }

    public void DFS(TreeNode node, int low, int high) {
        if (node != null) {
            if (node.val >= low && node.val <= high)
                sum += node.val;
            if (low < node.val)
                DFS(node.left, low, high);
            if (node.val < high)
                DFS(node.right, low, high);
        }
    }

    
}
