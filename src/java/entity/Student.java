/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author MR TU
 */
public class Student {
    private String id;
    private String name;
    private String dob;
    private String address;
    private String email;
    private String phone;

    public Student() {
    }

    public Student(String id, String name, String dob, String address, String email, String phone) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    @XmlAttribute(name = "id")
    public void setId(String id) {
        this.id = id;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "dob")
    public void setDob(String dob) {
        this.dob = dob;
    }

    @XmlElement
    public void setAddress(String address) {
        this.address = address;
    }

    @XmlElement
    public void setEmail(String email) {
        this.email = email;
    }

    @XmlElement
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", dob=" + dob + ", address=" + address + ", email=" + email + ", phone=" + phone + '}';
    }
    
}
