package com.hugo.pojo;

import java.util.Objects;

public class Employee {



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", job_position='" + job_position + '\'' +
                ", salary=" + salary +
                '}';
    }

    public String getJob_position() {
        return job_position;
    }

    public void setJob_position(String job_position) {
        this.job_position = job_position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age &&
                Double.compare(employee.salary, salary) == 0 &&
                Objects.equals(id, employee.id) &&
                Objects.equals(name, employee.name) &&
                Objects.equals(job_position, employee.job_position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, job_position, salary);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    private String id;

    public Employee(String id, String name, int age, String job_position, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.job_position = job_position;
        this.salary = salary;
    }

    private String name;

    private int age;

    private String job_position;

    private double salary;

}
