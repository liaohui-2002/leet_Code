package com.liaohui.all.ex_Backtrack.ex_电话号码字母组合_17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @auther Mr.Liao
 * @date 2022/10/14 12:56
 */
public class Solution {
    List<Character> list = new ArrayList<>();
    HashMap<Character, String> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.isEmpty()){
            return result;
        }
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        //排列组合
//        helper(digits,0);


        return  result;
    }
/*
    private void helper(String digits,int start){
        if(){
            return;
        }
        Character digit  = digits.charAt(start);
        String letters = map.get(digit);

        for (int i = 0; i <letters.length(); i++) {

        }
    }*/
}
