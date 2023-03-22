package com.hugo.lambdaExpression;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.util.Comparator;
import java.util.function.Consumer;

public class Main {

    @Test
    public void test1() {
        //lambda表達式(1): 無參、無返回值 => 實現 Runnable接口
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("實現Runnable介面");
            }
        };
        runnable.run();
        System.out.println("=======================");
        Runnable runnable1 = () -> {
            System.out.println("利用lambda表達式實現Runnable介面");
        };
        runnable1.run();
    }


    @Test
    public void test2() {
        //lambda表達式(2): 需要一個參數，但是沒有返回值 => 實現Consumer<String>接口
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("消費者為: " + s);
            }
        };
        consumer.accept("Hugo");
        System.out.println("=======================");
        Consumer consumer1 = (s) -> {
            System.out.println("消費者為: " + s);
        };
        consumer1.accept("Hugo");
    }

    @Test
    public void test3() {
        //lambda表達式(3): 數據類型可以省略，因為可以由編譯器推斷，稱為「類型推斷」
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        System.out.println(com1.compare(123, 22));

        System.out.println("******以下為lambda表達式******");

        Comparator<Integer> com2 = (o1, o2) -> Integer.compare(o1, o2);
        System.out.println(com2.compare(23, 41));


        System.out.println("******以下為方法引用******");
        Comparator<Integer> com3 = Integer::compareTo;
        System.out.println(com3.compare(50, 41));
    }


    @Test
    public void test4() {
        //lambda表達式(4): 若只需要一個參數時，參數的小括號可以省略
        Consumer consumer = s -> {
            System.out.println("消費者為: " + s);
        };
        consumer.accept("Hugo");
    }

    @Test
    public void test5() {
        //lambda表達式(5): 需要兩個或以上的參數時，多條執行語句，並可以有返回值
        Comparator<Integer> com2 = (o1, o2) -> {
            return Integer.compare(o1, o2);
        };
        System.out.println(com2.compare(23, 41));
    }

    @Test
    public void test6() {
        //lambda表達式(6): 右邊方法體若只有一條語句時，return與大括號若有，都可以省略
        Comparator<Integer> com = (o1, o2) -> Integer.compare(o1, o2);

        System.out.println("result: " + com.compare(23, 41));
    }

}
