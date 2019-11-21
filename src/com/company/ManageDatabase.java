package com.company;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ManageDatabase {

    public static void load(ArrayList<ProjectTeam> projects, ArrayList<Programmers> programmers) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("data.xml");
            NodeList projectList = doc.getElementsByTagName("project");
            for (int i=0; i<projectList.getLength(); i++) {
                Node p = projectList.item(i);
                if(p.getNodeType()==Node.ELEMENT_NODE) {
                    Element project = (Element) p;
                    int id = Integer.parseInt(project.getElementsByTagName("id").item(0).getTextContent());
                    String name = project.getElementsByTagName("name").item(0).getTextContent();
                    LocalDate startDate =  LocalDate.parse(project.getElementsByTagName("startDate").item(0).getTextContent());
                    LocalDate endDate = LocalDate.parse(project.getElementsByTagName("endDate").item(0).getTextContent());
                    projects.add(new ProjectTeam(id, name, startDate, endDate));
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}