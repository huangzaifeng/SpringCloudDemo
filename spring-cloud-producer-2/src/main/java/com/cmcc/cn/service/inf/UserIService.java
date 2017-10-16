package com.cmcc.cn.service.inf;

import com.cmcc.cn.entity.User;

/**
 * Created by le on 2017/10/16.
 */
public interface UserIService {
    User findUserByName(String name);
}
