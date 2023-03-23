package com.hugo.stream;


import com.hugo.pojo.Employee;
import com.hugo.pojo.EmployeeList;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo1 {
    /**
     * Stream Api
     * 1. 關注的是多個數據的計算(排序、查找、過濾、映射、遍歷等)，面相CPU的
     * 2. 使用說明
     *    1) Stream自己不會存儲元素
     *    2) Stream不會改變原始對象，相反的他們會返回一個持有結果的新Stream
     *    3) Stream操作是延遲執行的，這意味著他們會等到需要結果的時候才執行，且一旦執行終止操作，就會執行中間操作鍊，並產生結果
     *    4) Stream一旦執行了終止操作，就不能再調用其他的中間操作或終止操作
     * 3. 執行流程
     *    步驟1 Stream的實例化 ex: xxxlist.stream()
     *    步驟2 一系列的中間操作 ex: xxxList.stream().map(()->{})
     *    步驟3 執行終止操作 ex: xxxList.stream().filter().forEach(System::println)
     * 4. 中間操作 種類
     *    1) 過濾與切片 filter、limit、skip
     *    2) 映射 map
     *    3) 排序 sort
     * 5. 終止操作 種類
     *    1) 匹配與查找
     *       allMatch(Predicate p) -- 檢查是否匹配所有元素
     *       anyMatch(Predicate p) -- 檢查是否至少匹配一個元素
     *       findFirst -- 返回第一個元素
     *       count -- 返回流中的所有元素個數
     *       max(Comparator c) -- 返回流中元素的最大值
     *       min(Comparator c) -- 返回流中元素的最小值
     *       forEach(Comsumer c) -- 內部迭代
     *    2) 歸約
     *       reduce(Function f)
     *    3) 收集
     *       collect(Collector c)
     */

    // 中間操作 1.過濾與切片
    @Test
    public void test1(){
        //filter(Predicate p) -- 接收lambda，從流中排除某些元素
        //查詢員工工資大於2000000的
        System.out.println("======= stream filter ======= ");
        List<Employee> list = EmployeeList.getEmployeeList();
        list.stream().filter(employee -> employee.getSalary()>2000000).forEach(System.out::println);


        System.out.println();


        //limit(n) -- 截斷流，使其元素不超過指定數量
        //查詢員工工資大於2000000的前兩筆資料
        System.out.println("======= stream limit ======= ");
        list.stream().filter(employee -> employee.getSalary()>2000000).limit(2).forEach(System.out::println);

        System.out.println();

        //skip(n) -- 跳過元素，反回一個扔掉了前n個元素的流
        //查詢員工前5筆以外的資料
        System.out.println("======= stream skip ======= ");
        list.stream().skip(5).forEach(System.out::println);
    }


    // 中間操作 2.映射
    @Test
    public void test2(){
        //map(Function f) -- 接收一個函數作為參數，將元素轉換成其他形式或提取訊息，該函數會被應用到每個元素
        //所有員工姓名變為大寫
        System.out.println("======= stream map ======= ");
        List<Employee> list = EmployeeList.getEmployeeList();
        list.stream().map(Employee->Employee.getName().toUpperCase()).forEach(System.out::println);
    }


    // 中間操作 3.排序
    @Test
    public void test3(){
        List<Employee> list = EmployeeList.getEmployeeList();
        /*
        * Stream不會改變原始對象，所以就算排序操作做完了，他會返回新的Stream，原始對象仍然沒有更動
        *
         */

        //sort
        //姓名排序
        System.out.println("======= stream sort ======= ");
        list.stream().sorted(Comparator.comparing(Employee::getName)).forEach(System.out::println);

        System.out.println();

        //年紀由小到大排序
        System.out.println("======= stream sort 2======= ");
        list.stream().sorted(Comparator.comparingInt(Employee::getAge)).forEach(System.out::println);



        System.out.println();

        //薪資由小到大排序
        System.out.println("======= stream sort 3======= ");
        list.stream().sorted((e1,e2)-> (int) (e1.getSalary()-e2.getSalary())).forEach(System.out::println);
    }


    // 終止操作 1.匹配與查找
    @Test
    public void test4(){
        List<Employee> list = EmployeeList.getEmployeeList();

        //allMatch 元素是否全匹配
        //查詢員工是否年齡都大於30
        System.out.println("===== stream allMatch =====");
        System.out.println(list.stream().allMatch(employee -> employee.getAge() > 30));

        System.out.println();

        //anyMatch 元素是否至少有一個匹配
        //查詢員工薪資是否至少有300000以上
        System.out.println("===== stream anyMatch =====");
        System.out.println(list.stream().anyMatch(employee -> employee.getSalary()>3000000));

        System.out.println();

        //findFirst 返回第一個元素
        System.out.println("===== stream findFirst =====");
        System.out.println(list.stream().findFirst().get());

        System.out.println();

        //count
        //查詢員工薪資大於2000000以上的員工數
        System.out.println("===== stream count =====");
        System.out.println("薪資2000000以上員工數: "+list.stream().filter(employee -> employee.getSalary() > 2000000).count());


        System.out.println();

        //max
        //查詢員工最高薪資
        System.out.println("===== stream max =====");
        System.out.println("最高薪資者: "+list.stream().max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));

        System.out.println();

        //min
        //查詢員工最低薪資
        System.out.println("===== stream min =====");
        System.out.println("最低薪資者: "+list.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));

    }


    // 終止操作 2.歸約
    @Test
    public void test5(){
        List<Employee> list = EmployeeList.getEmployeeList();

        //將所有員工薪資加總
        //System.out.println("員工薪資總和: "+list.stream().map(emp -> emp.getSalary()).reduce((s1,s2)->Double.sum(s1, s2)));
        System.out.println("員工薪資總和: "+list.stream().map(emp -> emp.getSalary()).reduce(Double::sum).get());

    }

    // 終止操作 3.收集
    @Test
    public void test6(){
        List<Employee> list = EmployeeList.getEmployeeList();

        //員工薪資超過1500000的集合
        List<Employee> list1 = list.stream().filter(employee -> employee.getSalary() > 1500000).collect(Collectors.toList());
        list1.forEach(System.out::println);

    }


}
