package com.sqs.java8.core;

import java.util.*;
import java.util.stream.Collectors;

public class Test1 {
    public static void main(String args[]){

        Map<String,Integer> map2 = new HashMap<>();
        map2.put("anil",1000);
        map2.put("ankit",1200);
        map2.put("bhavna",1200);
        map2.put("james",1200);
        map2.put("micael",1000);
        map2.put("tom",1300);
        map2.put("daniel",1300);

        List<Employee> empList2 = Arrays.asList(
                new Employee( "Sagar", 4400),
                new Employee("Manish", 5000 ),
                new Employee("Atul", 3000),
                new Employee( "Santosh", 4400),
                new Employee( "Rupendra", 3200),
                new Employee( "Priyanka", 4400)
        );
int nth=2;
        //List<Employee> empLis3=
        Map.Entry<Integer, List<String>> mm=
        empList2.stream()
                .collect(Collectors.groupingBy(Employee::getSalary, Collectors.mapping(Employee::getName, Collectors.toList())
                ))
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .collect(Collectors.toList())
                .get(nth - 1);


        // using values() for iteration over values
        for (String url : mm.getValue())
            System.out.println("value: " + url);

        System.out.println(" mmmmmmmmmm");

    }
}
