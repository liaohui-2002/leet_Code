package com.liaohui.all;

/**
 * @author Mr.lh
 * @date 2022/11/11 16:16
 */
public class RunTest implements Runnable{
    @Override
    public void run() {
        System.out.println("runnable___"+Thread.currentThread().getName());
    }
}
