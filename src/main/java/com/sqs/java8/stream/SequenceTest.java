package com.sqs.java8.stream;

import java.util.Arrays;
import java.util.List;

public class SequenceTest {
    public static void main(String[] args){
        List<String> list = Arrays.asList("Hello ","G", "E", "E", "K", "S!");
        // using parallelStream() method for parallel stream
//        list.parallelStream().forEachOrdered(System.out::print);

        //List<String> list = Arrays.asList("Hello ", "G", "E", "E", "K", "S!");
        list.parallelStream().forEach(System.out::print);
    }
}
