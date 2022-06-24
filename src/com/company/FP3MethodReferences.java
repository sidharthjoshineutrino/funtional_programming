package com.company;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class FP3MethodReferences {

    public static void main(String[] args) {
        List<String> courses = List.of("Spring","Spring Boot","API","Microservices","AWS","PCF","Azure","Docker","Kubernetes");

        courses.stream().map(x -> x.toUpperCase()).forEach(str -> System.out.println(str));

    }
}
