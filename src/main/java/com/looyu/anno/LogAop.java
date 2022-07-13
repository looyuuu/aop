package com.looyu.anno;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Aspect
// 切面类
public class LogAop {
    @Pointcut("execution(* com.looyu.anno.UserDaoImpl.*(..))")
    public void pointcut() {

    }
    // 关注点
    //只需要在当前方法中写一个叫JionPoint的参数即可
    @Before("execution(* com.looyu.anno.UserDaoImpl.*(..))")
    public void begin(JoinPoint joinPoint) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s1 = simpleDateFormat.format(date);
        String name = joinPoint.getSignature().getName();
        System.out.println("调用开始的时间：" + s1);
    }
    @After("pointcut()")
    public void end(JoinPoint joinPoint) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s2 = simpleDateFormat.format(date);
        String name = joinPoint.getSignature().getName();
        System.out.println("调用结束的时间：" + s2);
    }

    // 环绕通知，必须给参数，没有参数，目标方法不会执行
    public void around(ProceedingJoinPoint pjp) {
        System.out.println("环绕前");
        try {
            pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("环绕后");
    }

}
