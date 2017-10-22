package com.cmcc.cn.webapp;

import com.cmcc.cn.entity.User;
import com.cmcc.cn.service.FeignService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by le on 2017/10/16.
 */
@RestController
@RequestMapping(value = "/UserService",produces = "application/json;charset=UTF-8")
public class UserRequest {
    @Value("${profile}")
    private String profile;
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

//    @ResponseBody
//    @RequestMapping(value = "/queryUserByFeign")
//    public User queryUserByFeign(){
//        System.out.println("开始进入consumer入口:queryUserByFeign");
//        return feignService.findUser();
//    }
//
//    @ResponseBody
//    @RequestMapping(value = "/queryUserByFeignPostMethod")
//    public User queryUserByFeignPostMethod(@RequestBody User user){
//        System.out.println("开始进入consumer入口:queryUserByFeign");
//        return feignService.findUserByPostMethod(user);
//    }

    /*增加hystrix回退机制,当父接口关闭时，超时1s后自动调用hystrixf回掉机制方法*/
    @ResponseBody
    @RequestMapping(value = "/findUserListByPostMethod")
//    @HystrixCommand(fallbackMethod = "hystrixFeedback",commandProperties = {@HystrixProperty(name = "execution.isolation.strategy", value="SEMAPHORE")})
    public List<User> findUserListByPostMethod(){
        System.out.println("findUserListByPostMethod");
        System.out.println("===================="+profile);
        return feignService.findUserListByPostMethod();
    }
    /*hystrix回退机制方法*/
    private List<User> hystrixFeedback(){
        List<User> userList=new ArrayList<User>();
        System.out.println("hystrix回退机制方法");
        return userList;
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
