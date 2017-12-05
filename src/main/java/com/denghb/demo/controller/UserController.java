package com.denghb.demo.controller;

import com.denghb.demo.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by denghb on 2017/7/31.
 */
@Api("用户")
@Controller
@RequestMapping("/user")
public class UserController {

    // 先模拟数据库
    static Map<Long, User> users = new ConcurrentHashMap<Long, User>();

    static {
        // 新增一个默认用户
        User user = new User();
        user.setId(1L);
        user.setName("denghb");
        user.setEmail("i<at>denghb.com");

        users.put(user.getId(), user);
    }

    @ApiOperation(value = "所有用户列表", notes = "")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getList() {
        return new ArrayList<User>(users.values());
    }

    @ApiOperation(value = "获取指定ID用户信息", notes = "")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @ResponseBody
    public User get(@PathVariable("id") Long id) {
        return users.get(id);
    }

    @ApiOperation(value = "新增用户", notes = "")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public String post() {
        User user = new User();
        user.setId(2L);
        user.setName("denghb2");
        user.setEmail("i<at>denghb.com");
        users.put(user.getId(), user);
        return "ok";
    }
}
