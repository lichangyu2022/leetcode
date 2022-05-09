package org.learn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 *
 输入：nums = [4,3,2,7,8,2,3,1]
 输出：[5,6]
 */
public class FindDisappearedNumbers {


    public static void main(String[] args) {

        //int[] nums = new int[] {4,3,2,7,8,2,3,1};
        int[] nums = new int[] {1,1};
        List<Integer> res = findDisappearedNumbers(nums);
        System.out.println();
    }


    public static List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();

        int n = nums.length;

        for(int i = 0; i < nums.length; i++){

            int j = (nums[i] - 1) % n;
            nums[j] += n;
        }

        for(int i = 0; i < nums.length; i++){

            if(nums[i] <= n){
                result.add(i+1);
            }
        }

        return result;
    }

}
