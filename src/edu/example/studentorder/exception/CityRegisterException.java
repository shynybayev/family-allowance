package edu.example.studentorder.exception;
/*
класс исключение, он может породить некий код ошибки
 */
public class CityRegisterException extends Exception{ //был бы Runtime не обязательо было бы обрабатывать
    private String code;

    public CityRegisterException(String code, String message) {
        super(message);
        this.code = code;
    }

    public CityRegisterException(String code, String message, Throwable cause) { //сообщение с сообщением и с исключением
        super(message, cause);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
