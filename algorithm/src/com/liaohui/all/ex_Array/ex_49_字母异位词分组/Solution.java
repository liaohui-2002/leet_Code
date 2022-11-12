package com.liaohui.all.ex_Array.ex_49_字母异位词分组;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Mr.lh
 * @date 2022/11/12 15:07
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList> map =  new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key  = new String(chars);
            //将字母组合排序后作为map键值对的key存入map

            if(map.get(key) == null){
                map.put(key,new ArrayList<String>());
            }
            map.get(key).add(str);
        }
        return new ArrayList(map.values());
    }

    @Test
    public void test1(){
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strs);
        System.out.println(lists);
    }
}
