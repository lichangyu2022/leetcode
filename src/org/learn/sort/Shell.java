package org.learn.sort;

/**
 * 希尔排序
 * 增量序列有很多中，这里选择希尔增量
 */
public class Shell {


    public static void main(String[] args) {
        int[] nums =  {1,4,2,5,8,2,7,3};

        sort(nums);
        System.out.println("");
    }

    private static void sort(int[] nums) {

        int len = nums.length;

        int currentValue = 0;
        //增量序列
        int gap = len/2;

        while (gap > 0){

            for (int i = gap; i < len; i++){
                currentValue = nums[i];
                int preIndex = i - gap;

                while (preIndex >= 0 && nums[preIndex] > currentValue){
                    nums[preIndex + gap] = nums[preIndex];
                    preIndex -= gap;
                }
                nums[preIndex + gap] = currentValue;
            }
            gap /=2;

        }


    }


}
