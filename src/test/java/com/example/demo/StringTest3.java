package com.example.demo;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class StringTest3 {

    public static void main(String[] args) {
//        String s="abcdefg";
//        String s2="";
//        char[] cs=s.toCharArray();
//        for(int i=cs.length-1;i>=0;i--)
//        {
//            s2=s2+cs[i];
//        }
//        System.out.println("对字符串进行反转操作后为:"+s2);
        StringBuffer sb=new StringBuffer("994049228752728066");
        StringBuffer sb2=sb.reverse();
        System.out.println("对StringBuffer进行反转操作后为:"+sb2);

        MultiValueMap<String, Object> postParameters = new LinkedMultiValueMap<>();
        postParameters.add("accid", 123456);
        postParameters.add("name", 789101112);
        System.out.println(postParameters);
    }
}
