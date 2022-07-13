package com.looyu.lock;

import java.util.PrimitiveIterator;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class LockSyncDemo {

//   Object object = new Object();
//    public void m1() {
//        synchronized (object) {
//            System.out.println("---------- hello sync code block");
//            throw new RuntimeException("------------------>exp");
//        }
//    }
//    public synchronized void m2() {
//        System.out.println("-----------sync code test");
//    }
//    public static synchronized void m3() {
//        System.out.println("----------sync code test m3");
//    }
//final Object objectA = new Object();
//    final Object objectB = new Object();
//
//        new Thread(() -> {
//        synchronized (objectA) {
//            System.out.println(Thread.currentThread().getName() + "\t 自己持有A锁, 希望获得B锁");
//
//            synchronized (objectB) {
//                System.out.println(Thread.currentThread().getName() + "\t 成功获得B锁");
//            }
//        }
//    },"A").start();
//
//
//        new Thread(() -> {
//        synchronized (objectB) {
//            System.out.println(Thread.currentThread().getName() + "\t 自己持有B锁, 希望获得A锁");
//            try {
//                TimeUnit.MILLISECONDS.sleep(1);
//            } catch (InterruptedException e){e.printStackTrace();}
//            synchronized (objectA) {
//                System.out.println(Thread.currentThread().getName() + "\t 成功获得A锁");
//            }
//        }
//    },"B").start();

    static volatile boolean flag = false;

    static AtomicBoolean atomicBoolean = new AtomicBoolean(false);

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread().getName() + "\t isInterrupted被修改为true， 确定停止");
                    break;
                }
                System.out.println("t1 ------------hello atomicBoolean");
            }
        }, "t1");
        t1.start();
        System.out.println("默认中断标志位：" + t1.isInterrupted());

        TimeUnit.MILLISECONDS.sleep(10);
//        t1.interrupt();
        new Thread(t1::interrupt,"t2").start();
    }



    /**
     * AtomicBoolean 原子Boolean标识，中断运行中的线程
     * @throws InterruptedException
     */
    private static void m2_atomicBoolean() throws InterruptedException {
        new Thread(() -> {
            while (true) {
                if (atomicBoolean.get()) {
                    System.out.println("标志为true， 确定停止");
                    break;
                }
                System.out.println("t1 ------------hello atomicBoolean");
            }
        }, "t1").start();


        TimeUnit.MILLISECONDS.sleep(10);

        new Thread(() -> {
            atomicBoolean.set(true);
        },"t2").start();
    }

    /**
     * volatile 中断运行中的线程
     * @throws InterruptedException
     */
    private static void m1_volatile() throws InterruptedException {
        new Thread(() -> {
            while (true) {
                if (flag) {
                    System.out.println("标志为true， 确定停止");
                    break;
                }
                System.out.println("t1 ------------hello volatile");
            }
        }, "t1").start();


        TimeUnit.MILLISECONDS.sleep(1);

        new Thread(() -> {
            flag =true;
        },"t2").start();
    }

}
