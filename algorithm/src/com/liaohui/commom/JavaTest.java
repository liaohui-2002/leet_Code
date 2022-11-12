package com.liaohui.commom;

import org.junit.Test;


/**
 * @auther Mr.Liao
 * @date 2022/10/23 18:37
 */
public class JavaTest {

    @Test
    public void  test1(){
        /*short s1 = 1;
//        s1 = s1+1;//报错
        s1+=1;//隐含强制类型转换
        System.out.println(getType(s1));*/
//        const int a = 1;

    /*    Integer f1 = 100,f2 = 100,f3=150,f4=150;
        System.out.println(f1==f2);
        System.out.println(f3==f4);*/
/*
        String s1 = new StringBuilder("Go").append("od").toString();
        System.out.println(s1.intern() == s1);

        String s2 = new StringBuilder("Go").append("od").toString();
        System.out.println(s2.intern() == s2);//此处s2会指向s1*/

        System.out.println(Math.round(11.5));

    }
  public  static String getType(Object o){
        return o.getClass().toString();
  }


  @Test
    public void testHashMap(){
        Object o = new Object();
      System.out.println(o.hashCode());
  }

}
