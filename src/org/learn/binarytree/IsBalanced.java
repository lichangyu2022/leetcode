package org.learn.binarytree;

/**
 * 110. 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 */
public class IsBalanced {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        treeNode.val = 1;
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(2);

        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(4);

        treeNode.right.left = new TreeNode(4);


        System.out.println(isBalanced(treeNode));
    }

    private static boolean isBalanced(TreeNode root) {
        if(null == root){
            return true;
        }

        return checkDouble(root) != -1;


    }

    private static int checkDouble(TreeNode root) {

        if(null == root){
            return 0;
        }
        int left = checkDouble(root.left);
        int right = checkDouble(root.right);

        if(-1 == left || -1 == right || Math.abs(left - right) > 1){
            return -1;
        }
        return Math.max(left,right)+1;


    }
}
