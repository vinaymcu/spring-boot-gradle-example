package com.sqs.java8;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class StudentTest {
    public static void main(String[] args) throws FileNotFoundException {
           List<Student> studentList = Arrays.asList(                new Student("Vijay", 97, 1),
                new Student("Ajith", 71, 3),                new Student("Surya", 64, 4),
                new Student("Arya", 83, 2),                new Student("Siva", 55, 5)
        );
         List<Student> studentList1 =studentList.stream().sorted(Comparator.comparing(s -> s.name)).collect(Collectors.toList());
        studentList1.forEach(System.out::println);

        String name = studentList.stream().filter(x -> "Vijay".equals(x.getName())).map(Student::getName)                        //convert stream to String
                .findAny()
                .orElse("");
      //  System.out.println(" name :"+name);

    }

}
