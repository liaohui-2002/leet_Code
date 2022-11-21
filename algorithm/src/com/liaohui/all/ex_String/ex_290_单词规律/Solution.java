package com.liaohui.all.ex_String.ex_290_单词规律;

/**
 * @author Mr.lh
 * @date 2022/11/17 13:11
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
 * 示例1:
 *
 * 输入: pattern = "abba", s = "dog cat cat dog"
 * 输出: true
 */
public class Solution {
    public boolean wordPattern(String pattern, String s) {
        //思路 借助map让pattern中的字符和s中的单词进行映射
        //先将s分割为字符串数组
        String[] str = s.split(" ");
        char[] patterns = pattern.toCharArray();
        //特殊情况 两个长度不想等 肯定不匹配
        if(str.length != patterns.length){
            return false;
        }
        //建立两个hashMap进行双向判断
        Map<Character,String> map1 = new HashMap<>();
        Map<String,Character> map2 = new HashMap<>();
        for (int i = 0; i < patterns.length; i++) {
            if(map1.containsKey(patterns[i])){//从字符数组向字符串数组映射
                if(!str[i].equals(map1.get(patterns[i]))){
                    //如果出现字符串数组中的第i个 匹配不上 字符数组的第i个key的value 说明不匹配
                    return false;
                }
            }
            //从字符串数组向字符数组映射
            if(map2.containsKey(str[i])){
                if(!map2.get(str[i]).equals(patterns[i])){
                    //同理
                    return false;
                }
            }
            //遇到没有存储的，就不会进入判断 只用一个表无法判断s中都是一个单词的情况
            map1.put(patterns[i],str[i]);
            map2.put(str[i],patterns[i]);
        }
        //全部走完没有返回false
        return true;
    }
}
