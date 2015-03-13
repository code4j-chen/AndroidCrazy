package com.test;

/**
 * Created by code4j on 2015/3/13.
 */
public class Thread1 extends ThreadDad{
    public void method1() {
        DecodeManager d = new DecodeManager();
        d.decode(this);
    }

    @Override
    void end() {
        System.out.println("Thread1 done!");
    }
}
