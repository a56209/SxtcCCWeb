package com.sxtc.ccweb.rest;

import com.sxtc.ccweb.model.User;
import com.sxtc.ccweb.redis.service.AgentStatusService;
import com.sxtc.ccweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by Administrator on 2016/8/27.
 */
@Component
@Path("user")
public class UserRest {

    @Autowired
    AgentStatusService agentStatusService;

    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String userTest() {
        //AgentStatusInfo agentStatusInfo = new AgentStatusInfo(1, 2, "测试");
        //agentStatusService.saveStatus(agentStatusInfo);
        //return "OK";
        // return agentStatusService.getAgentDetailInfo("1").toString();
        agentStatusService.deleteAgentInfo("1");
        return "OK";
    }

    @Autowired
    UserService userService;

    @GET
    @Path("/query")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<User> queryUser() {
        List<User> datas = userService.findUsers();
        return datas;
    }

    @GET
    @Path("{userid}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response findById(@PathParam("userid") Integer userid) {
        User userinfo = userService.findUserById(userid);
        return Response.status(200).entity(userinfo).build();
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
    //{"userId":"0","userName":"程小尧","userPwd":"sz@88931600"}

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_HTML)
    @Transactional
    public Response updateUserInfo(@RequestBody User user) {
        userService.updateUserInfo(user);
        return Response.status(201).entity("更新成功!").build();
    }

    @PUT
    @Path("{userid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_HTML)
    public Response updateUserInfo(@PathParam("userid") Integer userid, @RequestBody User user) {
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
}
