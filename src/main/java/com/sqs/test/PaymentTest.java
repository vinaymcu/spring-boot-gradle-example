package com.sqs.test;


import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

enum TYPE{
   CARD,
   CASH,
   UPI

}

@Setter
@Getter
class Payment{ double amount = 10;String value;  TYPE type=TYPE.CARD;

    Payment() {
        System.out.println("Parent Constructor");
    }
}
class CashPayment extends Payment{
    double amount = 20;

    TYPE type=TYPE.CARD;
}
class UpiPayment extends Payment{
    double amount = 30;
    TYPE type=TYPE.UPI;
}


public class PaymentTest {
    public static void main(String args[]){
        Payment cashPayment=new CashPayment();
        cashPayment.setAmount(100);
        cashPayment.setValue("aaaa");
        cashPayment.setType(TYPE.CASH);

        Payment upiPayment=new UpiPayment();
        upiPayment.setAmount(500);
        upiPayment.setValue("bbbb");
        upiPayment.setType(TYPE.UPI);
        List<Payment> persons = Arrays.asList( cashPayment,upiPayment);

        Optional<Payment> st= persons.stream().filter(x->"aaaa".
                equals(x.getValue())).findAny();
        System.out.println(" ss:"+st.toString());

        Optional<Payment> st1= persons.stream().filter(x->TYPE.UPI.
                equals(x.getType())).findAny();
        System.out.println(" ss1:"+st1.toString());


        List<Integer> list = Arrays.asList(10,15,8,49,25,98,32);
        list.stream() .filter(n -> n>10 ) .forEach(System.out::println);


    }
}

