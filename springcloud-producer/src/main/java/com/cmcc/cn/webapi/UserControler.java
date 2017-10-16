package com.cmcc.cn.webapi;

import com.cmcc.cn.entity.User;
import com.cmcc.cn.service.inf.UserIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Created by le on 2017/10/16.
 */
@RestController()
@RequestMapping(value = "/UserService",produces = "application/json;charset=UTF-8")
public class UserControler {
    @Resource(name = "userService")
    private UserIService userIService;

    @ResponseBody
    @RequestMapping(value = "/findUser")
    private User findUser(){
        System.out.println("=============");
        User user=userIService.findUserByName("ll");
        System.out.println(user);
        System.out.println("=============");
        return  user;
    }

}
