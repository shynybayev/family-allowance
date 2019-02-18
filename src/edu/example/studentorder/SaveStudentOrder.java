package edu.example.studentorder;

import edu.example.studentorder.domain.Address;
import edu.example.studentorder.domain.Adult;
import edu.example.studentorder.domain.Child;
import edu.example.studentorder.domain.StudentOrder;
import java.time.LocalDate;

public class SaveStudentOrder {
    public static void main(String[] args) {
        builderStudentOrder(10);
    }

    static long saveStudentOrder(StudentOrder studentOrder){
        long answer = 199;
        System.out.println("saveStudentOrder");
        return answer;
    }
    //метод который позволяет нам вернуть студенческую заявку по идентификатору
    static StudentOrder builderStudentOrder(long id){
        StudentOrder so = new StudentOrder();
        so.setStudentOrderId(id);
        so.setMarriageCertificateId("" + (15154000 + id));
        so.setMarriageDate(LocalDate.of(2018,7,5));
        so.setMarriageOffice("ЗАГС");

        Address address = new Address("15", "WalkStreet", "12312", "", "123");
        //муж
        Adult husband = new Adult("Askarov", "Aset","Asanovich", LocalDate.of(1997,8,24));
        husband.setPassportSeria("" + (1000 + id));
        husband.setPassportNumber("" + (10000 + id));
        husband.setIssueDate(LocalDate.of(2017,9,15));
        husband.setIssueDepartment("Отдел полиции " + id);
        husband.setStudentId("" + (100 + id));
        husband.setAddress(address);
        printStudentOrder(so);
        //жена
        Adult wife = new Adult("Askarova", "Anel", "Aibekovna", LocalDate.of(1998, 5, 12));
        wife.setPassportSeria("" + (2000 + id));
        wife.setPassportNumber("" + (20000 + id));
        wife.setIssueDate(LocalDate.of(2018, 4, 5));
        wife.setIssueDepartment("Отдел полиции " + id);
        wife.setStudentId("" + (200 + id));
        wife.setAddress(address);
        //ребенок
        Child child1 = new Child("Askarova","Zhuldyz","Asetovna", LocalDate.of(2018,6,15));
        child1.setCertificateNumber("" + (30000 + id));
        child1.setIssueDate(LocalDate.of(2018, 4 , 5));
        child1.setIssueDepartment("Отдел ЗАГС № " + id);
        child1.setAddress(address);

        //ребенок
        Child child2 = new Child("Askarov","Abzal","Asetovich", LocalDate.of(2018,6,15));
        child2.setCertificateNumber("" + (40000 + id));
        child2.setIssueDate(LocalDate.of(2018, 4 , 5));
        child2.setIssueDepartment("Отдел ЗАГС № " + id);
        child2.setAddress(address);


        so.setHusband(husband);
        so.setWife(wife);
        so.addChild(child1);
        so.addChild(child2);
        return so;
    }

    static void printStudentOrder(StudentOrder stOr){
        System.out.println(stOr.getStudentOrderId());
    }
}

/*
#19 все ссылки копируются и могут указывать на один объект. Все входные параметров копируются. Ссылки в стэке, остальные в куче.
сборщик мусора GC. Он существуют в нескольких реализациях.(можно управлять параметрами). Управляет ресурсамию. Когда ссылка на объект не сущетсвует. Вышли из метода и ссылка перестала существовать
*/