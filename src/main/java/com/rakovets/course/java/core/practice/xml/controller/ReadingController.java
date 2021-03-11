package com.rakovets.course.java.core.practice.xml.controller;

import com.rakovets.course.java.core.practice.xml.model.Student;
import com.rakovets.course.java.core.practice.xml.service.ReaderService;
import com.rakovets.course.java.core.practice.xml.view.ReadingView;

import java.nio.file.Paths;
import java.util.List;

public class ReadingController {
    private final static ReaderService read;
    public final static List<Student> readConfig;
    private final static ReadingView FILE_VIEW;

    static {
        read = new ReaderService();
        readConfig = read.readConfig(Paths.get("src", "main", "resources", "reading.xml").toString());
        FILE_VIEW = new ReadingView();
    }

    public void start() {
        FILE_VIEW.readingView();
    }
}
