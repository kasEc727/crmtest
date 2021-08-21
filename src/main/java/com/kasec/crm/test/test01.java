package com.kasec.crm.test;

import com.kasec.crm.domain.Student;
import com.mysql.cj.Session;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class test01 {
    public static void main(String[] args) {

        String resources="mybatis-config.xml";
        InputStream inputStream=null;

        try {
            inputStream= Resources.getResourceAsStream(resources);
        } catch (IOException e) {
            e.printStackTrace();
        }

        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session =sqlSessionFactory.openSession();


        /**
         * 查单条数据
         *  参数1：bean id的位置
         *  参数2：为sql传递的参数
         */
        Student s=session.selectOne("studentMapper.selectById","1");
        System.out.println(s);
        session.close();

    }
}
