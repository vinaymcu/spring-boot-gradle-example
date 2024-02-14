package com.sqs.java8.stream;

import com.sqs.model.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeTest {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

        getCountOfMaleFemale(employeeList);
        // list of department
        getDepartmentList(employeeList);
        getempageList(employeeList);
        //highest paid employee
        highPaid(employeeList);
        //have joined after 2015
        joinedafter2015(employeeList);
        // no of employee in each dept
        getNoOfEmpinDept(employeeList);
    }

    private static void getNoOfEmpinDept(List<Employee> employeeList) {
        Map<String,Long> noOfEmp=employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
        System.out.println(noOfEmp);
        Map<String,Double> averageSal=employeeList.stream().
                collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(averageSal);

        DoubleSummaryStatistics employeeSalaryStatistics=
                employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("Average Salary = "+employeeSalaryStatistics.getAverage());
        System.out.println("Total Salary = "+employeeSalaryStatistics.getSum());

        Optional<Employee> oldestEmployeeWrapper = employeeList.stream().max(Comparator.comparingInt(Employee::getAge));
        Employee oldestEmployee = oldestEmployeeWrapper.get();
        System.out.println("Name : "+oldestEmployee.getName());
        System.out.println("Age : "+oldestEmployee.getAge());
        System.out.println("Department : "+oldestEmployee.getDepartment());
    }

    static void joinedafter2015(List<Employee> employeeList){
        List<Employee> empList=employeeList.stream().filter(emp->emp.getYearOfJoining()>=2015).collect(Collectors.toList());
        //collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary)));
        System.out.println(empList);
    }
    static void getCountOfMaleFemale(List<Employee> employeeList) {
        Map<String, Long> noOfMaleAndFemaleEmployees=employeeList.stream().collect(Collectors.groupingBy
                                (Employee::getGender, Collectors.counting()));
        //System.out.println(noOfMaleAndFemaleEmployees);
    }
    static void getDepartmentList(List<Employee> employeeList) {
        List<String> getDepartmentList= employeeList.stream().map(Employee::getDepartment).distinct().collect(Collectors.toList());
       // System.out.println(getDepartmentList);
    }
    static void getempageList(List<Employee> employeeList) {
        Map<String, Double> getempageList= employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,
                Collectors.averagingInt(Employee::getAge)));
            //   .map(Employee::getDepartment).distinct().collect(Collectors.toList());
        System.out.println(getempageList);
    }

    static void highPaid(List<Employee> employeeList){
       Optional<Employee> ee=employeeList.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary)));
        System.out.println(ee.get().getName());
    }

}
