package com.kasec.crm.util;

public class ServiceFactory {

    public static Object getService(Object service){
        return new TranscationInvocationHandler(service).getProxy();
    }

}
