package com.company;

import java.util.List;

public class FP1Structured {

    private static void printAllNumbersInListStructured(List<Integer> numbers){

        for (int number: numbers){
            System.out.println(number);
        }

    }

    public static void main(String[] args) {

        printAllNumbersInListStructured(List.of(3,2,3,1,2,3,4,2));



    }
}
