package com.sxtc.ccweb.base;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;
import org.springframework.util.StringUtils;

/**
 * Created by Administrator on 2016/8/31.
 */
public class AuthorizationFilter implements ContainerRequestFilter {

    public ContainerRequest filter(ContainerRequest containerRequest) {

        //获取客户端head中提交的token
        String token = containerRequest.getHeaderValue("Authorization");
        if (StringUtils.isEmpty(token)) {
            //TODO:拦截响应
        }

        //判断该用户是否已登录

        return null;
    }
}
