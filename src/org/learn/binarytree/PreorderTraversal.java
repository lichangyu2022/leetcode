package org.learn.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144 二叉树前序遍历
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 *输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 */
public class PreorderTraversal {


    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode();
        treeNode.val = 1;
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);

        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);

        treeNode.right.left = new TreeNode(6);

        treeNode.left.left.left = new TreeNode(7);


        List<Integer> res = preorderTraversal(treeNode);
        List<Integer> res2 = preorderTraversal2(treeNode);

        System.out.println("");

    }

    private static List<Integer> preorderTraversal2(TreeNode root) {

        if (null == root){
            return new ArrayList<>();
        }
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (null != root || !stack.isEmpty()){

            while (null != root){
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            root = root.right;
        }

        return res;
    }

    public static List<Integer> preorderTraversal(TreeNode root) {

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

        res.add(root.val);
        accessTree(root.left,res);
        accessTree(root.right,res);
    }


}
