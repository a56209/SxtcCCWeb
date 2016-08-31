package com.sxtc.ccweb.base;

import com.sun.jersey.spi.container.ContainerRequest;
import org.springframework.util.StringUtils;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import java.io.IOException;

/**
 * Created by Administrator on 2016/8/31.
 */
public class AuthorizationFilter implements ContainerRequestFilter {

    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        //获取客户端head中提交的token
        String token = containerRequestContext.getHeaderString("Authorization");
        if (StringUtils.isEmpty(token)) {
            //TODO:拦截响应
        }

        //判断该用户是否已登录
    }
}
