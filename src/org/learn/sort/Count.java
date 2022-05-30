package org.learn.sort;

import java.util.Arrays;

/**
 * 计数排序，适用于整数排序，且数据分布比较连续，区间跨度小
 */
public class Count {

    public static void main(String[] args) {
        int[] nums =  {1,4,2,5,8,2,7,3};

        sort(nums);
        System.out.println("");
    }

    private static void sort(int[] nums) {
       if(nums.length == 0){
           return;
       }

       //找到最大值最小值
        int max = nums[0];
        int min = nums[0];
        for (int i = 0; i <nums.length; i++) {
            if(nums[i] > max){
                max = nums[i];
            }
            if(nums[i] < min){
                min = nums[i];
            }
        }

        //偏移量，定位原始数据每个元素在计数数组中的小标位置
        int bias = 0-min;
        int[] counterArray = new int[max - min + 1];
        Arrays.fill(counterArray,0);

        for (int i = 0; i <nums.length; i++) {
            counterArray[nums[i] + bias]++;
        }



        //访问原始数组时的下标计算器
        int index = 0;
        //访问计数数组时的下表计数器
        int i = 0;

        while (index < nums.length){
            if(counterArray[i] != 0){
                nums[index] = i - bias;
                counterArray[i]--;
                index++;
            }else {
                i++;
            }
        }




    }






}
