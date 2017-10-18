package com.cmcc.cn.config;

import com.cmcc.cn.annotation.ExcludeFromComponentScan;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

/**
 * Created by le on 2017/10/17.
 */
@Configurable
@ExcludeFromComponentScan
public class RibbonConfig {

    @Autowired
    private IClientConfig clientConfig;

    @Bean
    public IRule ribbonRule(IClientConfig config){
        return new RandomRule();
    }

}
