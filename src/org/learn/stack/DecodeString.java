package org.learn.stack;

import java.util.Stack;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像3a或2[4]的输入。
 输入：s = "3[a]2[bc]"
 输出："aaabcbc"
 */
public class DecodeString {


    public static void main(String[] args) {
        String decodeString = "3[a2[lc]]";

        System.out.println(decodeString(decodeString));
    }

    public static String decodeString(String s) {

        if("".equals(s)){
            return "";
        }

        Stack<String> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        StringBuffer value = new StringBuffer();

        int index = 0;
        while (index < s.length()){

            char charAt = s.charAt(index);

            if(charAt == ']'){
            //取出字符串进行循环拼接
                Integer number = numStack.pop();
                String res = strStack.pop();
                StringBuffer tempBuffer = new StringBuffer();
                tempBuffer.append(res);
                for(int i = 0; i < number; i++){
                    tempBuffer.append(value.toString());
                }
                value = tempBuffer;
            }else if(charAt == '['){
            //初始字符串
                strStack.push(value.toString());
                value = new StringBuffer();

            }else if (Character.isDigit(charAt)){
             //获取所有连续数字
                StringBuffer stringBuffer = new StringBuffer();
                while (Character.isDigit(s.charAt(index))){
                    char numChar = s.charAt(index);
                    stringBuffer.append(numChar);
                    index++;
                }
                numStack.push(Integer.parseInt(stringBuffer.toString()));
                continue;
            }else {
                //拼接内容
                value.append(charAt);
            }
            index ++;



        }


        return value.toString();
    }

}
