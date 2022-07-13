package com.looyu.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CompletableFutureTask {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask<>(new MyThread());
        Thread thread = new Thread(futureTask, "t1");
        thread.start();
        System.out.println(futureTask.get());

    }

    static class MyThread implements Callable{
        @Override
        public String call() throws Exception {
            System.out.println("------------Come in");
            return "我来了";
        }
    }
}
