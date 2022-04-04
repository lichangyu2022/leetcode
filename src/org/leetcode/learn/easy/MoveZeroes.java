package org.leetcode.learn.easy;

/**
 * 移动零 leetcode 283
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 */
public class MoveZeroes {


    public static void main(String[] args) {
        int[] nums = new int[] {0,1,0,3,12};

        moveZeroes(nums);
        System.out.println();
    }


    private static void moveZeroes(int[] nums) {

        if(null == nums){
            return;
        }
        int effectiveIndex = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[effectiveIndex++] = nums[i];

            }
        }


        for( int i = effectiveIndex; i < nums.length; i++){

            nums[i] = 0;

        }


    }


}
