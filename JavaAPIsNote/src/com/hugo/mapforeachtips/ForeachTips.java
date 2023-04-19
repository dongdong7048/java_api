package com.hugo.mapforeachtips;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ForeachTips {

    /**
     * 關於Java的Map使用forEach進行遍歷操作時的注意事項
     * 1. 不允许直接对Map进行put或remove操作，會報出java.util.ConcurrentModificationException的異常
     * 2. 底層原理說明：
     *      在使用Map的forEach方法進行遍歷时，實際上會使用Map的內部迭代器來對Map進行遍歷。
     *      這個迭代器會在遍歷過程中維護一个Map的快照(snapshot)，用於隨時檢查快照與實際Map是否保持一致。
     *      如果在遍歷過程中使用Map的put方法進行添加修改(put)或刪除(remove)键值對，會導致Map的結構發生改變，從而與迭代器維護的快照不一致，導致遍歷過程異常或不正確。
     * 3. 解決辦法：
     *      遍歷時若要對map進行刪除操作，建議使用iterator迭代器的remove操作
     *      遍歷時若要對map進行增加操作，建議創建另一個臨時map增加需要的元素，待遍歷完成後再補上到原來的map
     * * */

    @Test
    public void testForeach(){
        Map m1 = new HashMap();
        m1.put("name", "Gino");
        m1.put("age", 30);
        m1.put("gender", "man");
        m1.put("occupation", "engineer");
        m1.put("status", "newEmp");

        // 情境1. 如果職業為enginner時，增加一個salaryOver為1000000的key value
        // 不允许直接对Map进行put或remove操作，會報出java.util.ConcurrentModificationException的異常
//        m1.forEach((key,value)->{
//            if("engineer".equals(value)) {
//                m1.put("salaryOver", 1000000);
//            }
//            System.out.println(key+" : "+value);
//        });

        // 解法1.使用臨時map來增加元素
        System.out.println("如果職業為enginner時，增加一個salaryOver為1000000的資料");
        Map m2 = new HashMap();
        m1.forEach((k,v)->{
            if("engineer".equals(v)) {
                m2.put("salaryOver", 1000000);
            }
        });
        m1.putAll(m2);
        m1.forEach((key,value)-> System.out.println(key+" : "+value));
        System.out.println("==========================================");




        // 情境2. 如果職業為enginner時，刪除這個鍵值對
        // 不允许直接对Map進行remove操作，會報出java.util.ConcurrentModificationException的異常
//        Iterator<Map.Entry> it = m1.entrySet().iterator();
//        while (it.hasNext()){
//            Map.Entry entry = it.next();
//            if("engineer".equals(entry.getValue())) {
//                m1.remove("engineer");
//            }
//        }

        //解法2. 使用iterator迭代器的remove方法來進行刪除操作
        System.out.println("職業為enginner時，刪除這個鍵值對");
        Iterator<Map.Entry> it = m1.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = it.next();
            if ("engineer".equals(entry.getValue())) {
                it.remove();
            }
        }

        m1.forEach((key,value)-> System.out.println(key+" : "+value));

    }


}