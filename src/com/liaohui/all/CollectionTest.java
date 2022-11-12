package com.liaohui.all;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Mr.lh
 * @date 2022/11/10 14:49
 */
public class CollectionTest {

    /**
     * HashMapTest
     */
    @Test
    public void test1(){
        HashMap<String,Integer> map = new HashMap<>(1);
        System.out.println(map.size());
        map.put("李世民",1);
        System.out.println(map.size());
        map.put("李隆基",2);
        map.put("李隆基",2);
        System.out.println(map);

        ConcurrentHashMap<String,String> map2 = new ConcurrentHashMap<>();

        String s = String.valueOf(new StringBuffer());
    }
    @Test
    public  void test2(){
        ArrayList<Integer> arrayList = new ArrayList<>();
    }
}
