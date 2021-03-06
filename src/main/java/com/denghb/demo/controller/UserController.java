package com.denghb.demo.controller;

import com.denghb.demo.domain.User;
import io.swagger.annotations.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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

    @ApiOperation(value = "获取指定ID用户信息", notes = "<pre>id:用户ID，\nname:姓名</pre>" ,response = User.class)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long",paramType = "path")
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


    @ApiOperation(value = "新增用户", notes = "")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Long", paramType = "form"),
            @ApiImplicitParam(name = "name", value = "姓名", required = true, dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "email", value = "邮箱", required = true, dataType = "String", paramType = "form")
    })
    @ResponseBody
    public String add(HttpServletRequest request) {

        // , long id, String name, String email
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        User user = new User();
        user.setId(Long.parseLong(id));
        user.setName(name);
        user.setEmail(email);
        users.put(user.getId(), user);
        return "ok";
    }
}
