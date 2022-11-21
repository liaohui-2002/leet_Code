package com.liaohui.all.ex_String.ex_ProtocolBuffer序列化;

/**
 * @author Mr.lh
 * @date 2022/11/18 11:42
 */

import org.junit.Test;

import java.util.Scanner;

/**
 *对于给定数字M，将其转换成二进制，取前七位（低位），并将第八位（高位）作为标志位，如果第八位是1，则说明需要继续编码，是0则说明编码结束。编码结果是纯大写的十六进制字符串，例如0XE3
 * 对于给定编码字符串S，其是一个纯大写的十六进制表示数字的字符串，比如0XE70X07，其中0XE7是第一个数字，取出来并将16进制转换成二进制，观察其高位是1还是0，是1，则弃其高位，继续计算下边的0X07并拼接到前边的高位上，转换成数字输出回来

 100 = 0x64 = 0b01100100，高位（第八位）是0，所以编码后是0X64
 0XE70X07 先看0XE7
 0xe7 = 0b11100111 ，高位为1，所以要继续往后算0X07
 0x07 = 0b00000111，高位为0，所以这个数字应该是：
 0b00000111（去掉高位）连接0b11100111（去掉高位）
 0b00001111100111 = 999
 因此输出应该是0X64和999

 */
public class Solution {
    public static void main(String[] args) {
        Scanner scan  = new Scanner(System.in);
        int n  = scan.nextInt();
        String str =  scan.nextLine();
        String n_str = serialize(n);
        int i_str = serialize(str);
        System.out.println(n_str);
        System.out.println(i_str);
        scan.close();

    }

    private static String serialize(int dat){
        int tmp;
        int i =0;

       /* while(tmp = dat & ((i<<7)-1))
        String res;*/
        return null;
    }

    private static int serialize(String hexStr){
        String[] res = new String[10];
        int n = hexStr.length();
        for (int i = 0; i < n; i+=4) {
            int[] arr;

        }
        return 0;
    }

    @Test
    public void test(){
        int a = 129;
        System.out.println((a & ((1<<7)-1)));
    }
}
