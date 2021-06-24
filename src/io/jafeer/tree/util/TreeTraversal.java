package io.jafeer.tree.util;

import io.jafeer.tree.TreeNode;

import java.util.*;

//D	->E	->B	->F	->G	->C	->A
//
public class TreeTraversal {
    private static void printInOrder(TreeNode node) {
        if (node != null) {

            printInOrder(node.left);
            System.out.print("\t->" + node.val);
            printInOrder(node.right);

        }
    }

    private static void printPreOrder(TreeNode node) {
        if (node != null) {
            System.out.print("\t->" + node.val);
            printInOrder(node.left);
            printInOrder(node.right);

        }
    }

    private static void printLevelByLevel(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ((LinkedList<TreeNode>) queue).add(root);

        while (true) {
            int level = queue.size();
            if (level == 0)
                break;
            while (level > 0) {
                TreeNode node = queue.peek();
                System.out.print("\t->" + node.val);
                queue.remove();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    ((LinkedList<TreeNode>) queue).add(node.right);

                level--;
            }
        }
    }

    private static void printPostOrder(TreeNode node) {
        if (node != null) {
            printInOrder(node.left);
            printInOrder(node.right);
            System.out.print("\t->" + node.val);

        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;
        }
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if (t1 != null && t2 != null) {
            t1.val = t1.val + t2.val;

            if (t1.left != null && t2.left != null)
                mergeTrees(t1.left, t2.left);
            else if (t1.left == null && t2.left != null)
                t1.left = t2.left;

            if (t1.right != null && t2.right != null)
                mergeTrees(t1.right, t2.right);
            else if (t1.right == null && t2.right != null)
                t1.right = t2.right;

        }
        return t1;
    }

    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    public static int max = Integer.MIN_VALUE;

    public static int max(TreeNode root) {
        max = root.val;
        sum(root);
        System.out.println("Max:" + max);
        return 0;
    }

    private static int sum(TreeNode node) {
        if (node != null) {
            int sumVal = sum(node.left);//+sum(node.right);
            sumVal = changeSumValue(sumVal, node.val);
            if (sumVal != 0)
                sumVal = changeSumValue(sumVal, sum(node.right));
            return sumVal;
        } else
            return 0;

    }

    private static int changeSumValue(int sum, int value) {
        if ((sum + value) < sum)
            sum = 0;
        else {
            sum = sum + value;
            if (sum > max)
                max = sum;
            System.out.println("Max:" + max + " value:" + value);
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(-2);
        TreeNode three = new TreeNode(3);
        root.left = two;
        root.right = three;
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(-6);
        TreeNode seven = new TreeNode(7);
        two.left = four;
        two.right = five;
        three.left = six;
        three.right = seven;
        /*System.out.print("InOrder:");
        printInOrder(root);
        System.out.print("\nPreOrder:");
        printPreOrder(root);
        System.out.print("\nPostOrder:");
        printPostOrder(root);
        System.out.print("\nLevelByLevel:");
        printLevelByLevel(root);*/
        //max(root);
        //System.out.println();


print();
    }

    public static void print()
    {
        String str="Jafeer";
        String x="X";

        x=x.replaceAll("X","XXXXXXXXXX");
        x=x.replaceAll("X","XXXXXXXXXX");
        x=x.replaceAll("X",str+"\n");
        System.out.println(x);

    }

}
