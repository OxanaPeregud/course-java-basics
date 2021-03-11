package com.rakovets.course.java.core.practice.xml.controller;

import com.rakovets.course.java.core.practice.xml.service.WriterService;

import java.nio.file.Paths;

public class WritingController {
    private final static WriterService configFile;

    static {
        configFile = new WriterService();
    }

    public void start() {
        configFile.saveConfig(Paths.get(Paths.get("src", "main", "resources", "writing.xml").toString()));
    }
}
