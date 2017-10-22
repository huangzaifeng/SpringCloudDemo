package com.cmcc.cn.service;

import com.cmcc.cn.entity.User;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by le on 2017/10/19.
 */
@Component
public class HystrixClientFallbackFactory implements FallbackFactory<FeignService> {
    @Override
    public FeignService create(Throwable throwable) {
        System.out.println(throwable.getMessage());
        System.out.println("======== UserFeignHystrixFactoryClient.create " + Thread.currentThread().getThreadGroup() + " - " + Thread.currentThread().getId() + " - " + Thread.currentThread().getName());
        return new UserFeignWithFallBackFactoryClient(){

//            @Override
//            public User findUser() {
//                return null;
//            }
//
//            @Override
//            public User findUserByPostMethod(User user) {
//                return null;
//            }

            @Override
            public List<User> findUserListByPostMethod() {
                System.out.println("======== findById FallBackFactory " + Thread.currentThread().getThreadGroup() + " - " + Thread.currentThread().getId() + " - " + Thread.currentThread().getName());
                return null;
            }
        };
}
}
