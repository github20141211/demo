package com.example.demo;

import org.springframework.web.client.RestTemplate;

/**
 * @author 会飞的狼 on 2017/12/23.
 */
public class HttpMain {

    public static void main(String[] args) {
        RestTemplate template = new RestTemplate();
        String URL = "http://103.45.10.141:8081/hello";
        for (int i = 0; i < 10000; i++) {
            String forObject = template.getForObject(URL, String.class);
            System.out.println(forObject.toString() + "i" + i);
        }

    }
}
