package com.liaohui.all.ex_String.ex_76_最小覆盖子串;

/**
 * @author Mr.lh
 * @date 2022/11/12 16:48
 */

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口
 */
public class Solution {
    public String minWindow(String s, String t) {
         //用两个hash表
        //第一个hash表记录目标字符串  中每个字符串的出现次数
        HashMap<Character, Integer>  ht = new HashMap<>();
        //窗口中每个字符出现的次数 窗口
        HashMap<Character, Integer>  hs = new HashMap<>();
        String ans = null;
        //将t中字符数量初始化
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            ht.put(c,ht.getOrDefault(c,0)+1);
        }
        //进行窗口遍历
        for(int i = 0,j=0,cnt=0;i<s.length();i++){
            hs.put(s.charAt(i),hs.getOrDefault(s.charAt(i),0)+1);
            if(hs.get(s.charAt(i)) +1  <= ht.get(s.charAt(i))) cnt++;

            //去除窗口左侧的冗余字母
            while(hs.get(s.charAt(j)) > ht.get(s.charAt(j))){
                 hs.put(s.charAt(j++),hs.getOrDefault(s.charAt(j++),0)-1);
            }
            if(cnt == t.length()){
                if(ans.isEmpty() || ans.length()>i-j+1){
                    ans = s.substring(j,i-j+1);
                }
            }
        }
        return ans;
    }
    @Test
    public void test1(){
        String s1 = "ADOBECODEBANC";
        String t = "ABC";
        String s = minWindow(s1, t);
        System.out.println(s);
    }

    public String minWindow2(String s, String t) {
        // 分别用两个map存放所需字符数和当前字符计数
        Map<Character, Integer> needMap = new HashMap<>();
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char cur = t.charAt(i);
            needMap.put(cur, needMap.getOrDefault(cur, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int finishCount = 0;
        String result = "";
        int minLen = s.length();
        while (right < s.length()) {
            char cur = s.charAt(right);
            if (needMap.containsKey(cur)) {
                countMap.put(cur, countMap.getOrDefault(cur, 0) + 1);
                // 两个Integer对象比较时，不能使用 == ，要使用equals，如果使用 == ，在[-128,127]范围内正常，范围外不正常
                if (countMap.get(cur).equals(needMap.get(cur))) {
                    finishCount++;
                }
            }
            right++;
            // 如果计数满足要求，则缩小窗口
            while (finishCount == needMap.size()) {
                char leftChar = s.charAt(left);
                if (countMap.containsKey(leftChar) && countMap.get(leftChar) >= needMap.get(leftChar)) {
                    // 记录满足条件的最小子串
                    String tempStr = s.substring(left, right);
                    if (tempStr.length() <= minLen) {
                        result = tempStr;
                        minLen = tempStr.length();
                    }
                    countMap.put(leftChar, countMap.get(leftChar) - 1);
                    if (countMap.get(leftChar) < needMap.get(leftChar)) {
                        finishCount--;
                    }
                }
                left++;
            }
        }
        return result;
    }


}
