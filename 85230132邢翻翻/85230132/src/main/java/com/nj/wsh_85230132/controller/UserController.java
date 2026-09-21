package com.nj.wsh_85230132.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/userInfo")
    public Map findUserInfo(@RequestParam("userId") String userId){
        System.out.println("UserController.findUserInfo-> userId"+userId);
        Map map = new HashMap<>();
        map.put("username","wsh124");
        map.put("姓名","邢翻翻");
        map.put("userId",userId);
        return map;
    }

}
