package com.looyu.jdkProxy;

public class Demo {
    public static void main(String[] args) {
        Father father = new Father();
        BuyInterface proxy = new Son().bind(father);
        proxy.buyJy();
    }
}
