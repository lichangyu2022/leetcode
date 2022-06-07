package org.learn.bitoperation;

/**
 *461. 汉明距离
 *
 * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离
 * 输入：x = 1, y = 4
 * 输出：2
 * 解释：
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 * 上面的箭头指出了对应二进制位不同的位置。
 *
 */
public class HammingDistance {

    public static void main(String[] args) {
        int x = 3;
        int y = 10;
        int distance = hammingDistance(x,y);
        System.out.println(distance);
    }

    private static int hammingDistance(int x, int y) {
        int distance = 0;

        for(int xor = x ^ y; xor != 0; xor &= (xor - 1)){
            distance++;
        }

        return distance;


    }

}
