package com.company;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP3BehaviourParameterization {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);

        //In a Predicate Param we can pass a lambda as well
        //filterAndPrint(numbers, x -> x%2==0);
        //filterAndPrint(numbers,x -> x%2!=0);


        List<Integer> squaredNumbers = getSquaredNumbers(numbers,x -> x * x);
        System.out.println(squaredNumbers);



    }

    private static List<Integer> getSquaredNumbers(List<Integer> numbers,Function<Integer,Integer> squared) {
        return numbers.stream().map(squared).collect(Collectors.toList());
    }


    private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> integerPredicate) {
        numbers.stream().filter(integerPredicate).forEach(System.out::println);
    }


}
