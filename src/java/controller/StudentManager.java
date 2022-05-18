/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Student;
import entity.Students;
import java.io.File;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author MR TU
 */
public class StudentManager {
    
    private final static File FILE = new File("students.xml");
    private final static JAXBContext CONTEXT;

    static {
        JAXBContext tmp = null;
        try {
            tmp = JAXBContext.newInstance(Students.class);
        } catch (JAXBException ex) {
            Logger.getLogger(StudentManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        CONTEXT = tmp;
    }

    public StudentManager(){
        if (Objects.isNull(CONTEXT)) {
            throw new RuntimeException();
        }
    }
    
    private List<Student> readFromXML() throws JAXBException {
        Unmarshaller unmarshaller = CONTEXT.createUnmarshaller();
        return ((Students) unmarshaller.unmarshal(FILE)).getStudents();
    }

    private void writeToXML(List<Student> students) throws JAXBException {
        Marshaller marshaller = CONTEXT.createMarshaller();
        marshaller.marshal(new Students(students), FILE);
    }

    public boolean add(Student student) throws JAXBException {
        List<Student> students = readFromXML();
        boolean result = students.add(student);
        writeToXML(students);
        return result;
    }

    public void update(Student student) throws JAXBException {
        List<Student> students = readFromXML();
        students = students.stream()
                .map(s -> s.getId().equals(student.getId())? student : s)
                .collect(Collectors.toList());
        writeToXML(students);
    }

    public boolean delete(String id) throws JAXBException {
        List<Student> students = readFromXML();
        boolean result = students.removeIf(e -> e.getId().equals(id));
        writeToXML(students);
        return result;
    }
    
    public List<Student> show() throws JAXBException {
        List<Student> students = readFromXML();
        return students;
    }

    public List<Student> search(Student student) throws JAXBException {
        List<Student> students = readFromXML();
        return students.stream()
                .filter(e -> e.getId().contains(student.getId()))
                .filter(e -> e.getName().contains(student.getName()))
                .filter(e -> e.getDob().contains(student.getDob()))
                .filter(e -> e.getAddress().contains(student.getAddress()))
                .filter(e -> e.getEmail().contains(student.getEmail()))
                .filter(e -> e.getPhone().contains(student.getPhone()))
                .collect(Collectors.toList());
    }
}
