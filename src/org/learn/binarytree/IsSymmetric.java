package org.learn.binarytree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode101 对称二叉树
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 *
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 */
public class IsSymmetric {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        treeNode.val = 1;
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(2);

        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(4);

        treeNode.right.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(3);


        System.out.println(isSymmetric(treeNode));

        System.out.println(isSymmetric2(treeNode));
    }

    private static boolean isSymmetric2(TreeNode root) {
        if(null == root){
            return true;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(left);
        queue.offer(right);

        if(null == left && null == right){
            return true;
        }

        while (!queue.isEmpty()){
            left = queue.poll();
            right = queue.poll();

            if(null == left && null == right){
                continue;
            }

            if(null == left || null == right){
                return false;
            }
            if(left.val != right.val){
                return false;
            }

            queue.offer(left.left);
            queue.offer(right.right);

            queue.offer(left.right);
            queue.offer(right.left);

        }
        return true;
    }


    public static boolean isSymmetric(TreeNode root) {

        if(null == root){
            return true;
        }

        return checkDouble(root.left,root.right);

    }

    private static boolean checkDouble(TreeNode left, TreeNode right) {
        if(null == left && null == right){
            return true;
        }

        if(null == left || null == right){
            return false;
        }

        if(left.val != right.val){
            return false;
        }

        return  checkDouble(left.left,right.right) && checkDouble(left.right,right.left);
    }


}
