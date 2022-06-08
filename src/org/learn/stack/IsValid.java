package org.learn.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * 输入：s = "()"
 * 输出：true
 *
 * 输入：s = "(]"
 * 输出：false
 */
public class IsValid {


    public static void main(String[] args) {
        String s = "()";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {

        if(null == s | s.length() == 0){
            return true;
        }

        Deque<Character> stack = new LinkedList<>();

        for (char c : s.toCharArray()) {
            if ( c == '('){
                stack.push(')');
            }else if ( c == '{'){
                stack.push('}');
            }else if ( c == '['){
                stack.push(']');
            }else if (stack.isEmpty() | stack.pop() != c){
                return false;
            }
        }
        return stack.isEmpty();




    }








}
