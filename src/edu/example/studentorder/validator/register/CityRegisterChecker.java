package edu.example.studentorder.validator.register;

import edu.example.studentorder.domain.register.CityRegisterResponse;
import edu.example.studentorder.domain.Person;
import edu.example.studentorder.exception.CityRegisterException;
import edu.example.studentorder.exception.TransportException;

/*
я хочу определить некий функциональный набор, контракт
 */
public interface CityRegisterChecker {
    CityRegisterResponse checkPerson(Person person) throws CityRegisterException, TransportException;
}