package edu.example.studentorder.domain.register;

import edu.example.studentorder.domain.Person;

/*
сообщение. Персона, должен быть статус ответа и класс для описания ошибки, чтобы сам ГРН код ошибки не только текст
*/
public class AnswerCityRegisterItem {
    //перечисления, состояния(статусы)
    public enum CityStatus{
        YES, NO, ERROR
    }

    public static class CityError{
        private String code;
        private String text;

        public CityError(String code, String text) {
            this.code = code;
            this.text = text;
        }

        public String getCode() {
            return code;
        }

        public String getText() {
            return text;
        }
    }

    private CityStatus status; //этому полю только 3 значения могут быть
    private Person person; //проверяем такую персону
    private CityError error; //класс с кодом и тектсом ошибки

    public AnswerCityRegisterItem(CityStatus status, Person person, CityError error) {
        this.status = status;
        this.person = person;
        this.error = error;
    }

    public AnswerCityRegisterItem(CityStatus status, Person person) {
        this.status = status;
        this.person = person;
    }

    public CityStatus getStatus() {
        return status;
    }

    public Person getPerson() {
        return person;
    }

    public CityError getError() {
        return error;
    }
}
