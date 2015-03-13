package com.test;

/**
 * Created by code4j on 2015/3/13.
 */
public abstract class ThreadDad {
    abstract void end();

    private void init() {
        System.out.println("The same operate!");
    }

    public void model() {
        init();
        end();
    }
}
