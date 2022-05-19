package org.learn.sort;

/**
 * 选择排序
 */
public class Selection {
    public static void main(String[] args) {
        int[] num =  {1,4,2,5,8,2,7,3};

        sort(num);
        System.out.println("");
    }

    private static int[] sort(int[] num) {

        if(0 == num.length){
            return num;
        }

        for(int i = 0; i < num.length; i++){

            int minIndex = i;
            for(int j = i; j < num.length; j++){
                if(num[j] < num[minIndex]){
                    minIndex = j;
                }
            }

            int temp = num[minIndex];
            num[minIndex] = num[i];
            num[i] = temp;

        }


        return num;

    }



}
