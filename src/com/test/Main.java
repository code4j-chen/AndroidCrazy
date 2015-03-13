package com.test;

/**
 * Created by code4j on 2015/3/13.
 */
public class Main {
    public static void main(String[] args) {
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                new Thread1().method1();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                new Thread2().method2();
            }
        }).start();*/

        try {
            new Thread1().method1();
            new Thread2().method2();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
