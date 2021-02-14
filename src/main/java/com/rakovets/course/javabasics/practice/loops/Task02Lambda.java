package com.rakovets.course.javabasics.practice.loops;

import java.util.stream.Stream;

class Task02Lambda {
    public static void main(String[] args) {

        int numberRows = 12;
        boolean isEnableHeaderRow = false;

        if (isEnableHeaderRow) {
            Stream.iterate(1, n -> n + 1)
                    .limit(numberRows)
                    .forEach(n -> System.out.print("\n" + n));
        } else {
            System.out.print("1");
            Stream.iterate(2, n -> n + 1)
                    .limit(numberRows)
                    .forEach(n -> System.out.print("\n" + n));
        }
    }
}

