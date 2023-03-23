package com.hugo.pojo;

import java.util.ArrayList;
import java.util.List;

public class EmployeeList {

    public static List<Employee>  getEmployeeList(){
        List<Employee> list = new ArrayList<>();

        list.add(new Employee("E0001","Jay", 30, "總監", 3000000));
        list.add(new Employee("E0002","Jolin", 29, "舞者", 1500000));
        list.add(new Employee("E0003","Rain", 32, "舞者", 2500000));
        list.add(new Employee("E0004","Arin", 28, "歌手", 1000000));
        list.add(new Employee("E0005","Jacky", 33, "歌手", 2000000));
        list.add(new Employee("E0006","Rock", 32, "演員", 1800000));
        list.add(new Employee("E0007","Amei", 30, "歌唱老師", 1700000));
        list.add(new Employee("E0008","JJLin", 27, "金曲歌手", 2300000));
        list.add(new Employee("E0009","Christina", 26, "歌手", 1600000));
        list.add(new Employee("E0010","Hugo", 29, "老闆", 5000000));

        return list;
    }

}
