package com.company;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ManageDatabase {

    public static void load(ArrayList<ProjectTeam> projects, ArrayList<Programmers> programmers) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("data.xml");

            //Load projects list of the document
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

            //Load programmer list of the document
            NodeList programmerList = doc.getElementsByTagName("programmer");
            for (int i=0; i<programmerList.getLength(); i++) {
                Node p = programmerList.item(i);
                if(p.getNodeType()==Node.ELEMENT_NODE) {
                    Element program = (Element) p;
                    int id = Integer.parseInt(program.getElementsByTagName("id").item(0).getTextContent());
                    String salary = program.getElementsByTagName("salary").item(0).getTextContent();
                    String firstName = program.getElementsByTagName("firstName").item(0).getTextContent();
                    String lastName = program.getElementsByTagName("lastName").item(0).getTextContent();
                    String project = program.getElementsByTagName("project").item(0).getTextContent();
                    String activity = program.getElementsByTagName("activity").item(0).getTextContent();
                    double wage = Integer.parseInt(program.getElementsByTagName("wage").item(0).getTextContent());
                    LocalDate startDate =  LocalDate.parse(program.getElementsByTagName("startDate").item(0).getTextContent());
                    LocalDate endDate = LocalDate.parse(program.getElementsByTagName("endDate").item(0).getTextContent());
                    int month = Integer.parseInt(program.getElementsByTagName("month").item(0).getTextContent());
                    int otherProjectDays = Integer.parseInt(program.getElementsByTagName("otherProjectDays").item(0).getTextContent());
                    if (project.equals("")) {
                        programmers.add(new ActiveProgrammers(id, firstName, lastName, wage, salary));
                    } else{
                        programmers.add(new ActiveProgrammers(id, firstName, lastName, true, project, activity, startDate, endDate, otherProjectDays, month, wage, salary));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void save(ArrayList<ProjectTeam> projects, ArrayList<Programmers> programmers) {
        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            // root element
            Element root = document.createElement("itCompany");
            document.appendChild(root);

            // write projects on the document
            for (int i=0; i < projects.size(); i++) {
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}