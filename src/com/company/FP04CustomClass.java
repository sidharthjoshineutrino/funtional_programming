package com.company;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course {
    private String name;
    private String category;
    private int reviewScore;
    private int noOfStudents;

    @Override
    public String toString() {
        return name + ":" + noOfStudents + ":" + reviewScore;
    }

    public Course(String name, String category, int reviewScore, int noOfStudents) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }
}

public class FP04CustomClass {

    public static void main(String[] args) {

        List<String> courses1 = List.of("Spring","Spring Boot","API","Microservices","AWS","PCF","Azure","Docker","Kubernetes");

        List<Course> courses = List.of(
                new Course("Spring", "Framework", 98, 20000),
                new Course("Spring Boot", "Framework", 95, 18000),
                new Course("API", "Microservices", 97, 22000),
                new Course("Microservices", "Microservices", 96, 25000),
                new Course("FullStack", "FullStack", 91, 14000),
                new Course("AWS", "Cloud", 92, 21000),
                new Course("Azure", "Cloud", 99, 21000),
                new Course("Docker", "Cloud", 92, 20000),
                new Course("Kubernetes", "Cloud", 91, 20000));


        //AllMatch -> this is used to check if ALL the contents satisfy the condition provided inside ()
        Predicate<Course> reviewScoreGreaterThan90Predicate = course -> course.getReviewScore() > 90;
        Predicate<Course> reviewScoreGreaterThan95Predicate = course -> course.getReviewScore() > 95;
        Predicate<Course> reviewScoreLessThan90Predicate = course -> course.getReviewScore() < 90;
        System.out.println(
                courses.stream().allMatch(reviewScoreGreaterThan90Predicate));

        //NonMatch -> none should match with the condition provided inside ()
        System.out.println(
                courses.stream().noneMatch(reviewScoreGreaterThan90Predicate));

        //AnyMatch -> checks if even one entry satisfies the condition
        System.out.println(
                courses.stream().anyMatch(reviewScoreGreaterThan90Predicate));

        //sorting
        Comparator<Course> comparingByNoOfStudents = Comparator.comparing(Course::getNoOfStudents);
        System.out.println();
        System.out.println(courses.stream().sorted(comparingByNoOfStudents).collect(Collectors.toList()));

        //with .thenComparing()
        Comparator<Course> comparingByNoOfStudentsAndReviewScore = Comparator.comparing(Course::getNoOfStudents)
                .thenComparing(Course::getReviewScore).reversed();
        System.out.println();
        System.out.println(courses.stream().sorted(comparingByNoOfStudentsAndReviewScore).collect(Collectors.toList()));

        //limit
        System.out.println();
        System.out.println(courses.stream().sorted(comparingByNoOfStudentsAndReviewScore)
                .skip(3).collect(Collectors.toList()));

        //takeWhile is used to compare the object UNTIL the condition is satisfied
        //NOTE : Even if there are some object which won't satisfy the condition. THEY WON'T BE PRINTED
        System.out.println();
        System.out.println("TAKE WHILE-------");
        System.out.println(courses);
        System.out.println();
        System.out.println(courses.stream().takeWhile(course -> course.getReviewScore() >= 95).collect(Collectors.toList()));

        //output
        /*[Framework:20000:98, Framework:18000:95, Microservices:22000:97, Microservices:25000:96, FullStack:14000:91, Cloud:21000:92, Cloud:21000:99, Cloud:20000:92, Cloud:20000:91]

        as the 4th object satisfied the condition the point beyond that was not printed
        [Framework:20000:98, Framework:18000:95, Microservices:22000:97, Microservices:25000:96]*/

        //dropWhile -> to take elements beyond the point where the condition is satisfied
        System.out.println();
        System.out.println("DROP WHILE-------");
        System.out.println(courses);
        System.out.println();
        System.out.println(courses.stream().dropWhile(course -> course.getReviewScore() >= 95).collect(Collectors.toList()));

        //END(max) COURSE
        //max takes the last element after comparing using Comparator
        System.out.println();
        System.out.println("max-------");
        System.out.println(courses.stream().max(comparingByNoOfStudentsAndReviewScore));

        //TOP(min) COURSE
        //max takes the last element after comparing using Comparator
        System.out.println();
        System.out.println("min-------");
        System.out.println(courses.stream().min(comparingByNoOfStudentsAndReviewScore));

        //the optional is for empty check so to handle it we can be .orElse()
        System.out.println();
        System.out.println(courses.stream()
                .filter(reviewScoreLessThan90Predicate)
                .min(comparingByNoOfStudentsAndReviewScore)
                .orElse(new Course("TIMEPASS","TP",100,100))
        );

        //FIND FIRST
        System.out.println();
        System.out.println(courses.stream()
                .filter(reviewScoreGreaterThan90Predicate)
                .findFirst());

        //FIND ANY
        System.out.println();
        System.out.println(courses.stream()
                .filter(reviewScoreGreaterThan90Predicate)
                .findFirst());

        //SUM
        System.out.println();
        System.out.println("SUM------");
        System.out.println(courses.stream()
                .filter(reviewScoreGreaterThan95Predicate)
                .mapToInt(Course::getNoOfStudents)
                .sum());

        //AVG
        System.out.println();
        System.out.println("AVG------");
        System.out.println(courses.stream()
                .filter(reviewScoreGreaterThan95Predicate)
                .mapToInt(Course::getNoOfStudents)
                .average());

        //COUNT
        System.out.println();
        System.out.println("COUNT------");
        System.out.println(courses.stream()
                .filter(reviewScoreGreaterThan95Predicate)
                .mapToInt(Course::getNoOfStudents)
                .count());

        //min
        System.out.println();
        System.out.println("min value------");
        System.out.println(courses.stream()
                .filter(reviewScoreGreaterThan95Predicate)
                .mapToInt(Course::getNoOfStudents)
                .min());

        //GroupingBy -> normal use will create a hashMap
        //get count Collectors.counting()
        System.out.println("groupingBy");
        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory,Collectors.counting())));

        //GroupingBy -> get highest rated one form each category
        System.out.println("groupingBy highest rated");
        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory
                        ,Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))));

        System.out.println();
        System.out.println("groupingBy just get the name of courses");
        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory,
                        Collectors.mapping(Course::getName,Collectors.toList()))));

        //TODO : Higher Order Function -> Function which returns a function

        Predicate<Course> reviewScoreGreaterThan95Predicate2 = createPredicateWithCutoffReviewScore(95);
        Predicate<Course> reviewScoreLessThan90Predicate2 = createPredicateWithCutoffReviewScore(90);

        //peek() -> this function helps us undertsand the flow of stream and what parameters it is going through to
        //perform the operation specified in filter/map
        //for peek to work we need to have terminal function which returns a Stream item.
        //until a terminal function is called the whole stream is in Pipeline.
        Optional<String> first = courses1.stream().filter(course -> course.length() > 11)
                .map(String::toUpperCase).findFirst();
        System.out.println(first.get());

    }

    private static Predicate<Course> createPredicateWithCutoffReviewScore(int cutoffReviewScore) {
        return course -> course.getReviewScore() > cutoffReviewScore;
    }
}
