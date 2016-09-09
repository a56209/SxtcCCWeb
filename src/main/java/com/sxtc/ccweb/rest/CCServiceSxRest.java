package com.sxtc.ccweb.rest;

import com.sxtc.ccweb.model.CCServiceSx;
import com.sxtc.ccweb.service.impl.CCServiceSxServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.*;
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

    /**
     * 更新将话务语音相关数据
     *
     * @param ccServiceSx
     * @return
     */
    @PUT
    @Path("vocinfo")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.TEXT_HTML})
    public Response updateServiceVocInfo(@RequestBody CCServiceSx ccServiceSx) {
        ccServiceSxService.updateCCServiceVocInfo(ccServiceSx);
        return Response.status(Response.Status.OK).entity("更新录音数据成功").build();
    }

    /**
     * 更新将话务结束数据补全
     *
     * @param ccServiceSx
     * @return
     */
    @PUT
    @Path("callend")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.TEXT_HTML})
    public Response updateServiceByCallEnd(@RequestBody CCServiceSx ccServiceSx) {
        ccServiceSxService.updateCCServiceEndInfo(ccServiceSx);
        return Response.status(Response.Status.OK).entity("通话结束更新数据成功").build();
    }


}
