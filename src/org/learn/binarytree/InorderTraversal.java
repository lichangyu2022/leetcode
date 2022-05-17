package org.learn.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94 二叉树中序遍历
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 *输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 */
public class InorderTraversal {


    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode();
        treeNode.val = 1;
       // treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(2);

        //treeNode.left.left = new TreeNode(4);
      //  treeNode.left.right = new TreeNode(5);

        treeNode.right.left = new TreeNode(3);

       // treeNode.left.left.left = new TreeNode(7);


        List<Integer> res = inorderTraversal(treeNode);
        List<Integer> res2 = inorderTraversal2(treeNode);

        System.out.println("");

    }

    private static List<Integer> inorderTraversal2(TreeNode root) {

        if (null == root){
            return new ArrayList<>();
        }
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (null != root || !stack.isEmpty()){

            while (null != root){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }

        return res;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {

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
        res.add(root.val);
        accessTree(root.right,res);
    }


}
