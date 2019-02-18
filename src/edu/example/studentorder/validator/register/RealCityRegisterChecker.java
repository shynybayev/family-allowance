package edu.example.studentorder.validator.register;

import edu.example.studentorder.domain.register.CityRegisterResponse;
import edu.example.studentorder.domain.Person;
import edu.example.studentorder.exception.CityRegisterException;
import edu.example.studentorder.exception.TransportException;

/*
иметь один метол, возвращает Checkeresponse
 */
public class RealCityRegisterChecker implements CityRegisterChecker {
    @Override
    public CityRegisterResponse checkPerson(Person person) throws CityRegisterException, TransportException { // провряет персону
        return null;
    }
}
