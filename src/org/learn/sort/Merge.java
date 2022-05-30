package org.learn.sort;

import java.util.Arrays;

/**
 * 归并排序，利用对数组的不断拆分来实现排序
 */
public class Merge {



    public static void main(String[] args) {
        int[] nums =  {1,4,2,5,8,2,7,3};

        int[] sort = sort(nums);
        System.out.println("");
    }

    private static int[] sort(int[] nums) {
        if (nums.length < 2){
            return nums;
        }

        int mid = nums.length / 2;
        int[] left = Arrays.copyOfRange(nums,0,mid);
        int[] right = Arrays.copyOfRange(nums,mid,nums.length);

        return merge(sort(left),sort(right));


    }

    private static int[] merge(int[] left, int[] right) {

        int[] result = new int[left.length + right.length];

        for(int index = 0, i = 0, j=0; index < result.length; index++){
            if(i >= left.length){

                result[index] = right[j++];

            }else if(j >= right.length){

                result[index] = left[i++];

            }else if(left[i] > right[j]){

                result[index] = right[j++];

            }else {

                result[index] = left[i++];

            }
        }

        return result;
    }

}
