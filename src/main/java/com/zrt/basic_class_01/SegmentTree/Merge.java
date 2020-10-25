package com.zrt.basic_class_01.SegmentTree;

/**
 * @Author:zrt
 * @Date:2020/10/25-10-25-13:50
 * @Description:com.zrt.basic_class_01.SegmentTree
 * @version:1.0
 */
public interface Merge<E> {

    E merge(E a,E b);
}
