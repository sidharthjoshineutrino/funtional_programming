package com.company;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FP2FilterCourses {

    private static List<String> courses = List.of("Spring","Spring Boot","API","Microservices","AWS","PCF","Azure","Docker","Kubernetes");
    private static List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);

    public static void main(String[] args) {


        //Task 3
        courses.stream().filter(course -> course.contains("Spring")).forEach(System.out::println);

        System.out.println();

        //Task 4
        courses.stream().filter(course -> course.length() >= 4).forEach(System.out::println);
        System.out.println();
        System.out.println("natural sorted" );

        courses.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);

        //
        System.out.println();
        System.out.println("natural sorted" );

        courses.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);

        System.out.println(listOfEvenNumber());
        System.out.println(lengthOfCourseTitles());

    }

    private static List<Integer> listOfEvenNumber(){

        return numbers.stream().filter(num -> (num%2==0)).collect(Collectors.toList());
    }

    private static List<Integer> lengthOfCourseTitles(){

        return courses.stream().map(str -> str.length()).collect(Collectors.toList());
    }
}
