package com.rakovets.course.javabasics.practice.conditionalstatements;

public class Task04EnumDay {
    public static void main(String[] args) {

        byte dayOfWeekNumber = 5;

        switch (dayOfWeekNumber) {
            case 1:
                System.out.println(Day.MONDAY);
                break;
            case 2:
                System.out.println(Day.TUESDAY);
                break;
            case 3:
                System.out.println(Day.WEDNESDAY);
            case 4:
                System.out.println(Day.THURSDAY);
                break;
            case 5:
                System.out.println(Day.FRIDAY);
                break;
            case 6:
                System.out.println(Day.SATURDAY);
                break;
            case 7:
                System.out.println(Day.SUNDAY);
                break;
        }
    }
}
