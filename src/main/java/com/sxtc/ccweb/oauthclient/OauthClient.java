package com.sxtc.ccweb.oauthclient;

import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.URLConnectionClient;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.response.OAuthAccessTokenResponse;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.types.GrantType;
import org.apache.oltu.oauth2.common.message.types.ResponseType;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
//import javax.ws.rs.client.Client;
//import javax.ws.rs.client.ClientBuilder;
//import javax.ws.rs.client.Entity;
//import javax.ws.rs.core.Form;
import javax.ws.rs.core.Response;

/**
 * Created by Administrator on 2016/9/6.
 */
@Component
@Path("oauthclient")
public class OauthClient {

    /**
     * 获取授权码
     *
     * @return
     */
    @GET
    @Path("makeauth")
    public Response makeAuthCodeRequest() {

        //创建表单、模拟填充表单并提交表单
//        Form form = new Form();
//        form.param("username", ClientParams.USERNAME);
//        form.param("password", ClientParams.PASSWORD);
//        form.param("client_id", ClientParams.CLIENT_ID);
//        form.param("response_type", ResponseType.CODE.toString());
//        form.param("redirect_uri", ClientParams.OAUTH_SERVER_REDIRECT_URL);
//
//        Client client = ClientBuilder.newClient();
//        Response response = client.target(ClientParams.OAUTH_SERVER_URL)
//                .request().post(Entity.form(form));
//
//        System.out.println(response.getStatus());
//
//        try {
//            makeTokenRequestWithAuthCode(response.getEntity().toString());
//        } catch (OAuthSystemException e) {
//            e.printStackTrace();
//        } catch (OAuthProblemException e) {
//            e.printStackTrace();
//        }
//        return response;
        return null;
    }

    /**
     * 根据授权码获取accessToken
     *
     * @param authCode
     * @return
     * @throws OAuthSystemException
     * @throws OAuthProblemException
     */
    private OAuthAccessTokenResponse makeTokenRequestWithAuthCode(String authCode) throws OAuthSystemException, OAuthProblemException {
        OAuthClientRequest request = OAuthClientRequest
                .tokenLocation(ClientParams.OAUTH_SERVER_TOKEN_URL)
                .setClientId(ClientParams.CLIENT_ID)
                .setClientSecret(ClientParams.CLIENT_SECRET)
                .setGrantType(GrantType.AUTHORIZATION_CODE)
                .setCode(authCode)
                .setRedirectURI(ClientParams.OAUTH_SERVER_REDIRECT_URL)
                .buildBodyMessage();

        OAuthClient oAuthClient = new OAuthClient(new URLConnectionClient());

        OAuthAccessTokenResponse oauthResponse = oAuthClient.accessToken(request);

        System.out.println("ACCESS TOKEN:" + oauthResponse.getAccessToken());
        System.out.println("EXPIRES IN:" + oauthResponse.getExpiresIn());

        return oauthResponse;
    }

    /**
     * 测试开放接口服务
     *
     * @param accessToken
     */
    private void getAuthedService(String accessToken) {
//        Client client = ClientBuilder.newClient();
//        Response response = client.target(ClientParams.OATUH_SERVICE_API).queryParam("access_token", accessToken).request().get();

//        System.out.println(response.getStatus());
//        System.out.println(response.getEntity().toString());
    }


}

