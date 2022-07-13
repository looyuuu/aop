package com.looyu.lock;

import java.util.concurrent.TimeUnit;

public class InterceptedDemo2 {


    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 300; i++) {
                System.out.println("---------" + i);
            }
            System.out.println("t1调用方法后的中断标识02：" + Thread.currentThread().isInterrupted());
        }, "t1");
        t1.start();
        System.out.println("t1默认中断标识： " + t1.isInterrupted());

        TimeUnit.MILLISECONDS.sleep(1);

        t1.interrupt();
        System.out.println("t1调用interrupt()方法后的中断标识01： " + t1.isInterrupted());
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("t1调用interrupt()方法后的中断标识03： " + t1.isInterrupted());
    }
}
