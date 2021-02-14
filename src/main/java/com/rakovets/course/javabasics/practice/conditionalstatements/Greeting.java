package com.rakovets.course.javabasics.practice.conditionalstatements;

enum Greeting {
    GOOD_NIGHT("Good night"),
    GOOD_MORNING("Good morning"),
    GOOD_DAY("Good day"),
    GOOD_EVENING("Good evening");
    private final String greeting;

    Greeting(String greeting) {
        this.greeting = greeting;
    }

    public String getGreeting() {
        return greeting;
    }
}
