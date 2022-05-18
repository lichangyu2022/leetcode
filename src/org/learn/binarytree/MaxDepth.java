package org.learn.binarytree;

/**
 * leetocde 104 二叉树最大深度
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明:叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * return 3
 */
public class MaxDepth {


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        treeNode.val = 1;
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(2);

        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(4);

        treeNode.right.left = new TreeNode(4);


        System.out.println(maxDepth(treeNode));
    }

    private static Integer maxDepth(TreeNode root) {
        if(null == root){
            return 0;
        }
        int leftMax = maxDepth(root.left)+1;
        int rightMax = maxDepth(root.right)+1;

        if(leftMax - rightMax >=0){
            return leftMax;
        }else {
            return rightMax;
        }
    }

}
