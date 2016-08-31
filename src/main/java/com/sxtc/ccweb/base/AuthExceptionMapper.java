package com.sxtc.ccweb.base;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by Administrator on 2016/8/31.
 */
@Provider
public class AuthExceptionMapper implements ExceptionMapper<AuthorizationException> {
    public Response toResponse(AuthorizationException e) {
        return Response.ok(e.getResponse()).build();
    }
}
