package org.learn.sort;

/**
 * 堆排序，从完全二叉树中取出root节点当做最大值
 */
public class Heap {


    private  static  int len;

    public static void main(String[] args) {
        int[] nums =  {1,4,2,5,8,2,7,3};

        sort(nums);
        System.out.println("");
    }

    private static void sort(int[] nums) {
        len = nums.length;
        if(len < 1){
            return ;
        }

        //构建最大堆
        buildMaxHeap(nums);

        //循环将首位与末尾交换，然后重新调整最大堆
        while (len > 0){
            swap(nums,0,len - 1);
            len--;
            adjustHeap(nums,0);
        }

    }

    private static void adjustHeap(int[] array, int i) {
        int maxIndex = i;
        int left = 2 * i + 1;
        int right = 2 * (i + 1);

        if(left < len && array[left] > array[maxIndex]){
            maxIndex = left;
        }

        boolean isOrNO = right < len && array[right] > array[maxIndex] && array[right] > array[left];
        if(isOrNO){
            maxIndex = right;
        }
        if (maxIndex != i){
            swap(array,maxIndex,i);
            adjustHeap(array,maxIndex);
        }


    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void buildMaxHeap(int[] array) {
        for (int i = len / 2 - 1; i >= 0; i--) {
            adjustHeap(array,i);
        }
    }


}
