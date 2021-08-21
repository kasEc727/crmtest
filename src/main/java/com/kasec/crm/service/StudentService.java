package com.kasec.crm.service;

import com.kasec.crm.domain.Student;

public interface StudentService {
    public Student getById(String id);

    public void save(Student student);


}
