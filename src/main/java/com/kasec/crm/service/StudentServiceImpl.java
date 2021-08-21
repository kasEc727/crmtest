package com.kasec.crm.service;

import com.kasec.crm.dao.StudentDao;
import com.kasec.crm.domain.Student;

public class StudentServiceImpl implements StudentService {

    private StudentService studentService=new StudentServiceImpl();

    @Override
    public Student getById(String id) {
        Student student=studentService.getById(id);
        return student;
    }

    @Override
    public void save(Student student) {
        studentService.save(student);
    }
}
