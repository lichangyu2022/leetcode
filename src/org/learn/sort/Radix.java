package org.learn.sort;

import java.util.ArrayList;

/**
 * 基数排序
 */
public class Radix {

    public static void main(String[] args) {
        int[] nums =  {11,4,23,57,89,2,73,3};

        sort(nums);
        System.out.println("");
    }

    private static void sort(int[] nums) {
        if (null == nums || nums.length < 2){
            return;
        }

        //找出最大值
        int max = nums[0];
        for (int i = 0; i <nums.length; i++) {
            if(nums[i] > max){
                max = nums[i];
            }
        }

        //算出数值的最大位
        int maxDigit = 0;
        while (max != 0){
            max /= 10;
            maxDigit++;
        }

        int mod = 10;
        int div = 1;

        //构建桶
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            bucketList.add(new ArrayList<>());
        }

        for (int i = 0; i < maxDigit; i++,mod *= 10,div *= 10) {
            //遍历原始数组，投入铜中
            for (int j = 0; j < nums.length; j++) {
                int num = (nums[j] % mod) / div;
                bucketList.get(num).add(nums[j]);
            }


            //写会原始数组
            int index = 0;
            for (int j = 0; j < bucketList.size(); j++) {
                for (int k = 0; k < bucketList.get(j).size(); k++) {
                    nums[index++] = bucketList.get(j).get(k);
                }
                bucketList.get(j).clear();
            }

        }


    }


}
