package io.jafeer.tree;

public class BinarySearchTree {
    TreeNode root = null;

    public BinarySearchTree(int no) {
        root = new TreeNode(no);
    }

    public void insert(int no) {
        TreeNode parent = root;
        TreeNode current = root;

        while (true) {
            if (root == null)
                root = new TreeNode(no);
            else if (current.val > no) {
                parent = current;
                current = current.left;
                if (current == null) {
                    parent.left = new TreeNode(no);
                    return;
                }

            } else if (current.val < no) {
                parent = current;
                current = current.right;
                if (current == null) {
                    parent.right = new TreeNode(no);
                    return;
                }
            }
        }

    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val)
            return root;
        else if (root.val > val)
            return searchBST(root.left, val);
        else
            return searchBST(root.right, val);
    }

    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null)
            return 0;
        else if (root.val >= L && root.val <= R)
            return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
        else if (root.val > R)
            return rangeSumBST(root.left, L, R);
        else
            return rangeSumBST(root.right, L, R);
    }

    public void printTree() {
        if (root == null)
            System.out.println("Tree is empty");
        else
            printTree(root);
    }

    private void printTree(TreeNode node) {
        if (node != null) {

            printTree(node.left);
            printTree(node.right);
            System.out.println("\t" + node.val);
        }
    }

    public static void main(String[] args) {
        int[] nos = {3, 2, 4, 7, 6, 8, 1};
        BinarySearchTree tree = new BinarySearchTree(5);
        for (int no : nos)
            tree.insert(no);

        tree.printTree();
    }
}
