package com.sxtc.ccweb.web.filter;


import com.sxtc.ccweb.base.Constants;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.error.OAuthError;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import org.apache.oltu.oauth2.common.message.types.ParameterStyle;
import org.apache.oltu.oauth2.rs.request.OAuthAccessResourceRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Administrator on 2016/9/1.
 */
public class Oauth2Filter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletResponse res = (HttpServletResponse) servletResponse;
        try {
            //构建OAUTH资源请求
//            OAuthAccessResourceRequest oauthRequest = new OAuthAccessResourceRequest((HttpServletRequest) servletRequest, ParameterStyle.QUERY);   //queryString 方法获取参数
//access_token  04cab239-9d11-44a0-af58-742c5f6046da
            OAuthAccessResourceRequest oauthRequest = new OAuthAccessResourceRequest((HttpServletRequest) servletRequest, ParameterStyle.HEADER);   //从httphead头中获取参数
            String accessToken = oauthRequest.getAccessToken();
            System.out.print(accessToken);

            //验证AccessToken
            if (!checkAccessToken(accessToken)) {
                //如果不存在/过期了，返回未验证错误，需重新验证
                oAuthFaileResponse(res);
            }
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (OAuthProblemException e) {
            try {
                oAuthFaileResponse(res);
            } catch (OAuthSystemException e1) {
                e1.printStackTrace();
            }
        } catch (OAuthSystemException e) {

        }
    }

    /**
     * 验证ACCESSTOKEN
     *
     * @param accessToken
     * @return
     * @throws IOException
     */
    private boolean checkAccessToken(String accessToken) throws IOException {
        URL url = new URL(Constants.CHECK_ACCESS_CODE_URL + accessToken);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.disconnect();
        int mycode = connection.getResponseCode();
        return HttpServletResponse.SC_OK == connection.getResponseCode();
    }

    /**
     * oAuth认证失败时的输出
     *
     * @param response
     * @throws OAuthSystemException
     * @throws IOException
     */
    private void oAuthFaileResponse(HttpServletResponse response) throws OAuthSystemException, IOException {
        OAuthResponse oAuthResponse = OAuthResponse.errorResponse(HttpServletResponse.SC_UNAUTHORIZED)
                .setRealm(Constants.RESOURCE_SERVER_NAME)
                .setError(OAuthError.ResourceResponse.INVALID_TOKEN)
                .buildHeaderMessage();
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.add("Content-Type", "application/json;charset=utf-8");
        response.addHeader(OAuth.HeaderType.WWW_AUTHENTICATE, oAuthResponse.getHeader(OAuth.HeaderType.WWW_AUTHENTICATE));
        PrintWriter printWriter = response.getWriter();

        printWriter.write("{\"code\":" + HttpStatus.UNAUTHORIZED.value() + ",\"msg\":" + Constants.INVALID_ACCESS_TOKEN + "}");
        printWriter.flush();
        printWriter.close();

    }

    public void destroy() {

    }
}
