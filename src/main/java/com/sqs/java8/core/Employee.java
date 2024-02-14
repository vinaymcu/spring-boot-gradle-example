package com.sqs.java8.core;

public class Employee {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    String name;
    int salary;

    Employee(String name,int salary){
        this.name=name;
        this.salary=salary;
    }
}
