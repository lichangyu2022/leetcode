package org.learn.sort;

/**
 * 插入排序
 */
public class Insertion {

    public static void main(String[] args) {
        int[] num =  {1,4,2,5,8,2,7,3};

        sort(num);
        System.out.println("");
    }

    private static int[] sort(int[] num) {

        if(0 == num.length){
            return num;
        }

        //待排序的数据，该数据前的元素都是有序的
        int currentValue;

        for(int i = 0; i < num.length - 1; i++){
            //已经被排序的数据下包
            int preIndex = i;
            currentValue = num[preIndex + 1];

            while (preIndex >= 0 && currentValue < num[preIndex]){
                num[preIndex + 1] = num[preIndex];
                preIndex--;
            }
            num[preIndex+1] = currentValue;

        }


        return num;

    }



}
