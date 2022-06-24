package com.company;

import java.util.List;

public class FP1Functional {

    private static void print(int number){
        System.out.println(number);
    }

    private static void printAllNumbersInListFunctional(List<Integer> numbers){

        numbers.stream().forEach(num -> print(num));

    }

    public static void main(String[] args) {

        printAllNumbersInListFunctional(List.of(1,2,3,4,5,6,7,8));

    }
}
