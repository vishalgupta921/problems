package com.vishal.algos;

/**
 *
 * Construct Binary Search Tree from Preorder Traversal
 *
 * Return the root node of a binary search tree that matches the given preorder traversal.
 *
 */
public class ConstructBinarySearchTreeFromPreorderTraversal {

    public static void main(String[] args) {
        int[] preorder = new int[]{8,5,1,7,10,12};
        TreeNode root = bstFromPreorder(preorder);
        System.out.println(root);
    }

    private static TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = null;
        for(int val : preorder) {
            root = bstFromPreorder_handler(root, val);
        }

        /*
            TreeNode root = new TreeNode(preorder[0]);
            for(int i = 1; i < preorder.length; i++) {
                TreeNode node = findNodeToAttach(root, preorder[i]);
                if(preorder[i] < node.val) {
                    node.left = new TreeNode(preorder[i]);
                }else {
                    node.right = new TreeNode(preorder[i]);
                }
            }
         */


        return root;
    }

    //Run loop in recurssion
    /*
        int cur = 0;
        public TreeNode bstFromPreorder(int[] preorder) {
            return helper(preorder, Integer.MAX_VALUE);
        }

        public TreeNode helper(int []preorder, int bound) {
            if(cur >= preorder.length || preorder[cur] > bound) {
                return null;
            }
            int curVal = preorder[cur++];
            TreeNode curNode = new TreeNode(curVal);
            curNode.left = helper(preorder, curVal);
            curNode.right = helper(preorder, bound);
            return curNode;
        }
     */

    //Find right value in recussion
    /*
        helper(preorder, 0, preorder.length - 1);
        private TreeNode helper(int[] preorder, int start, int end) {
            if(start > end) return null;

            TreeNode node = new TreeNode(preorder[start]);
            int i;
            for(i=start;i<=end;i++) {
            if(preorder[i] > node.val)
                break;
            }

            node.left = helper(preorder, start+1, i-1);
            node.right = helper(preorder, i, end);
            return node;
        }
     */

    private static TreeNode bstFromPreorder_handler(TreeNode node, int val) {
        if(node == null)
            return new TreeNode(val);
        if(val > node.val) {
            node.right = bstFromPreorder_handler(node.right, val);
        }else{
            node.left = bstFromPreorder_handler(node.left, val);
        }
        return node;
    }

    private static TreeNode findNodeToAttach(TreeNode root, int val) {
        while ((root.val > val && root.left != null) || (root.val < val && root.right != null)) {
            if(root.val > val) {
                root = root.left;
            }else {
                root = root.right;
            }
        }
        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
