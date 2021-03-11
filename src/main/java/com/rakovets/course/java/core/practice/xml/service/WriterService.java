package com.rakovets.course.java.core.practice.xml.service;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;

import static com.rakovets.course.java.core.practice.xml.model.StudentField.*;

public class WriterService {
    private final static String EMPTY_PREFIX = "";
    private final static String EMPTY_NAMESPACE_URI = "";

    private final XMLEventFactory eventFactory = XMLEventFactory.newInstance();
    private final XMLEvent lfEvent = eventFactory.createDTD("\n");
    private final XMLEvent tab = eventFactory.createDTD("\t");

    public void saveConfig(Path configFilepath) {
        XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
        try (OutputStream outputStream = new FileOutputStream(String.valueOf(configFilepath))) {
            XMLEventWriter eventWriter = outputFactory.createXMLEventWriter(outputStream);
            eventWriter.add(eventFactory.createStartDocument());
            eventWriter.add(lfEvent);
            eventWriter.add(eventFactory.createStartElement(EMPTY_PREFIX, EMPTY_NAMESPACE_URI, STUDENT));
            eventWriter.add(lfEvent);
            createNode(eventWriter, LAST_NAME, "Smith");
            createNode(eventWriter, FIRST_NAME, "John");
            createNode(eventWriter, FEE, "100");
            eventWriter.add(eventFactory.createEndElement(EMPTY_PREFIX, EMPTY_NAMESPACE_URI, GROUP));
            eventWriter.add(lfEvent);
            eventWriter.add(eventFactory.createEndDocument());
            eventWriter.close();
        } catch (IOException | XMLStreamException e) {
            e.printStackTrace();
        }
    }

    private void createNode(XMLEventWriter eventWriter, String name, String value) throws XMLStreamException {
        StartElement sElement = eventFactory.createStartElement(EMPTY_PREFIX, EMPTY_NAMESPACE_URI, name);
        eventWriter.add(tab);
        eventWriter.add(sElement);
        Characters characters = eventFactory.createCharacters(value);
        eventWriter.add(characters);
        EndElement eElement = eventFactory.createEndElement(EMPTY_PREFIX, EMPTY_NAMESPACE_URI, name);
        eventWriter.add(eElement);
        eventWriter.add(lfEvent);
    }
}
