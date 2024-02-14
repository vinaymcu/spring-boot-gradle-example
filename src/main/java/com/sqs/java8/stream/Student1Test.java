package com.sqs.java8.stream;

import com.sqs.model.Student1;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Student1Test {
    public static void main(String arg[]){
        List<Student1> studentList = Arrays.asList(
                new Student1("Vijay", 101, "science",55),
                new Student1("Ajith", 100, "math",89),
                new Student1("Surya", 64, "eng",88),
                new Student1("Arya", 83,"phy", 20),
                new Student1("Siva", 55,"sst", 50)
        );
        Map<Boolean, List<Student1>> studentspartionedByPercentage = studentList.stream().collect(Collectors.partitioningBy(student -> student.getPercentage() > 60.0));
        System.out.println(studentspartionedByPercentage.values());
    }
}
