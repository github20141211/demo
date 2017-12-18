package com.example.demo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 会飞的狼 on 2017/12/16. */
@RestController
@Api(value = "HelloWolrd示例", description = "hello模块")
public class HelloController {

    @RequestMapping(value = "/hello",  method= RequestMethod.GET)
    @ApiOperation(value="Hello", notes="Hello示例")
    public String index() {
        return "Hello World";
    }
}
