package com.company;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

public class ManageDatabase {

    static LocalDate loadDate() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("data.xml");

            // Load data
            LocalDate date = LocalDate.now();
            NodeList dateList = doc.getElementsByTagName("itCompany");
            for (int i = 0; i < dateList.getLength(); i++) {
                Node p = dateList.item(i);
                if (p.getNodeType() == Node.ELEMENT_NODE) {
                    Element fileDate = (Element) p;
                    date = LocalDate.parse(fileDate.getElementsByTagName("date").item(0).getTextContent());
                }
            }
            return date;

        } catch (Exception e) {
            return LocalDate.now().minusDays(1);
        }
    }

    static void load(ArrayList<ProjectTeam> projects, ArrayList<ActiveProgrammers> programmers) {
        projects.clear();
        programmers.clear();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("data.xml");

            //Load projects list of the document
            NodeList projectList = doc.getElementsByTagName("project");
            for (int i = 0; i < projectList.getLength(); i++) {
                Node p = projectList.item(i);
                if (p.getNodeType() == Node.ELEMENT_NODE) {
                    Element project = (Element) p;
                    int id = Integer.parseInt(project.getElementsByTagName("id").item(0).getTextContent());
                    String name = project.getElementsByTagName("name").item(0).getTextContent();
                    LocalDate startDate = LocalDate.parse(project.getElementsByTagName("startDate").item(0).getTextContent());
                    LocalDate endDate = LocalDate.parse(project.getElementsByTagName("endDate").item(0).getTextContent());
                    projects.add(new ProjectTeam(id, name, startDate, endDate));
                }
            }

            //Load programmer list of the document
            NodeList programmerList = doc.getElementsByTagName("programmer");
            for (int i = 0; i < programmerList.getLength(); i++) {
                Node p = programmerList.item(i);
                if (p.getNodeType() == Node.ELEMENT_NODE) {
                    Element program = (Element) p;
                    int id = Integer.parseInt(program.getElementsByTagName("id").item(0).getTextContent());
                    String salary = program.getElementsByTagName("salary").item(0).getTextContent();
                    String firstName = program.getElementsByTagName("firstName").item(0).getTextContent();
                    String lastName = program.getElementsByTagName("lastName").item(0).getTextContent();
                    String project = program.getElementsByTagName("projectName").item(0).getTextContent();
                    String activity = program.getElementsByTagName("activity").item(0).getTextContent();
                    double wage = Double.parseDouble(program.getElementsByTagName("wage").item(0).getTextContent());
                    LocalDate startDate = LocalDate.parse(program.getElementsByTagName("startDate").item(0).getTextContent());
                    LocalDate endDate = LocalDate.parse(program.getElementsByTagName("endDate").item(0).getTextContent());
                    int month = Integer.parseInt(program.getElementsByTagName("month").item(0).getTextContent());
                    int otherProjectDays = Integer.parseInt(program.getElementsByTagName("otherProjectDays").item(0).getTextContent());
                    if (project.equals("")) {
                        programmers.add(new ActiveProgrammers(id, firstName, lastName, wage, salary));
                    } else {
                        programmers.add(new ActiveProgrammers(id, firstName, lastName, true, project, activity, startDate, endDate, otherProjectDays, month, wage, salary));
                    }
                }
            }
        } catch (Exception e) {
            if (e.getMessage() != null && e.getMessage().contains("The system cannot find the file specified")) {
                newFile(projects, programmers);
            } else {
                System.out.println(e.getMessage());
            }
        }
    }

    static void save(ArrayList<ProjectTeam> projects, ArrayList<ActiveProgrammers> programmers, LocalDate date) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("data.xml");

            NodeList dateList = doc.getElementsByTagName("date");
            //Delete date from document
            for (int i = 0; i < dateList.getLength(); i++) {
                Node eachNode = dateList.item(i);
                eachNode.getParentNode().removeChild(eachNode);
                i--;
            }

            // date element
            NodeList root = doc.getElementsByTagName("itCompany");
            Element fileDate = doc.createElement("date");
            fileDate.appendChild(doc.createTextNode(date.toString()));
            root.item(0).appendChild(fileDate);

            NodeList projectList = doc.getElementsByTagName("project");
            //Delete projects from document
            for (int i = 0; i < projectList.getLength(); i++) {
                Node eachNode = projectList.item(i);
                eachNode.getParentNode().removeChild(eachNode);
                i--;
            }

            //Add projects from List to document
            for (ProjectTeam project : projects) {
                String id = String.valueOf(project.getId());
                String name = project.getName();
                String startDate = project.getStartDate().toString();
                String endDate = project.getEndDate().toString();

                // project element
                NodeList projectsGroup = doc.getElementsByTagName("projects");
                Element proj = doc.createElement("project");
                projectsGroup.item(0).appendChild(proj);

                // id element
                Element pId = doc.createElement("id");
                pId.appendChild(doc.createTextNode(id));
                proj.appendChild(pId);

                // name element
                Element pName = doc.createElement("name");
                pName.appendChild(doc.createTextNode(name));
                proj.appendChild(pName);

                // startDate element
                Element pStart = doc.createElement("startDate");
                pStart.appendChild(doc.createTextNode(startDate));
                proj.appendChild(pStart);

                // endDate element
                Element pEnd = doc.createElement("endDate");
                pEnd.appendChild(doc.createTextNode(endDate));
                proj.appendChild(pEnd);
            }

            NodeList programmerList = doc.getElementsByTagName("programmer");
            //Delete programmers from document
            for (int i = 0; i < programmerList.getLength(); i++) {
                Node eachNode = programmerList.item(i);
                eachNode.getParentNode().removeChild(eachNode);
                i--;
            }

            //Add programmers from List to document
            for (ActiveProgrammers programmer : programmers) {
                String id = String.valueOf(programmer.getId());
                String firstName = programmer.getFirstName();
                String lastName = programmer.getLastName();
                String project = programmer.getProject();
                String activity = programmer.getActivity();
                String salary = programmer.getSalary();
                String wage = Double.toString(programmer.getWage());
                String startDate = programmer.getStartDate().toString();
                String endDate = programmer.getEndDate().toString();
                String month = Integer.toString(programmer.getMonth());
                String otherProjectDays = Integer.toString(programmer.getWorkedDays());

                // programmer element
                NodeList programmersGroup = doc.getElementsByTagName("programmers");
                Element prog = doc.createElement("programmer");
                programmersGroup.item(0).appendChild(prog);

                // id element
                Element pId = doc.createElement("id");
                pId.appendChild(doc.createTextNode(id));
                prog.appendChild(pId);

                // firstName element
                Element pFirstName = doc.createElement("firstName");
                pFirstName.appendChild(doc.createTextNode(firstName));
                prog.appendChild(pFirstName);

                // lastName element
                Element pLastName = doc.createElement("lastName");
                pLastName.appendChild(doc.createTextNode(lastName));
                prog.appendChild(pLastName);

                // project element
                Element pProject = doc.createElement("projectName");
                pProject.appendChild(doc.createTextNode(project));
                prog.appendChild(pProject);

                // activity element
                Element pActivity = doc.createElement("activity");
                pActivity.appendChild(doc.createTextNode(activity));
                prog.appendChild(pActivity);

                // salary element
                Element pSalary = doc.createElement("salary");
                pSalary.appendChild(doc.createTextNode(salary));
                prog.appendChild(pSalary);

                // wage element
                Element pWage = doc.createElement("wage");
                pWage.appendChild(doc.createTextNode(wage));
                prog.appendChild(pWage);

                // startDate element
                Element pStart = doc.createElement("startDate");
                pStart.appendChild(doc.createTextNode(startDate));
                prog.appendChild(pStart);

                // endDate element
                Element pEnd = doc.createElement("endDate");
                pEnd.appendChild(doc.createTextNode(endDate));
                prog.appendChild(pEnd);

                // month element
                Element pMonth = doc.createElement("month");
                pMonth.appendChild(doc.createTextNode(month));
                prog.appendChild(pMonth);

                // otherProjectDays element
                Element pOtherProjDays = doc.createElement("otherProjectDays");
                pOtherProjDays.appendChild(doc.createTextNode(otherProjectDays));
                prog.appendChild(pOtherProjDays);
            }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("data.xml"));
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(source, result);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void newFile(ArrayList<ProjectTeam> projects, ArrayList<ActiveProgrammers> programmers) {
        // date
        LocalDate date = LocalDate.now().minusDays(1);

        // create project objects to add
        ProjectTeam proj1 = new ProjectTeam(1, "Java SE", LocalDate.parse("2019-10-01"), LocalDate.parse("2019-11-30"));
        ProjectTeam proj2 = new ProjectTeam(2, "Angular", LocalDate.parse("2019-09-01"), LocalDate.parse("2019-12-31"));

        // create programmer objects to add
        ActiveProgrammers prog1 = new ActiveProgrammers(1, "Joaquim", "Marmita", true, "Java SE", "backend", LocalDate.parse("2019-10-01"), LocalDate.parse("2019-12-10"), 0, LocalDate.now().getMonthValue(), 45.00, "full");
        ActiveProgrammers prog2 = new ActiveProgrammers(2, "Maria", "Artista", true, "Java SE", "design", LocalDate.parse("2019-10-01"), LocalDate.parse("2019-11-30"), 0, LocalDate.now().getMonthValue(), 45.00, "half");
        ActiveProgrammers prog3 = new ActiveProgrammers(3, "Manuel", "Geleira", true, "Angular", "frontend", LocalDate.parse("2019-10-01"), LocalDate.parse("2019-12-11"), 0, LocalDate.now().getMonthValue(), 45.00, "full");
        ActiveProgrammers prog4 = new ActiveProgrammers(4, "Joana", "Dar't", true, "Angular", "design", LocalDate.parse("2019-10-01"), LocalDate.parse("2019-11-30"), 0, LocalDate.now().getMonthValue(), 45.00, "half");

        // add objects to projects arraylist
        projects.add(proj1);
        projects.add(proj2);

        // add objects to programmers arraylist
        programmers.add(prog1);
        programmers.add(prog2);
        programmers.add(prog3);
        programmers.add(prog4);

        // create file
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            Element root = doc.createElement("itCompany");
            doc.appendChild(root);
            Element proj = doc.createElement("projects");
            root.appendChild(proj);
            Element prog = doc.createElement("programmers");
            root.appendChild(prog);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("data.xml"));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        // save info to the file
        save(projects,programmers, date);
    }


}