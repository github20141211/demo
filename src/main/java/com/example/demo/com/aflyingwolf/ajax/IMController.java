package com.example.demo.com.aflyingwolf.ajax;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/im")
public class IMController {

    @PostMapping("/thrid/receive")
    public Object receive() {

        return null;
    }
}
