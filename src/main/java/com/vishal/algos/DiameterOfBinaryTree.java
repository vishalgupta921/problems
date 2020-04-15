package com.vishal.algos;

public class DiameterOfBinaryTree {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        t1.left = t2;
        t2.left = new TreeNode(4);
        t2.right = new TreeNode(5);
        int d = diameterOfBinaryTree(t1);
        System.out.println(d);
    }
    static int dia = 0;
    public static int diameterOfBinaryTree(TreeNode root) {
        nodes(root);
        return dia;
    }

    private static int nodes(TreeNode root) {
        if(root == null)
            return -1;
        int left = nodes(root.left);
        int right = nodes(root.right);
        dia = Math.max(left+right+2, dia);
        return Math.max(left, right)+1;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}