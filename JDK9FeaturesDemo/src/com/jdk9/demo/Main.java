package com.jdk9.demo;

import org.junit.Test;

import java.io.*;
import java.util.Scanner;

public class Main {
    /**
     * java9 新特性
     * 1. try-with-resources
     * 替代try-catch-finally，將需要手動關閉資源的實例對象，放入在try的括號參數內，執行時關閉資源的處理就不用再由開發者去撰寫
     */


    @Test
    public void test1() {
        //將鍵盤輸入的字輸出控制台
        System.out.println("請輸入:  ");
        ByteArrayInputStream bais = new ByteArrayInputStream("this is keyboard input...".getBytes());
        System.setIn(bais);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try(br){
            String input = br.readLine();
            System.out.println(input);
        }catch (Exception e){
            e.printStackTrace();
        }

        System.setIn(System.in);






    }
}
