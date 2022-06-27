package com.company;

import java.util.stream.IntStream;

public class FP05Threads {

    public static void main(String[] args) {
        Runnable runnable = () -> {

            /*for (int i = 0; i < 10000; i++) {
                System.out.println(Thread.currentThread().getId() + ":" + i);
            }*/

            IntStream.range(0, 10000).forEach(i ->
                    System.out.println(Thread.currentThread().getId() + ":" + i)
            );

        };

        Thread t1 = new Thread(runnable);

        t1.start();
    }

}
