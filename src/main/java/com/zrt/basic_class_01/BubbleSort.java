package com.zrt.basic_class_01;

public class BubbleSort {

       public static void bubble_sort(int[]arr){
           if(arr==null||arr.length<2){
               return;
           }
           int end=arr.length-1;
           for(int i=end;i>0;i--){
               for(int j=0;j<i;j++){
                   if(arr[j]>arr[j+1]){
                       swap(arr,j,j+1);
                   }
               }
           }

       }
       public static void swap(int[]arr,int i,int j){
           int temp=arr[i];
           arr[i]=arr[j];
           arr[j]=temp;
       }


}
