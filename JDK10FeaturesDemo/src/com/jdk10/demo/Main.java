package com.jdk10.demo;

import org.junit.Test;

import java.util.*;

public class Main {
    /**
     *  Java 10 引入了一個新的關鍵字 "var"，用於聲明局部變量，以使其可以根據上下文自動推斷變量的類型。
     *  這種方式被稱為"局部變量類型推斷"。 在 JDK 10 中，它僅適用於局部變量，不能用於方法參數、成員變量、靜態變量或返回值。
     *
     *  使用優點：
     *  1. 增加可讀性與減少冗餘代碼
     *  2. 可在循環中使用
     *
     *  常用場景：
     *  1. 使用在 new 實例對象的變量 
     *  2. 使用在方法的返回
     *  3. 使用在循環
     *
     * */
    @Test
    public void test1(){
        // 1. 增加可讀性與減少冗餘代碼
        var myMap = new HashMap<String, Integer>(); // 創建一個 Map 對象
        Map<String,Integer> myMap2 = new HashMap<String, Integer>(); // 傳統創建一個 Map 對象

        var entries = myMap.entrySet(); // 獲得一個 set 對象
        Set<Map.Entry<String, Integer>> entries2 = myMap.entrySet(); // 傳統 獲得一個 set 對象


        // 2. 可在循環中使用
        List list = Arrays.asList("father","mather","grandma");
        for(var i : list){
            System.out.print(i+",\t");
        }
    }
}
