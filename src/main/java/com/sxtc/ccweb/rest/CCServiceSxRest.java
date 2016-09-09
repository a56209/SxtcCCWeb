package com.sxtc.ccweb.rest;

import com.sxtc.ccweb.model.CCServiceSx;
import com.sxtc.ccweb.service.impl.CCServiceSxServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Administrator on 2016/9/9.
 */
@Component
@Path("ccssx")
public class CCServiceSxRest {

    @Autowired
    private CCServiceSxServiceImpl ccServiceSxService;

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.TEXT_HTML})
    public Response createNewSxServiceInfo(@RequestBody CCServiceSx ccServiceSx) {
        ccServiceSxService.addCCService(ccServiceSx);
        return Response.status(Response.Status.OK).entity("记录增加成功").build();
    }
}
