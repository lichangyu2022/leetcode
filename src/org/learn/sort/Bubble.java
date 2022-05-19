package org.learn.sort;

/**
 * 冒泡排序
 */
public class Bubble {

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

            for(int j = 0; j < num.length -1 - i; j++){
                if(num[j + 1] < num[j]){
                    int temp = num[j + 1];
                    num[j + 1] = num[j];
                    num[j] = temp;
                }
            }

        }


        return num;

    }


}
