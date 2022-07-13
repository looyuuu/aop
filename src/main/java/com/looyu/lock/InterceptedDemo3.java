package com.looyu.lock;

import java.util.concurrent.TimeUnit;

public class InterceptedDemo3 {
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread().getName() + "\t" + "中断标识位" + Thread.currentThread().isInterrupted() + "程序停止");
                    break;
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
//                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
                System.out.println("------------hello InterceptedDemo3" );
            }
        }, "t1");
        t1.start();

        TimeUnit.MILLISECONDS.sleep(1);

        new Thread(() -> {
            Thread.interrupted();
        });

        new Thread(t1::interrupt, "t2").start();
    }
}

