package org.learn.leetcode;

import java.util.HashMap;

/**
 * leetcode 70 爬楼梯
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 *
 *
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 */
public class ClimbStairs {



    static HashMap<Integer,Integer> map = new HashMap<>();


    public static void main(String[] args) {
        long startTime = getCurrentTime();

        System.out.println(climbStairs(45));

        long endTime = getCurrentTime();
        System.out.println("climbStairs " + (endTime-startTime) + "ms");
        startTime = endTime;



        System.out.println(climbStairs2(145));

        endTime = System.currentTimeMillis();
        System.out.println("climbStairs2 " + (endTime-startTime) + "ms");
        startTime = endTime;



        System.out.println(climbStairs3(145));

        endTime = System.currentTimeMillis();
        System.out.println("climbStairs3 " + (endTime-startTime) + "ms");

    }

    public static int climbStairs3(int n) {
        if(n <= 0)
            return 0;
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;

        Integer num = 0;
        Integer pre = 2;
        Integer prePre = 1;

        for(int i = 3; i <= n; i++){
            num = pre + prePre;
            prePre = pre;
            pre = num;
        }

        return num;

    }


    public static int climbStairs2(int n) {
        if(n <= 0)
            return 0;
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;

        Integer num = map.get(n);
        if(null != num){
            return num;
        }else {
            num = climbStairs2(n-2) + climbStairs2(n-1) ;
            map.put(n,num);
            return num;
        }

    }


    public static int climbStairs(int n) {
        if(n < 0)
            return 0;
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;

        return climbStairs(n-1)+climbStairs(n-2);

    }




    private static long getCurrentTime() {
        return System.currentTimeMillis();
    }

}
