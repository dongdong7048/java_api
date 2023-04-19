package com.hugo.listforeachtips;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ForeachTips {

    /**
     * 關於list使用forEach遍歷操作時，不要在遍歷時對list進行修改或刪除操作，會產生java.util.ConcurrentModificationException的異常
     * 底層原理說明：
     *     當使用 List 的 forEach 方法遍歷時，實際上是使用了一個遍歷器（iterator），這個遍歷器內部維護了一個所謂的 modCount 屬性，
     *     它代表了 List 的修改次數。當你對 List 進行修改或刪除操作時，modCount 屬性會增加，
     *     但是當你在遍歷期間對 List 進行修改或刪除操作時，modCount 屬性不會同步更新，這導致了 List 和遍歷器的 modCount 屬性不一致，
     *     從而觸發了 ConcurrentModificationException 異常。
     * 解決辦法：
     *     可以使用 Iterator 的 remove() 方法刪除元素，而不是直接對 List 進行修改或刪除操作。
     *     這樣可以保證 modCount 屬性和遍歷器的狀態保持一致，從而避免了 ConcurrentModificationException 異常的出現。
     * */

    @Test
    public void testForeach() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        // 情境1： 刪除列表中所有的奇數
        // 以下會產生java.util.ConcurrentModificationException的異常
//        list.forEach(i->{
//            if(i/2 != 0){
//                list.remove(i);
//            }
//        });

        // 解法1：使用iterator迭代器的remove操作
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            if (i % 2 != 0 && i > 0) {
                it.remove();
            }

        }

        System.out.println(list);
    }
}
