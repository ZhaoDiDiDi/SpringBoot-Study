package com.it.controller;

import com.it.mapper.UserMapper;
import com.it.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController   //结合了@Controller和@ResponseBody两个注解
public class UserController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/user")
    public List<User> queryUserList() {
        List<User> userList = userMapper.queryUserList();
        return userList;
    }

    @GetMapping("/user/{id}")
    public User queryUserList(@PathVariable("id") int id) {
        User user = userMapper.queryUserById(id);
        return user;
    }

    //添加一个用户
    @GetMapping("/addUser")
    public String addUser() {
        userMapper.addUser(new User(8, "jack", "aabbccddd"));
        return "Ok";
    }

    //修改一个用户
    @GetMapping("/updateUser")
    public String updateUser() {
        userMapper.updateUser(new User(8, "jack", "1111111"));
        return "Ok";
    }

    //删除一个用户
    @GetMapping("/deleteUser")
    public String deleteUser() {
        userMapper.deleteUser(8);
        return "Ok";
    }
}
