package edu.example.studentorder;

import edu.example.studentorder.domain.*;
import edu.example.studentorder.domain.children.AnswerChildren;
import edu.example.studentorder.domain.register.AnswerCityRegister;
import edu.example.studentorder.domain.student.AnswerStudent;
import edu.example.studentorder.domain.wedding.AnswerWedding;
import edu.example.studentorder.mail.MailSender;
import edu.example.studentorder.validator.ChildrenValidator;
import edu.example.studentorder.validator.CityRegisterValidator;
import edu.example.studentorder.validator.StudentValidator;
import edu.example.studentorder.validator.WeddingValidator;

import java.util.LinkedList;
import java.util.List;

public class StudentOrderValidator {
    private CityRegisterValidator cityRegisterValidator;
    private ChildrenValidator childrenValidator;
    private StudentValidator studentValidator;
    private WeddingValidator weddingValidator;
    private MailSender mailSender;

    public StudentOrderValidator() {
        this.cityRegisterValidator = new CityRegisterValidator();
        this.childrenValidator = new ChildrenValidator();
        this.studentValidator = new StudentValidator();
        this.weddingValidator = new WeddingValidator();
        this.mailSender = new MailSender();
    }

    public static void main(String[] args) {
        StudentOrderValidator sov = new StudentOrderValidator();
        sov.checkAll();
    }

    private void checkAll() { //проверка всех
        List<StudentOrder> soList = readStudentOrders();

        for (StudentOrder so: soList){
            checkOneOrder(so);
        }
    }

    public void checkOneOrder(StudentOrder so) {
        AnswerCityRegister cityAnswer = checkCityRegister(so);
//        AnswerWedding weddingAnswer = checkWedding(so);
//        AnswerChildren childrenAnswer = checkChildren(so);
//        AnswerStudent studentAnswer = checkStudent(so);
//        sendMail(so);
    }

    public AnswerCityRegister checkCityRegister(StudentOrder so){
        return cityRegisterValidator.checkCityValidator(so);
    }

    public AnswerWedding checkWedding(StudentOrder so){
        return weddingValidator.checkWedding(so);
    }

    public AnswerChildren checkChildren(StudentOrder so){
        return childrenValidator.checkChildren(so);
    }

    public AnswerStudent checkStudent(StudentOrder so){
        return studentValidator.checkStudent(so);
    }

    private void sendMail(StudentOrder so) {
        mailSender.sendMail(so);
    }

    public List<StudentOrder> readStudentOrders(){ //чтение списка заявок
        List<StudentOrder> soList = new LinkedList<>(); //список заявок

        for (int i = 0; i < 5; i++) {
            StudentOrder so = SaveStudentOrder.builderStudentOrder(i); //заполняем заявки ,передаем число от 0 до 4
            soList.add(so);
        }

        return soList;
    }
}
