package com.cmcc.cn.service;

import com.cmcc.cn.entity.User;
import com.cmcc.cn.service.inf.UserIService;
import org.springframework.stereotype.Service;

/**
 * Created by le on 2017/10/16.
 */
@Service(value = "userService")
public class UserServiceImpl implements UserIService {
    @Override
    public User findUserByName(String name) {
        User user=new User();
        user.setAge(24);
        user.setUserName("lile");
        return user;
    }
}
