package com.sxtc.ccweb.base;

/**
 * Created by Administrator on 2016/8/31.
 */
public class AuthorizationException extends RuntimeException {

    // private String response= ErrorCode.NOT_AUTHED.getMsg();
    private String response = "";

    public String getResponse() {
        return this.response;
    }
}
