package org.learn.recursion;

import java.util.HashMap;

/**
 * 两数之和 leetcode 1
 *输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 */
public class TwoSum {


    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        int[] res = twoSum(nums, target);
        System.out.println(res[0] +" "+ res[1]);
    }


    public static int[] twoSum(int[] nums,int target){

        HashMap<Integer, Integer> storeResults = new HashMap<>();
        int[] res = new int[2];

        for(int i = 0; i < nums.length; i++){

            int another = target - nums[i];
            Integer anotherIndex = storeResults.get(another);

            if(null != anotherIndex){
                res[0] = i;
                res[1] = anotherIndex;
                break;
            }else{
                storeResults.put(nums[i],i);
            }

        }

        return res;

    }


}
