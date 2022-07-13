package com.looyu.lock;

public class TestReturn {

    public static void main(String[] args) {
        test1();

    }

    public static void test1() {

        for (int i = 0; i <= 10; i++) {

            for (int j = 1; j <= 9; j++) {

                System.out.println("j" + j);
                break;
            }
            System.out.println("i" + i);
        }
        System.out.println(2);
    }
}
