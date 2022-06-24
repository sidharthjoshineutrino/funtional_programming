package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FP04TypeOfCreatingStreams {

    public static void main(String[] args) {

        List<Integer> numList = List.of(12,9,13,4,6,2,4,12,15);

        //type 1
        System.out.println(numList.stream());//this gives a wrapper class hence they are of ReferencePipeline

        //type 2
        //Calling Streams which will create a wrapClass Type of the elements mentioned inside
        System.out.println(Stream.of(12,9,13,4,6,2,4,12,15)); //this gives a wrapper class hence they are of ReferencePipeline

        //type 3 creating an array and converting it into a stream
        int[] numArry = {12,9,13,4,6,2,4,12,15};

        System.out.println(Arrays.stream(numArry));//this gives a primitive class hence they are of IntPipeline(int is
        //mentioned while defining the array )

        System.out.println(Arrays.stream(numArry).min());
        //Hence we can use sum,min,max,average etc all the methods which come under primitive type

        //primitive type Streams
        IntStream.range(1,10);

        //Conditioned Stream
        int sum = IntStream.iterate(1, x -> x + 2).limit(10).peek(System.out::println).sum();
        System.out.println(sum);

        //To collect a primitive stream we need to use boxed() first and then collect()
        //what boxed does is it encloses it with a wrapper in our case int -> Integer
        List<Integer> collect = IntStream.iterate(1, x -> x + 2).limit(10).boxed().collect(Collectors.toList());
        System.out.println(collect);

    }
}
