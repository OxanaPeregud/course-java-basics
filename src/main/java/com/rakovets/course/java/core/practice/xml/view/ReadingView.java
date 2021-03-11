package com.rakovets.course.java.core.practice.xml.view;

import com.rakovets.course.java.core.practice.xml.controller.ReadingController;
import com.rakovets.course.java.core.practice.xml.model.Student;

public class ReadingView {

    public void readingView() {
        for (Student student : ReadingController.readConfig) {
            System.out.println(student);
        }
    }
}
