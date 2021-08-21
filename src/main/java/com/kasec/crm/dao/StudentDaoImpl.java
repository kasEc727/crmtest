package com.kasec.crm.dao;

import com.kasec.crm.domain.Student;
import com.kasec.crm.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class StudentDaoImpl implements StudentDao {
    @Override
    public Student getById(String id) {

        SqlSession sqlSession= SqlSessionUtil.getSession();
        Student student=sqlSession.selectOne("studentMapper.selectById",id);
        return student;
    }

    @Override
    public void save(Student student) {

        SqlSession session=SqlSessionUtil.getSession();
        session.insert("studentMapper.insertStudent",student);

    }
}
