package edu.example.studentorder.domain;

import java.time.LocalDate;

public class Adult extends Person {
    private String passportSeria;
    private String passportNumber;
    private String issueDepartment;
    private LocalDate issueDate;
    private String studentId;
    private Address address;


    public Adult(String name, String surName, String patronymic, LocalDate date) {
        super(name, surName, patronymic, date);
    }

    public String getPassportSeria() {
        return passportSeria;
    }

    public void setPassportSeria(String passportSeria) {
        this.passportSeria = passportSeria;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }


    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

}
