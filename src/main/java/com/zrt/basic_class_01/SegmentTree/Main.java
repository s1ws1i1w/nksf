package com.zrt.basic_class_01.SegmentTree;

/**
 * @Author:zrt
 * @Date:2020/10/25-10-25-13:52
 * @Description:com.zrt.basic_class_01.SegmentTree
 * @version:1.0
 */
public class Main {
    public static void main(String[] args) {

        Integer[]nums={-2,0,3,-5,2,-1};
        SegmentTree<Integer> segTree=new SegmentTree<Integer>(nums,(a,b)-> a+b);
//        System.out.println(segTree);
        System.out.println(segTree.query(0,2));
        System.out.println(segTree.query(2,5));
        System.out.println(segTree.query(0,5));
    }
}
