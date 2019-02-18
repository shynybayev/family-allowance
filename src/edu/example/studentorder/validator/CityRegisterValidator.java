package edu.example.studentorder.validator;

import edu.example.studentorder.domain.Person;
import edu.example.studentorder.domain.register.AnswerCityRegister;
import edu.example.studentorder.domain.Child;
import edu.example.studentorder.domain.register.AnswerCityRegisterItem;
import edu.example.studentorder.domain.register.CityRegisterResponse;
import edu.example.studentorder.domain.StudentOrder;
import edu.example.studentorder.exception.CityRegisterException;
import edu.example.studentorder.exception.TransportException;
import edu.example.studentorder.validator.register.CityRegisterChecker;
import edu.example.studentorder.validator.register.FakeCityRegisterChecker;

/*
класс валидатор проверяющий являются ли жителями этого города
 */
public class CityRegisterValidator {
    public static final String IN_CODE = "NO_GRN";
    private CityRegisterChecker personChecker;

    public CityRegisterValidator() {
        personChecker = new FakeCityRegisterChecker();
    }

    public AnswerCityRegister checkCityValidator(StudentOrder so) { //метод проверки
        AnswerCityRegister ans = new AnswerCityRegister();

        ans.addItem(checkPerson(so.getHusband())); //складываем в наш список ответов
        ans.addItem(checkPerson(so.getWife()));
        for (Child child : so.getChildren()) {
            ans.addItem(checkPerson(child));
        }

        return ans;
    }

    private AnswerCityRegisterItem checkPerson(Person person){
        AnswerCityRegisterItem.CityStatus status;
        AnswerCityRegisterItem.CityError error = null;

        try {
           CityRegisterResponse tmp = personChecker.checkPerson(person);
            status = tmp.isExisting() ?
                    AnswerCityRegisterItem.CityStatus.YES:
                    AnswerCityRegisterItem.CityStatus.NO;
        } catch (CityRegisterException e ) {
            e.printStackTrace(System.out);
            status = AnswerCityRegisterItem.CityStatus.ERROR;
            error = new AnswerCityRegisterItem.CityError(e.getCode(), e.getMessage());
        } catch (TransportException e) {
            e.printStackTrace(System.out);
            status = AnswerCityRegisterItem.CityStatus.ERROR;
            error = new AnswerCityRegisterItem.CityError(IN_CODE, e.getMessage());
        } catch (Exception e){
            e.printStackTrace(System.out);
            status = AnswerCityRegisterItem.CityStatus.ERROR;
            error = new AnswerCityRegisterItem.CityError(IN_CODE, e.getMessage());
        }

        AnswerCityRegisterItem ans =
                new AnswerCityRegisterItem(status ,person, error);
        return ans;
    }
}
/*
Валидатор должен обратиться к посреднику, передать информацию , поулучить ответ его разобрать и отдать результат проверки на выход всей семьи
CityRegisterValidator - должен класс отправит к CityRegisterа наш он должен собрать все и  поместит в ansercityregister и возвращать ответ
*/