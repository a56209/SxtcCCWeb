package com.sxtc.ccweb.rest;

import com.sxtc.ccweb.model.User;
import com.sxtc.ccweb.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by Administrator on 2016/9/1.
 */

@Component
@Path("openapi")
public class OpenApiRest {

    @Autowired
    public UserServiceImpl userService;

    @GET
    @Path("/query")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<User> queryUser() {
        List<User> datas = userService.findUsers();
        return datas;
    }

    @POST
    @Path("/query")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<User> queryUserPost() {
        List<User> datas = userService.findUsers();
        return datas;
    }

    @GET
    @Path("{userid}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response findById(@PathParam("userid") Integer userid) {
        User userinfo = userService.findUserById(userid);
        return Response.status(Response.Status.OK).entity(userinfo).build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.TEXT_HTML})
    public Response createUserInfo(@RequestBody User user) {
        userService.addUserInfo(user);
        return Response.status(201).entity("添加成功!").build();
    }
    //     /SxCCWeb/user
    //Content-Type:application/json
    //{"userId":"0","userName":"程小尧","userPwd":"123456"}

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_HTML)
    @Transactional
    public Response updateUserInfo(@RequestBody User user) throws Exception {
        userService.updateUserInfo(user);
        return Response.status(201).entity("更新成功!").build();
    }

    @PUT
    @Path("{userid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_HTML)
    public Response updateUserInfo(@PathParam("userid") Integer userid, @RequestBody User user) throws Exception {
        if (userid < 0)
            return Response.noContent().build();
        userService.updateUserInfo(user);
        return Response.status(201).entity("更新成功!").build();
    }

    @DELETE
    @Path("{userid}")
    @Produces(MediaType.TEXT_HTML)
    public Response deleteUserInfo(@PathParam("userid") Integer userId) {
        userService.deleteUserInfo(userId);
        return Response.status(Response.Status.NO_CONTENT).entity("删除成功!").build();
    }

    @PUT
    @Path("trans")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_HTML)
    public Response updateUserInfos(@RequestBody List<User> users) throws Exception {
        userService.updateUserInfos(users);
        return Response.status(200).entity("批量更新成功!" + users.size()).build();
    }

}
