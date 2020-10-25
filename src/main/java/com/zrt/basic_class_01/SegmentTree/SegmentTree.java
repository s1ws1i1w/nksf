package com.zrt.basic_class_01.SegmentTree;


/**
 * @Author:zrt
 * @Date:2020/10/25-10-25-12:53
 * @Description:com.zrt.basic_class_01.SegmentTree
 * @version:1.0
 */
public class SegmentTree<E> {

     private  E[] tree;
     private  E[] data;
     private  Merge<E> merge;
     public SegmentTree(E[] arr,Merge<E> merge){
            this.merge=merge;
            data=(E[])new Object[arr.length];
            for(int i=0;i<arr.length;i++)
                 data[i]=arr[i];
            tree=(E[])new Object[4*arr.length];
           buildSegmentTree(0,0,data.length-1);
     }
     public int getSize(){
         return data.length;
     }
     public E get(int index){
         if(index<0||index>=data.length)
              throw new IllegalArgumentException("Index is illegal");
           return data[index];
     }
       //返回完全二叉树的数组表示,一个索引所表示的元素的左孩子的索引
    public  int leftChild(int index){
         return 2*index+1;
    }
    public int rightChile(int index){
         return 2*index+2;
    }

   //在treeIndex的位置创建区间[l,...r]的线段树
    private void buildSegmentTree(int treeIndex,int l,int r){
         if(l==r){
             tree[treeIndex]=data[l];
             return;
         }
         int leftIndex=leftChild(treeIndex);
         int rightIndex=rightChile(treeIndex);
         int mid=l+(r-l)/2;
         buildSegmentTree(leftIndex,l,mid);
         buildSegmentTree(rightIndex,mid+1,r);
        tree[treeIndex]=merge.merge(tree[leftIndex],tree[rightIndex]);
    }
    @Override
    public String toString(){
         StringBuilder res=new StringBuilder();
         res.append('[');
         for(int i=0;i<tree.length;i++){
             if(tree[i]!=null)
                 res.append(tree[i]);
             else
                 res.append("null");
             if(i!=tree.length-1){
                 res.append(" ");
             }else res.append("]");
         }
         return res.toString();
    }
    //返回区间[queryL,queryR]的值
    public E query(int queryL,int queryR){
         if(queryL<0||queryL>=data.length||queryR<0||queryR>=data.length||queryL>queryR){
             throw new IllegalArgumentException("Index is illegal.");
         }
         return  query(0,0,data.length-1,queryL,queryR);
    }
   //在以treeID为根的线段树中[l...r]的范围里,搜索区间[queryL...queryR]的值
    public E query(int treeIndex,int l,int r,int queryL,int queryR){
         if(l==queryL&&r==queryR){
              return tree[treeIndex];
         }
         int leftIndex=leftChild(treeIndex);
         int rightIndex=rightChile(treeIndex);
         int mid=l+(r-l)/2;
         if(queryL>=mid+1){
             return query(rightIndex,mid+1,r,queryL,queryR);
         }
         else if(queryR<=mid){
             return query(leftIndex,l,mid,queryL,queryR);         }
         else {
             E ResultL=query(leftIndex,l,mid,queryL,mid);
             E ResultR=query(rightIndex,mid+1,r,mid+1,queryR);
             return merge.merge(ResultL,ResultR);
         }
    }

}
