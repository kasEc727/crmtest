package com.kasec.crm.util;

import com.kasec.crm.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TranscationInvocationHandler implements InvocationHandler {

    private  Object target;

    public TranscationInvocationHandler(Object target) {
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        SqlSession session=null;
        Object obj=null;

        try {

            session=SqlSessionUtil.getSession();
            //处理业务逻辑
            obj=method.invoke(target,args);
            //处理完业务逻辑,提交事务
            session.commit();


        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            SqlSessionUtil.myClose(session);
        }

        return obj;
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
}
