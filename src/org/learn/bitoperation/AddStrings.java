package org.learn.bitoperation;

/**
 * 415. 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 *
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 *输入：num1 = "11", num2 = "123"
 * 输出："134"
 *
 */
public class AddStrings {

    public static void main(String[] args) {
        System.out.println(addStrings("11", "123"));
    }

    public static String addStrings(String num1, String num2) {

        StringBuffer stringBuffer = new StringBuffer();
        int carry = 0;
        for (int i = num1.length()-1, j = num2.length()-1;
             i >= 0 || j >= 0 || carry > 0;
             i--,j--) {

            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';

            stringBuffer.append((x + y + carry) % 10);
            carry = (x + y + carry ) / 10;

        }


        return stringBuffer.reverse().toString();
    }
}
