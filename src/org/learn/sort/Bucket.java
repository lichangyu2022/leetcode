package org.learn.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 桶排序
 */
public class Bucket {

    public static void main(String[] args) {
        Integer[] nums =  {1,4,2,5,9,2,7,3};


        List<Integer> sort = sort(Arrays.asList(nums), 3);

        System.out.println("");
    }

    private static List<Integer> sort(List<Integer> nums, int bucketCap) {

        ArrayList<Integer> res = new ArrayList<>();
        if(nums.size() == 0){
            return nums;
        }

        //找到最大值最小值
        int max = nums.get(0);
        int min = nums.get(0);
        for (int i = 0; i <nums.size(); i++) {
            if(nums.get(i) > max){
                max = nums.get(i);
            }
            if(nums.get(i) < min){
                min = nums.get(i);
            }
        }

        //获取桶的数量
        int bucketCount = (max - min) /bucketCap + 1;
        //构建桶
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }
        //将原始数组中的数据分配到铜中
        for (int i = 0; i < nums.size(); i++) {
            bucketArr.get( (nums.get(i) - min) / bucketCap ).add(nums.get(i));
        }

        for (int i = 0; i < bucketCount; i++) {
            if(bucketCap == 1){
                for (int j = 0; j < bucketArr.get(i).size(); j++) {
                    res.add(bucketArr.get(i).get(j));
                }
            }else {
                if (bucketCount == 1){
                    bucketCap --;
                }

                List<Integer> tmp = sort(bucketArr.get(i), bucketCap);
                for (int j = 0; j < tmp.size(); j++) {
                    res.add(tmp.get(j));
                }
            }
        }

        return res;


    }





}
