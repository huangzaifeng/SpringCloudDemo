package com.cmcc.cn.webapi;

import com.cmcc.cn.entity.User;
import com.cmcc.cn.service.inf.UserIService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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

    @ResponseBody
    @RequestMapping(value = "/findUserForList")
    private List<User> findUserForList(){
        System.out.println("=============");
        User user=userIService.findUserByName("ll");
        List<User> userList=new ArrayList<User>();
        userList.add(user);
        return  userList;
    }

    @ResponseBody
    @RequestMapping(value = "/findUserByPostMethod" ,method = RequestMethod.POST)
    private User findUserByPostMethod(@RequestBody User user){
        System.out.println("=============findUserByPostMethod");
        System.out.println(user);
        System.out.println("=============findUserByPostMethod");
        return  user;
    }

}
