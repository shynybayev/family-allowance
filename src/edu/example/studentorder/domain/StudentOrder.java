package edu.example.studentorder.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
студенческая заявка
*/
public class StudentOrder {
    private long studentOrderId;
    private Adult husband;
    private Adult wife;
    private List<Child> children;
    private String marriageCertificateId;
    private String marriageOffice;
    private LocalDate marriageDate;

    public StudentOrder(){}

    public StudentOrder(long id) {
        this.studentOrderId = id;
    }

    public long getStudentOrderId() {
        return this.studentOrderId;
    }

    public void setStudentOrderId(long id) {
        this.studentOrderId = id;
    }

    public String getMarriageCertificateId() {
        return this.marriageCertificateId;
    }

    public void setMarriageCertificateId(String marriageCertificateId) {
        this.marriageCertificateId = marriageCertificateId;
    }

    public LocalDate getMarriageDate() {
        return this.marriageDate;
    }

    public void setMarriageDate(LocalDate date) {
        this.marriageDate = date;
    }

    public String getMarriageOffice() {
        return marriageOffice;
    }

    public void setMarriageOffice(String marriageOffice) {
        this.marriageOffice = marriageOffice;
    }

    public Person getHusband() {
        return this.husband;
    }

    public void setHusband(Adult husband) {
        this.husband = husband;
    }

    public Person getWife() {
        return this.wife;
    }

    public void setWife(Adult wife) {
        this.wife = wife;
    }

    public List<Child> getChildren() {
        return this.children;
    }

    public void addChild(Child child) {
        if (children == null){
            children = new ArrayList<>(5);
        }
        children.add(child);
    }

}
