package com.looyu.anno;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.CompletableFuture;

public class Demo2 {
    public static void main(String[] args) {
//         // 手动编写Aop
//        // 目标对象
//        final UserDao userDao = new UserDaoImpl();
//        // 切面类对象
//        final LogAop logAop = new LogAop();
//        // 创建目标对象的代理对象
//        UserDao proxy = (UserDao) Proxy.newProxyInstance(userDao.getClass().getClassLoader(),
//                userDao.getClass().getInterfaces(), new InvocationHandler() {
//                    @Override
//                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                        // 调用切面类方法
//                        logAop.begin();
//                        Object invoke = method.invoke(userDao, args);
//                        logAop.end();
//                        return null;
//                    }
//                });
//
//        proxy.add();
//        proxy.delete();



//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");
//        UserDao dao = (UserDao) context.getBean("userDaoImpl");
//        dao.delete();
//        dao.add();
    }
}
