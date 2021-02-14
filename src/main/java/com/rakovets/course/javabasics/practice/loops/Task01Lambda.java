package com.rakovets.course.javabasics.practice.loops;

import java.util.stream.Stream;

class Task01Lambda {
    public static void main(String[] args) {

        int rows = 10;

        Stream.iterate(1, n -> n + 1)
                    .limit(rows)
                    .forEach(System.out::println);
    }
}
