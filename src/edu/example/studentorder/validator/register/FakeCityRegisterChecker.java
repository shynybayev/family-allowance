package edu.example.studentorder.validator.register;
import edu.example.studentorder.domain.Adult;
import edu.example.studentorder.domain.Child;
import edu.example.studentorder.domain.register.CityRegisterResponse;
import edu.example.studentorder.domain.Person;
import edu.example.studentorder.exception.CityRegisterException;
import edu.example.studentorder.exception.TransportException;

/*
класс заглушка
фейковый тренривочный чекер
 */
public class FakeCityRegisterChecker implements CityRegisterChecker{
    private final static String ID_1 = "1000";
    private final static String ID_2 = "2000";
    private final static String ID_3 = "1001";
    private final static String ID_4 = "2001";
    private final static String ERROR_1 = "1002";
    private final static String ERROR_2 = "2002";
    private final static String ERROR_T_1 = "1003";
    private final static String ERROR_T_2 = "2003";

    @Override
    public CityRegisterResponse checkPerson(Person person)
            throws CityRegisterException, TransportException { //Передаем персону
        CityRegisterResponse res = new CityRegisterResponse();

        if (person instanceof Adult){
            Adult adult = (Adult) person;
            if (adult.getPassportSeria().equals(ID_1) || adult.getPassportSeria().equals(ID_2)){
                res.setExisting(true); //существует
                res.setTemp(false);
            } else if (adult.getPassportSeria().equals(ID_3) || adult.getPassportSeria().equals(ID_4)){
                res.setExisting(false); //существует
            } else if (adult.getPassportSeria().equals(ERROR_1) || adult.getPassportSeria().equals(ERROR_2)){
                throw new CityRegisterException("", "ERROR" + adult.getPassportSeria());
            } else if (adult.getPassportSeria().equals(ERROR_T_1) || adult.getPassportSeria().equals(ERROR_T_2)){
                throw new TransportException("Transport ERROR" + adult.getPassportSeria());
            }
        } else if (person instanceof Child){
            res.setExisting(true); //существует
            res.setTemp(true);
        }
        System.out.println(res.toString());

        return res;
    }
}
