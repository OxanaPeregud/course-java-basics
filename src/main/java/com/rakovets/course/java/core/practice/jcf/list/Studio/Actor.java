package com.rakovets.course.java.core.practice.jcf.list.Studio;

public class Actor {
    private final String firstName;
    private final String lastName;
    private final double fee;
    private final int age;

    public Actor(String firstName, String lastName, double fee, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fee = fee;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getFee() {
        return fee;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Actor {" +
                "firstName = '" + firstName + '\'' +
                ", lastName = '" + lastName + '\'' +
                ", fee = " + fee +
                ", age = " + age +
                '}';
    }
}
