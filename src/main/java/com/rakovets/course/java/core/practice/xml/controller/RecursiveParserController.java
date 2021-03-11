package com.rakovets.course.java.core.practice.xml.controller;

import com.rakovets.course.java.core.practice.xml.view.RecursiveParserView;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;

public class RecursiveParserController {
    private static final DocumentBuilderFactory dbf;
    private final DocumentBuilder db = dbf.newDocumentBuilder();
    private final Document doc = db.parse(new FileInputStream(String.valueOf(Paths.get("src",
            "main", "resources", "reading.xml"))));

    static {
        dbf = DocumentBuilderFactory.newInstance();
    }

    public RecursiveParserController() throws ParserConfigurationException, IOException, SAXException {
    }

    public void start() throws Exception {
        dbf.setValidating(false);
        RecursiveParserView.visitRecursively(doc);
    }
}
