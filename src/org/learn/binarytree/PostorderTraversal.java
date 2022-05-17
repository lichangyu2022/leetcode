package org.learn.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 145 二叉树后序遍历
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 * 输入：root = [1,null,2,3]
 * 输出：[3,2,1]
 */
public class PostorderTraversal {

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode();
        treeNode.val = 1;
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);

        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);

        treeNode.right.left = new TreeNode(6);

        treeNode.left.left.left = new TreeNode(7);


        List<Integer> res = postorderTraversal(treeNode);
        List<Integer> res2 = postorderTraversal2(treeNode);

        System.out.println("");

    }

    private static List<Integer> postorderTraversal2(TreeNode root) {

        if (null == root){
            return new ArrayList<>();
        }
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;

        while (null != root || !stack.isEmpty()){

            while (null != root){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if(null == root.right || root.right == pre){
                res.add(root.val);
                pre = root;
                root = null;
            }else {
                stack.push(root);
                root = root.right;
            }

        }

        return res;
    }

    public static List<Integer> postorderTraversal(TreeNode root) {

        if (null == root){
            return new ArrayList<>();
        }
        ArrayList<Integer> res = new ArrayList<>();
        accessTree(root,res);
        return res;

    }

    private static void accessTree(TreeNode root, ArrayList<Integer> res) {

        if(null == root){
            return;
        }

        accessTree(root.left,res);
        accessTree(root.right,res);
        res.add(root.val);
    }


}
