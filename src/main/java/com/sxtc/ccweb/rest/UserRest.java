package com.sxtc.ccweb.rest;

import com.sxtc.ccweb.model.User;
import com.sxtc.ccweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.FieldRetrievingFactoryBean;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Administrator on 2016/8/27.
 */
@Component
@Path("user")
public class UserRest {

    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String userTest() {
        return "OK";
    }

    @Autowired
    UserService userService;

    @GET
    @Path("/query")
    @Produces(MediaType.TEXT_PLAIN)
    public String queryUser() {
        List<User> datas=userService.findUsers();
        String dataStr=datas.size()+"--";
        for (User user : datas){
            dataStr+=user.getUserId()+","+user.getUserName()+","+user.getUserPwd()+"---";
        }
        return  dataStr;
    }

}
