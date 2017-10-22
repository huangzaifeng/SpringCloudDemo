package com.cmcc.cn.service;

import com.cmcc.cn.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by le on 2017/10/17.
 */
@FeignClient(name = "spring-cloud-provide",fallbackFactory = HystrixClientFallbackFactory.class)
public interface FeignService {

//   @RequestMapping(method = RequestMethod.POST,value = "/UserService/findUser",consumes = "application/json")
//   User findUser();
//
//   @RequestMapping(method = RequestMethod.POST,value = "/UserService/findUserByPostMethod",consumes = "application/json")
//   User findUserByPostMethod(User user);

   @RequestMapping(method = RequestMethod.POST,value = "/UserService/findUserForList",consumes = "application/json")
   List<User> findUserListByPostMethod();

}
