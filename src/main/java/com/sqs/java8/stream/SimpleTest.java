package com.sqs.java8.stream;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SimpleTest {
    public static void main(String args[]){
       List<Integer> list= Arrays.asList(3,5,8,1,9,4,3);
       List<Integer> list1= list.stream().distinct().collect(Collectors.toList());
       Integer max=list.stream().max(Comparator.naturalOrder()).get();        System.out.println(" Max :"+max);
        Integer min=list.stream().min(Comparator.naturalOrder()).get();        System.out.println(" min :"+min);
        List<Integer> list2= list.stream().limit(3).collect(Collectors.toList());//first 3         System.out.println(" list2 :"+list2);
        List<Integer> sortedList= list.stream().sorted().collect(Collectors.toList());  //sorted      System.out.println(" sortedList :"+sortedList);
        List<Integer> sortedUniqueList= list.stream().distinct().sorted().collect(Collectors.toList()); //        System.out.println(" sortedUniqueList :"+sortedUniqueList);
        List<Integer> sortedreUniqueList= list.stream().distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList()); //        System.out.println(" sortedreUniqueList :"+sortedreUniqueList);
       //second largest number in an integer array?
        Integer secondLarge=list.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();//        System.out.println(" secondLarge:"+secondLarge);
        Integer sum=list.stream().mapToInt(Integer::intValue).sum();//sum       System.out.println(" SUM:"+sum);
        Double avarage=list.stream().mapToDouble(num->num).average().getAsDouble(); //System.out.println(" avarage:"+avarage);
        List<Integer> reverseList= list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()); System.out.println(" reverseList:"+reverseList);
//        /common elements between two arrays?
        IntStream.rangeClosed(1, 10).map(i -> i * 2).forEach(System.out::println);
        Set<Integer> uniqueElements = new HashSet<>();
        Set<Integer> duplicateElements = list.stream().filter(i -> ! uniqueElements.add(i)).collect(Collectors.toSet());
        System.out.println(duplicateElements);

        List<String> listOfStrings = Arrays.asList("One", "Two", "Three", "Four", "Five", "Six");
        String lastElement = listOfStrings.stream().skip(listOfStrings.size() - 1).findFirst().get();
        System.out.println(lastElement);

        Map<String,Long> countMap=listOfStrings.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(" map :"+countMap);
        test();

    }

    static void test(){
        List<List<String>> list = Arrays.asList(Arrays.asList("a"), Arrays.asList("b"));
        System.out.println(list);
        System.out.println(list.stream().flatMap(Collection::stream).collect(Collectors.toList()));

    }
}
