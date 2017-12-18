package com.example.demo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author 会飞的狼 on 2017/12/16.
 */
@RestController
@Api(value = "用户信息", description = "用户模块")
@RequestMapping(value="/users")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(HelloController.class);

    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());

    @ApiOperation(value="获取用户列表", notes="获取用户列表", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value={""}, method= RequestMethod.GET)
    public List<User> getUserList() {
        logger.info("----->" , "获取用户列表");
        List<User> r = new ArrayList<User>(users.values());
        return r;
    }

    @ApiOperation(value="创建用户", notes="根据User对象创建用户", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value="", method=RequestMethod.POST)
    public String postUser(@RequestBody User user) {
        logger.info("----->创建用户{}" , user.toString());
        users.put(user.getId(), user);
        return "success";
    }

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息",  produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        logger.info("----->获取用户详细信息{}" , id);
        return users.get(id);
    }

    @ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @RequestBody User user) {
        logger.info("----->更新用户详细信息{}, 用户信息{}" , id, user.toString());
        User u = users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(id, u);
        return "success";
    }

    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        logger.info("----->删除用户{}" , id);
        users.remove(id);
        return "success";
    }
}
