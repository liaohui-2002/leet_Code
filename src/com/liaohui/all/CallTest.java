package com.liaohui.all;

import java.util.concurrent.Callable;

/**
 * @author Mr.lh
 * @date 2022/11/11 16:17
 */
public class CallTest implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "这是callable的call方法";
    }
}
