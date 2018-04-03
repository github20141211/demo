package com.example.demo.com.aflyingwolf.ajax;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 会飞的狼 on 2018/4/3.
 */
@RestController
@RequestMapping(value="/checkUser")
@Api(value = "Ajax示例", description = "Ajax模块")
public class CheckUserController {

    private Logger logger = LoggerFactory.getLogger(CheckUserController.class);

    @RequestMapping(value="/loginName", method= RequestMethod.GET)
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("checkUser");
        return modelAndView;
    }

    @RequestMapping(value="/{loginName}", method= RequestMethod.POST)
    @ApiOperation(value="Ajax", notes="Ajax示例")
    public String userCheck(@PathVariable String loginName) {
        logger.info("===Ajax===");
        String[] logined = {"admin", "users", "dywdyw", "liubin"};
        String responseContext = "true";
        for (int i = 0; i < logined.length; i++) {
            if(loginName.equals(logined[i])) {
                responseContext = "false";
            }
        }
        return responseContext;
    }

    @RequestMapping(value="/saveUser", method= RequestMethod.POST)
    @ApiOperation(value="保存数据", notes="保存数据")
    public ModelAndView saveUser(String loginName, ModelAndView mode) {
        System.out.println("后台接收到的用户名为" + loginName);
        mode.setViewName("checkUser");
        return mode;
    }


//    @RequestMapping(value="/loginName", method= RequestMethod.GET)
//    public ModelAndView index(ModelAndView modelAndView) {
//        modelAndView.setViewName("checkUser");
//
//        List<String> userList=new ArrayList<String>();
//        userList.add("admin");
//        userList.add("user1");
//        userList.add("user2");
//
//        modelAndView.addObject("userList", userList);
//        return modelAndView;
//    }
}
