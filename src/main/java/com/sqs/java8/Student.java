package com.sqs.java8;

import lombok.Getter;
import lombok.Setter;



@Setter
@Getter
class Student {
    String name;
    int marks;
    int rank;



    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", marks=" + marks +
                ", rank=" + rank +
                '}';
    }
// public constructor

    public Student(String name, int marks, int rank) {
        super();
        this.name = name;
        this.marks = marks;
        this.rank = rank;
    }

    // override toString() method

}
