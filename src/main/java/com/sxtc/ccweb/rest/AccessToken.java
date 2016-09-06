package com.sxtc.ccweb.rest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Administrator on 2016/9/1.
 */
@Component
@Path("accesstoken")
public class AccessToken {

    @POST
    @Path("/checkAccessToken")
    @Produces({MediaType.TEXT_PLAIN})
    public Response checkAccessToken(@RequestParam("accessToken") String accessToken) {
        return Response.status(Response.Status.OK).entity("OK").build();    //HttpStatus.valueOf(HttpServletResponse.SC_OK)
    }


}
