package com.sxtc.ccweb.rest;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Created by Administrator on 2016/9/2.
 */
@Component
@Path("testlogin")
public class TestLoginRest {

    @GET
    public Response loginTestOAuth() {
        return Response.status(Response.Status.OK).entity("").build();
    }
}
