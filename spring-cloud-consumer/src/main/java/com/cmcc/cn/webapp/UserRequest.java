package com.cmcc.cn.webapp;

import com.cmcc.cn.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by le on 2017/10/16.
 */
@RestController
@RequestMapping(value = "/UserService",produces = "application/json;charset=UTF-8")
public class UserRequest {
    @Autowired
    private RestTemplate restTemplate;

    @ResponseBody
    @RequestMapping(value = "/queryUser")
    public User queryUser(){
        System.out.println("开始进入consumer入口");
        return this.restTemplate.getForObject("http://spring-cloud-provide/UserService/findUser",User.class);
    }


}
