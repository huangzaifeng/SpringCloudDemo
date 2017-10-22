package com.cmcc.cn.webapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by le on 2017/10/22.
 */
@RestController
public class ConfigService {
    @ResponseBody
    @RequestMapping(value = "/sayConfig")
    public String sayConfig(){
        return "";
    }
}
