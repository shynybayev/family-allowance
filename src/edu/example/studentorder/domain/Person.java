package edu.example.studentorder.domain;

import java.time.LocalDate;

public abstract class Person {
    private LocalDate date;
    private String name;
    private String surName;
    private String patronomyc;
    private LocalDate issueDate;
    private String issueDepartment;
    private Address address;

    public Person(String name, String surName, String patronomyc, LocalDate date) {
        this.name = name;
        this.surName = surName;
        this.patronomyc = patronomyc;
        this.date = date;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getPatronomyc() {
        return patronomyc;
    }

    public void setPatronomyc(String patronomyc) {
        this.patronomyc = patronomyc;
    }

    public String getIssueDepartment() {
        return issueDepartment;
    }

    public void setIssueDepartment(String issueDepartment) {
        this.issueDepartment = issueDepartment;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
