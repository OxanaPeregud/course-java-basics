package com.rakovets.course.javabasics.practice.conditionalstatements;

import com.rakovets.course.javabasics.util.StandardInputTask;

/**
 * Разработать программу для desktop приложения:
 * которая преобразует номер дня недели в его словесный аналог.
 *
 * @author Dmitry Rakovets
 */
public class Task04 extends StandardInputTask {
    /**
     * The entry point of the task
     *
     * @param args entry arguments
     */
    public static void main(String[] args) {
        //FIXME
        // Ниже приведены значения присваиваемые переменным. Их можно изменять для проверки различных вариантов входных
        // аргументов. Типы данных изменять нельзя
        byte dayOfWeekNumber = 1;

        String nameWeekday = getDayOfWeekNumber(dayOfWeekNumber);
        System.out.printf("Result: %s", nameWeekday);
    }

    /**
     * Возвращает название дня недели, в зависимости от его порядкового номера.
     *
     * @param dayOfWeekNumber номер дня недели
     * @return день недели на английском языке (UPPER CASE)
     */
    static String getDayOfWeekNumber(byte dayOfWeekNumber) {
        //TODO
        // Код, решающий задачу пишем ниже, при этом используя параметры метода

        String nameWeekday = null;
        switch (dayOfWeekNumber) {
            case 1:
                nameWeekday = "MONDAY";
                break;
            case 2:
                nameWeekday = "TUESDAY";
                break;
            case 3:
                nameWeekday = "WEDNESDAY";
                break;
            case 4:
                nameWeekday = "THURSDAY";
                break;
            case 5:
                nameWeekday = "FRIDAY";
                break;
            case 6:
                nameWeekday = "SATURDAY";
                break;
            case 7:
                nameWeekday = "SUNDAY";
                break;
        }
        {
            return nameWeekday;
        }
    }
}

