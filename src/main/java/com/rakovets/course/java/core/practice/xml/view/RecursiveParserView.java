package com.rakovets.course.java.core.practice.xml.view;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class RecursiveParserView {

    public static void visitRecursively(Node node) {
        NodeList list = node.getChildNodes();
        for (int i = 0; i < list.getLength(); i++) {
            Node childNode = list.item(i);
            System.out.println("Found Node: " + childNode.getNodeName()
                    + " - with value: " + childNode.getNodeValue());
            visitRecursively(childNode);
        }
    }
}
