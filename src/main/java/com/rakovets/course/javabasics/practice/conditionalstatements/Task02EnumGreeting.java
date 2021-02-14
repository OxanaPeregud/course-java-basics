package com.rakovets.course.javabasics.practice.conditionalstatements;

public class Task02EnumGreeting {
    public static void main(String[] args) {

        int hour = 1;

        if (hour >= 0 && hour <= 6)
            System.out.println(Greeting.GOOD_NIGHT.getGreeting());
        else if (hour > 6 && hour <= 12)
            System.out.println(Greeting.GOOD_MORNING.getGreeting());
        else if (hour > 12 && hour <= 18)
            System.out.println(Greeting.GOOD_DAY.getGreeting());
        else if (hour > 18 && hour <= 23)
            System.out.println(Greeting.GOOD_EVENING.getGreeting());
    }
}

