package com.liaohui.all.ex_String.ex_139_单词拆分;

import java.util.HashMap;
import java.util.List;

/**
 * @author Mr.lh
 * @date 2022/11/20 16:02
 */
public class Solution {
    //记忆化递归 保存某些递归的结果
    HashMap<String,Boolean> map = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        return isContain(s,wordDict);
    }
    public boolean isContain(String s, List<String> wordDict){
        if(s.equals("")) return true;
        if(map.containsKey(s)){
            return false;
        }
        //思路一 递归
        boolean result = false;


        //业务逻辑处理
        for (int i = 0; i <s.length(); i++) {
            if(wordDict.contains(s.substring(0,i+1))){
                result = result || wordBreak(s.substring(i+1),wordDict);
                if(!result){
                    map.put(s.substring(i+1),true);
                }
            }
        }
        return result;
    }
}
