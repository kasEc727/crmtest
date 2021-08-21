package com.kasec.crm.test;


import com.kasec.crm.domain.Student;
import com.kasec.crm.service.StudentService;
import com.kasec.crm.service.StudentServiceImpl;
import com.kasec.crm.util.ServiceFactory;

public class test02 {
    public static void main(String[] args) {
        //StudentService studentService=new StudentServiceImpl();
        StudentService studentService= (StudentService) ServiceFactory.getService(new StudentServiceImpl());

        Student student=new Student();
        student.setId("2");
        student.setAge(20);
        student.setName("zhangsan");
        studentService.getById("2");

    }

}
