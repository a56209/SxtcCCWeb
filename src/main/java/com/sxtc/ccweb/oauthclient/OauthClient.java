package com.sxtc.ccweb.oauthclient;

import com.sun.jersey.api.core.HttpRequestContext;
import org.apache.oltu.oauth2.client.HttpClient;
import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.URLConnectionClient;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.response.OAuthAccessTokenResponse;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.types.GrantType;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestWrapper;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

/**
 * Created by Administrator on 2016/9/6.
 */
@Component
@Path("oauthclient")
public class OauthClient {

    @GET
    @Path("makeauth")
    public Response makeAuthCodeRequest() {

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
        Client client = ClientBuilder.newClient();
        Response response = client.target(ClientParams.OATUH_SERVICE_API).queryParam("access_token", accessToken).request().get();

        System.out.println(response.getStatus());
        System.out.println(response.getEntity().toString());
    }


}

