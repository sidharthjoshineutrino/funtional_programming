package com.company;

import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class FP3FunctionalInterfaces {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);


        //Supplier -> NO Input Return Output
        Supplier<Integer> randomIntegerSupplier = () -> 2; // as also perform operation in {}
        System.out.println();
        System.out.println("Supplier");
        System.out.println(randomIntegerSupplier);

        //Unary Operator works with 1 parameter
        UnaryOperator<Integer> unaryOperator = (x) -> x*3;
        System.out.println();
        System.out.println("UnaryOperator");
        System.out.println(unaryOperator.apply(2));


        //BiPredicate -> it takes 2 parameter to check a condition and returns a BOOLEAN
        BiPredicate<Integer,String> biPredicate = (number,str) ->{
          return number>5 && str.length()>=5;
        };
        System.out.println();
        System.out.println("BiPredicate");
        System.out.println(biPredicate.test(10,"sidharth"));

        //BiFunction -> uses 2 params and return AnyType
        BiFunction<Integer,String,String> biFunction = (number,str) ->{
            if(number>5 && str.length()>=5){
                return number +" "+str;
            }else{
                return "false";
            }

        };
        System.out.println();
        System.out.println("BiFunction");
        System.out.println(biFunction.apply(10,"sidharth"));

        //BiConsumer takes in 2 input and can perform operations on them
        BiConsumer<String,String> biConsumer = (str1,str2) ->{
            System.out.println(str1);
            System.out.println(str2);
        };
        System.out.println();
        System.out.println("BiConsumer");
        biConsumer.accept("soham","sidharth");
        

    }




}
