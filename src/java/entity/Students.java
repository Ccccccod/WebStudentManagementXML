/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MR TU
 */
@XmlRootElement(name = "students")
public class Students {
    private List<Student> students;

    public Students() {
    }

    public Students(List<Student> students) {
        this.students = students;
    }

    @XmlElement(name = "student")
    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return "Students{" + "students=" + students + '}';
    }
    
}
