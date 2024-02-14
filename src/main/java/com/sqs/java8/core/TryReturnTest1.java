package com.sqs.java8.core;

public class TryReturnTest1 {
    public static void main(String args[]){

        try{
            System.out.println(" in try block");
          int c=  10/0;
          return;
        }catch(Exception e){
            System.out.println(" in catch block");
            return;
        }
        finally {
            System.out.println(" in fibnally blck ");
            return ;
        }

    }
}
