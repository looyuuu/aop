package com.looyu.jdkProxy;

public class Father implements BuyInterface{
    @Override
    public void buyJy() {
        System.out.println("买酱油让儿子去");
    }
}
