package edu.example.studentorder.domain;

import edu.example.studentorder.domain.Person;

import java.time.LocalDate;

public class Child extends Person {
    private String certificateNumber;

    public Child(String name, String surName, String patronomyc, LocalDate date) {
        super(name, surName, patronomyc, date);
    }

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }
}
