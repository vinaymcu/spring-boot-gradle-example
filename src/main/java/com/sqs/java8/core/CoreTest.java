package com.sqs.java8.core;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CoreTest {
    public static void main(String args[]){

        List<Integer> integerList = Arrays.asList(10, 20, 5, 15, 30, 25, 20);
        int n = 3; // Change n to get the nth highest elements

        Integer highestElement = findNthHighestElement(integerList, n);
        System.out.println("The " + n + " highest element is: " + highestElement);

       // List<Integer> allHighestElements = findAllNthHighestElements(integerList, n);
        //System.out.println("The " + n + " highest elements are: " + allHighestElements);

    }
    public static Integer findNthHighestElement(List<Integer> integerList, int n) {

        if (integerList.isEmpty() || n <= 0 || integerList.size() < n)
            throw new IllegalArgumentException("Please validate your inputs.");

        return integerList.stream()
                .distinct()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList()).get(n - 1);
    }

    public static List<Integer> findAllNthHighestElements(List<Integer> integerList, int n) {

        if (integerList.isEmpty() || n <= 0 || integerList.size() < n)
            throw new IllegalArgumentException("Please validate your inputs.");

        Integer highestElement = integerList.stream()
                .distinct()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList()).get(n - 1);

        return integerList.stream()
                .filter(e -> e == highestElement)
                .collect(Collectors.toList());
    }

}
