package io.jafeer.tree;

import java.util.LinkedList;
import java.util.Queue;

public class PrintTreeLevelByLevel {
    public static void main(String[] args)
    {
        TreeNode root=new TreeNode(1);
        TreeNode two=new TreeNode(2);
        TreeNode three=new TreeNode(3);
       root.left=two;
       root.right=three;
        TreeNode four=new TreeNode(4);
        TreeNode five=new TreeNode(5);
        TreeNode six=new TreeNode(6);
        TreeNode seven=new TreeNode(7);
        two.left=four;
        two.right=five;
        three.left=six;
        three.right=seven;

        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        ((LinkedList<TreeNode>) queue).add(root);

        while(true) {
            int level=queue.size();
            if(level == 0)
                break;
            while (level > 0) {
                TreeNode node = queue.peek();
                System.out.println(node.val);
                queue.remove();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    ((LinkedList<TreeNode>) queue).add(node.right);

                level--;
            }
        }
    }
}

