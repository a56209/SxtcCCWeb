package com.sxtc.ccweb.rest;

import com.sun.jersey.api.view.Viewable;
import com.sxtc.ccweb.model.User;
import com.sxtc.ccweb.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2016/9/8.
 */
@Component
@Path("login")
public class LoginRest {

    @Autowired
    private UserServiceImpl userService;

    /**
     * 验证用户登录信息，并返回授权码
     *
     * @return
     */
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response verifyLogin(@FormParam("userName") String userName, @FormParam("userPwd") String userPwd) {
        User user = new User();
        user.setUserName(userName);
        user.setUserPwd(userPwd);
        List<User> users = userService.findUserByData(user);
        boolean isVerify = false;
        if (users.size() > 1) {
            //有重复的登录账户
        } else if (users.size() < 1) {
            //未找到登录的账号
        } else {
            User sUser = users.get(0);
            if (sUser.getUserName().equals(user.getUserName()) && sUser.getUserPwd().equals(user.getUserPwd())) {
                //获取授权信息
                isVerify = true;
            } else {
                //账号验证失败
            }
        }
        return null;

    }

}


