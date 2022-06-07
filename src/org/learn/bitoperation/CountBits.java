package org.learn.bitoperation;

/**
 * 338. 比特位计数
 * 给你一个整数 n ，对于0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 *
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：[0,1,1]
 * 解释：
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 示例 2：
 *
 * 输入：n = 5
 * 输出：[0,1,1,2,1,2]
 * 解释：
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 *
 */
public class CountBits {


    public static void main(String[] args) {
        int n = 10;
        int[] res = countBits2(n);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    private static int[] countBits(int n) {


        int[] res = new int[n+1];

        for (int i = 1; i <= n; i++) {
            res[i] = res[i & (i - 1)] + 1;
        }

        return res;

    }

    private static int[] countBits2(int n) {

        int[] res = new int[n+1];

        for (int i = 1; i <= n; i++) {
            res[i] = ( (i & 1) == 1 ? res[i - 1] + 1 : res[i >> 1]  );
        }

        return res;
    }


}
