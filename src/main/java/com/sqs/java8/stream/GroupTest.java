package com.sqs.java8.stream;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

@Setter
@Getter
class Person{
    int id;
    String name;
    double salary;
    @Setter
    @Getter
    Department department;
    Person(){

    }
    Person(int id, String name, double salary, Department department){
      this.id=id;
      this.name=name;
      this.salary=salary;
      this.department=department;
    }
}
@Setter
@Getter
class Department{

    int id; String name;
    Department(int id, String name){
        this.id=id;
        this.name=name;
    }
}
public class GroupTest {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person(1, "Alex", 100d, new Department(1, "HR")),
                new Person(2, "Brian", 200d, new Department(1, "HR")),
                new Person(3, "Charles", 900d, new Department(2, "Finance")),
                new Person(4, "David", 200d, new Department(2, "Finance")),
                new Person(5, "Edward", 200d, new Department(2, "Finance")),
                new Person(6, "Frank", 800d, new Department(3, "ADMIN")),
                new Person(7, "George", 900d, new Department(3, "ADMIN")));
        Map<Department, List<Person>> map = persons.stream().collect(groupingBy(Person::getDepartment));
        System.out.println(map);
       // map.keySet().stream().forEach(el-> System.out.println(el.id));

        Map<Department, Long> map1
                = persons.stream()
                .collect(groupingBy(Person::getDepartment, counting()));

        map1.keySet().stream().forEach(el-> System.out.println(el.id));
    }
}
