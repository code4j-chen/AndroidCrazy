package com.test;

/**
 * Created by code4j on 2015/3/13.
 */
public class Thread2 extends ThreadDad{
    DecodeManager d = new DecodeManager();
    public void method2() {
        d.decode(this);
    }

    @Override
    void end() {
        System.out.println("Thread2 done!");
    }
}
