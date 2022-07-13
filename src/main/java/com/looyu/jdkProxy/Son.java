package com.looyu.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Son implements InvocationHandler {

    private BuyInterface target;
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("Dad是个懒人");
        Object ret = method.invoke(this.target, args);

        return null;
    }

    public BuyInterface bind(BuyInterface _target) {
        this.target = _target;
        BuyInterface proxy = (BuyInterface) Proxy.newProxyInstance(this.target.getClass().getClassLoader(),
                this.target.getClass().getInterfaces(), this);
        return proxy;
    }
}
