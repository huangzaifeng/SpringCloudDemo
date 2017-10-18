package com.cmcc.cn.webapp;

import com.cmcc.cn.entity.User;
import com.cmcc.cn.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by le on 2017/10/16.
 */
@RestController
@RequestMapping(value = "/UserService",produces = "application/json;charset=UTF-8")
public class UserRequest {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private FeignService feignService;

    @ResponseBody
    @RequestMapping(value = "/queryUser")
    public User queryUser(){
        System.out.println("开始进入consumer入口");
        return this.restTemplate.getForObject("http://spring-cloud-provide/UserService/findUser",User.class);
    }

    @ResponseBody
    @RequestMapping(value = "/queryUserByFeign")
    public User queryUserByFeign(){
        System.out.println("开始进入consumer入口:queryUserByFeign");
        return feignService.findUser();
    }

    @ResponseBody
    @RequestMapping(value = "/queryUserByFeignPostMethod")
    public User queryUserByFeignPostMethod(@RequestBody User user){
        System.out.println("开始进入consumer入口:queryUserByFeign");
        return feignService.findUserByPostMethod(user);
    }

    @ResponseBody
    @RequestMapping(value = "/findUserListByPostMethod")
    public List<User> findUserListByPostMethod(){
        System.out.println("开始进入consumer入口:queryUserByFeign");
        return feignService.findUserListByPostMethod();
    }

    @ResponseBody
    @RequestMapping(value = "/buildRibbonInfo")
    public String buildRibbonInfo(){
        System.out.println("buildRibbonInfo");
        ServiceInstance service=loadBalancerClient.choose("spring-cloud-provide");
        System.out.println(service.getHost()+"---"+service.getServiceId()+"---"+service.getPort());
        return "11";
    }




}
