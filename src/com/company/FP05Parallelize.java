package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class FP05Parallelize {
    public static void main(String[] args) {

        //parallel() is used to divide those streams in multiple parts and then once the operation is over
        //at terminal function all the parts are combined
        List<String> courses = List.of("Spring","Spring Boot","API","Microservices","AWS","PCF","Azure","Docker","Kubernetes");

        List<String> modifyAble= new ArrayList<String>(courses);
        modifyAble.replaceAll(String::toUpperCase);
        System.out.println(modifyAble);

        modifyAble.removeIf(str -> str.length()<4);
        System.out.println(modifyAble);

    }
}
