package com.zrt.basic_class_01;

/**
 * @Author:zrt
 * @Date:2020/10/24-10-24-15:07
 * @Description:com.zrt.basic_class_01
 * @version:1.0
 */
public class SelectionSort {

    public static void selectionSort(int[]arr){
        if(arr==null||arr.length<2){
            return;
        }
        for(int i=0;i<arr.length;i++) {
            int minindex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minindex = arr[minindex] > arr[j] ? j : minindex;
            }
            swap(arr,i,minindex);
        }

    }
    public static void swap(int[]arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
