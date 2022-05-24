package org.learn.sort;

/**
 * 快速排序
 */
public class Quick {

    public static void main(String[] args) {
        int[] num =  {1,4,2,5,8,2,7,3};

        sort(num);
        System.out.println("");
    }

    private static int[] sort(int[] num) {

        return sortArray(num,0,num.length-1);

    }

    private static int[] sortArray(int[] array, int start, int end) {
        if(array.length < 1 || start < 0 || end >= array.length || start > end){
            return null;
        }
        //将数据分成两部分，作为分区的指示器
        int zoneIndex = partition(array,start,end);

        if(zoneIndex > start){
            sortArray(array,start,zoneIndex - 1);
        }
        if(zoneIndex < end){
            sortArray(array,zoneIndex + 1, end);
        }

        return array;
    }

    private static int partition(int[] array, int start, int end) {

        if(start == end){
            return start;
        }
        //int pivot = (int) (start + Math.random() * (end -start + 1));
        int pivot = start;

        //zoneindex 是分区指示器，初始值为分区头元素下标减一
        int zoneIndex = start - 1;
        //将基准数和分区尾元素交换位置
        swap(array,pivot,end);
        for(int i = start; i <= end; i++){
            //当前元素小于等于基准数
            if(array[i] <= array[end]){
                //分区指示器加一
                zoneIndex++;
                //当前元素在分区指示器的右边时，交换当前元素和分区指示器元素
                if(i > zoneIndex){
                    swap(array,i,zoneIndex);
                }
            }
        }
        return zoneIndex;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
