package com.rakovets.course.java.core.practice.xml.service;

import com.rakovets.course.java.core.practice.xml.model.Student;
import com.rakovets.course.java.core.practice.xml.model.StudentField;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReaderService {
    private static final String STUDENT_ATTRIBUTE_ID = "id";

    public List<Student> readConfig(String configFilepath) {
        List<Student> students = new ArrayList<>();
        try {
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            XMLEventReader eventReader = inputFactory.createXMLEventReader(new FileInputStream(configFilepath));
            Student student = new Student();
            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();
                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();
                    String elementName = startElement.getName().getLocalPart();
                    switch (elementName) {
                        case StudentField.STUDENT:
                            student = new Student();
                            String attributeValueByName = getAttributeValueByName(startElement);
                            if (attributeValueByName != null) {
                                student.setId(attributeValueByName);
                            }
                            break;
                        case StudentField.LAST_NAME:
                            event = eventReader.nextEvent();
                            student.setLastName(event.asCharacters().getData());
                            break;
                        case StudentField.FIRST_NAME:
                            event = eventReader.nextEvent();
                            student.setFirstName(event.asCharacters().getData());
                            break;
                        case StudentField.FEE:
                            event = eventReader.nextEvent();
                            student.setFee(event.asCharacters().getData());
                            break;
                    }
                }
                if (event.isEndElement()) {
                    EndElement endElement = event.asEndElement();
                    if (endElement.getName().getLocalPart().equals(StudentField.STUDENT)) {
                        students.add(student);
                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
        return students;
    }

    private String getAttributeValueByName(StartElement startElement) {
        Iterator<Attribute> attributes = startElement.getAttributes();
        while (attributes.hasNext()) {
            Attribute attribute = attributes.next();
            if (attribute.getName().toString().equals(ReaderService.STUDENT_ATTRIBUTE_ID)) {
                return attribute.getValue();
            }
        }
        return null;
    }
}
