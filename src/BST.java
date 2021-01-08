import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        DFS(root, low, high);
        return sum;
    }

    // Given the root node of a binary search tree, return the sum of values of all nodes with a value in the range [low, high].

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

    // Given two binary trees and imagine that when you put one of them to cover the other,
    // some nodes of the two trees are overlapped while the others are not.

    // You need to merge them into a new binary tree. The merge rule is that if two nodes overlap,
    // then sum node values up as the new value of the merged node.
    // Otherwise, the NOT null node will be used as the node of new tree.

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    // Given the root node of a binary search tree (BST) and a value.
    // You need to find the node in the BST that the node's value equals the given value.
    // Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.

    TreeNode treeNode = null;
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val)
            treeNode = root;
        searchBST(root.left, val);
        searchBST(root.right, val);
        return treeNode;
    }

    // Given an n-ary tree, return the preorder traversal of its nodes' values.

    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        preOrder(root, list);
        return list;
    }

    public void preOrder(Node root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        for (Node child : root.children) {
            preOrder(child, list);
        }
    }

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        postOrder(root, list);
        return list;
    }

    public void postOrder(Node root, List<Integer> list) {
        if (root == null) return;
        for (Node child : root.children) {
            postOrder(child, list);
        }
        list.add(root.val);
    }

}
