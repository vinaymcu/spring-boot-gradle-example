package com.sqs.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Student1 {
    String name;
    int id;
    String subject;
    double percentage;
    public Student1(String name, int id, String subject, double percentage)
    {
        this.name = name;
        this.id = id;
        this.subject = subject;
        this.percentage = percentage;
    }

}
