package com.sxtc.ccweb.oauthclient;

public class ClientParams {

    public static final String CLIENT_ID = "c1ebe466-1cdc-4bd3-ab69-77c3561b9dee";    //应用ID CLIENT_ID

    public static final String CLIENT_SECRET = "d8346ea2-6017-43ed-ad68-19c0f971738b"; // 应用secret CLIENT_SECRET

    public static final String USERNAME = "admin";   //用户名

    public static final String PASSWORD = "123456";   //密码

    public static final String OAUTH_SERVER_URL = "http://localhost:8080/SxCCWeb/authorize";  //授权地址

    public static final String OAUTH_SERVER_TOKEN_URL = "http://localhost:8080/SxCCWeb/accessToken";   //ACCESS_TOKENH换取地址

    public static final String OAUTH_SERVER_REDIRECT_URL = "http://localhost:8080/SxCCWeb"; //回调地址

    public static final String OATUH_SERVICE_API = "http://localhost:8080/SxCCWeb/openapi/query";  //测试开放数据API

}
