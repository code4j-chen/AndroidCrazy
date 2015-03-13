package com.test;

/**
 * Created by code4j on 2015/3/13.
 */
public class DecodeManager {
    public void decode(final ThreadDad thread) {
        try {
            if (thread instanceof Thread1) {
                Thread.sleep(6000);

            } else {
                Thread.sleep(3000);
            }
            thread.model();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
