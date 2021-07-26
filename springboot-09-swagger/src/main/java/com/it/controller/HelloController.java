package com.it.controller;

import com.it.pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @ApiOperation("Hello控制接口")
    @GetMapping(value = "/hello")
    public String Hello() {
        return "hello";
    }

    @ApiOperation("User接口")
    //只要我们的接口中，返回值中存在实体类，他就会被扫描到Swagger中
    @PostMapping("/user")
    public User user() {
        return new User();
    }

    @ApiOperation("get用户名测试")
    //只要我们的接口中，返回值中存在实体类，他就会被扫描到Swagger中
    @GetMapping("/get")
    public String user2(@ApiParam("用户名") String username) {
        return username;
    }

    @ApiOperation("post用户测试")
    //只要我们的接口中，返回值中存在实体类，他就会被扫描到Swagger中
    @PostMapping("/get")
    public User user3(@ApiParam("用户") User user) {
        return user;
    }
}
