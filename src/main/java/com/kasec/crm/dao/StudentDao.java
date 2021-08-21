package com.kasec.crm.dao;

import com.kasec.crm.domain.Student;

public interface StudentDao {

    public Student getById(String id);

    public void save(Student student);

}
