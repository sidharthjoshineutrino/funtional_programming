package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FP04CollectionTypes {

    public static void main(String[] args) {

        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");

        //joining to join with a delimiter
        String collect = courses.stream().collect(Collectors.joining(","));
        System.out.println(collect);

        //the below map function returns an array of string
        List<String[]> collect1 = courses.stream().map(course -> course.split("")).collect(Collectors.toList());
        System.out.println(collect1);

        //output
        /*[[Ljava.lang.String;@880ec60, [Ljava.lang.String;@3f3afe78, [Ljava.lang.String;@7f63425a, [Ljava.lang.String;@36d64342,
        [Ljava.lang.String;@39ba5a14, [Ljava.lang.String;@511baa65, [Ljava.lang.String;@340f438e, [Ljava.lang.String;@30c7da1e,
        [Ljava.lang.String;@5b464ce8]*/

        //to get the internal array of character in that string we need to use flatMap after map
        List<String> collect2 = courses.stream().map(course -> course.split("")).flatMap(Arrays::stream).collect(Collectors.toList());
        System.out.println(collect2);
        //output
        /*[S, p, r, i, n, g, S, p, r, i, n, g,  , B, o, o, t,  A, P, I,  M, i, c, r, o, s, e, r, v, i, c, e, s,  A, W, S,
        P, C, F,  A, z, u, r, e,  D, o, c, k, e, r,  K, u, b, e, r, n, e, t, e, s]*/


        List<String> courses2 = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");

        //to merge the courses and courses2 and create a tuples of each element in courses with each element in courses2
        courses.stream().flatMap(course -> courses2.stream().map(course2 -> List.of(course, course2))).collect(Collectors.toList());

        //creating a list of tuples who are equal
        courses.stream().flatMap(course -> courses2.stream().map(course2 -> List.of(course, course2)))
                .filter(list -> list.get(0).equals(list.get(1))).collect(Collectors.toList());

        //creating a list excluding the tuples who are equal
        courses.stream().flatMap(course -> courses2.stream().map(course2 -> List.of(course, course2)))
                .filter(list -> !list.get(0).equals(list.get(1))).collect(Collectors.toList());

        //showing only the element whose lengths are equal
        courses.stream().flatMap(course -> courses2.stream().filter(course2 -> course2.length() == course.length())
                .map(course2 -> List.of(course, course2))).filter(list -> !list.get(0).equals(list.get(1))).collect(Collectors.toList());


    }

}
