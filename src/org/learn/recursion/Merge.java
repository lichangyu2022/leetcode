package org.learn.recursion;

/**
 * 两数组合并  leetcode 99
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 *
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 *
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 *
 *输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 *
 */
public class Merge {


    public static void main(String[] args) {

        int[] nums1 = new int[] {1,2,3,0,0,0};
        int[] nums2 = new int[] {2,5,6};

        int m = 3;
        int n = 3;

        //merge(nums1,m,nums2,n);
        merge2(nums1,m,nums2,n);
        System.out.println();
    }

    /**
     * 双指针，进行排序
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] temp = new int[nums1.length];
        int num1index = 0;
        int num2index = 0;


        for(int i = 0; i < temp.length; i++){

            //num1中无值了  直接接num2
            if(num1index >= m){
                temp[i] = nums2[num2index];
                num2index++ ;
            }else if(num2index >= n){ // num2无值了，直接接num1
                temp[i] = nums1[num1index];
                num1index++ ;
            }else if(nums1[num1index] > nums2[num2index]){ //如果num1 大于 num2 先存num2
                temp[i] = nums2[num2index];
                num2index++ ;
            }else { // 最终不管是等于还是小于  都先存 num1
                temp[i] = nums1[num1index];
                num1index++ ;
            }

        }

        //临时数组赋值给num1
        for(int i = 0; i < temp.length; i++){

            nums1[i] = temp[i];
        }
    }


    public static void merge2(int[] nums1, int m, int[] nums2, int n) {

        int num1index = m-1;
        int num2index = n-1;


        for(int i = nums1.length-1; i >= 0; i--){

            //num1中无值了  直接接num2
            if(num1index < 0){
                nums1[i] = nums2[num2index];
                num2index-- ;
            }else if(num2index < 0){ // num2无值了，直接接num1
                nums1[i] = nums1[num1index];
                num1index-- ;
            }else if(nums1[num1index] < nums2[num2index]){ //如果num1 小于 num2 先存num2
                nums1[i] = nums2[num2index];
                num2index-- ;
            }else { // 最终不管是等于还是大于  都先存 num1
                nums1[i] = nums1[num1index];
                num1index-- ;
            }

        }


    }

}
