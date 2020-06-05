package com.example.Filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author mingyi
 * 网关拦截器
 *
 */
@Component
@Slf4j
public class WebServiceFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String contextPath = request.getRequestURI();
        String authType = request.getAuthType();
        Enumeration<String> headers = request.getHeaders("Authorization");
        log.info("contextPath: "+contextPath);
        log.info("authType: "+authType);
        log.info("headers: "+headers);
        //登录获取token接口放行其他请求拦截
        String url= "authservice/oauth/token";
        if (url.equals(contextPath)){
            return null;
        }
        String token=request.getParameter("access_token");
        if(token==null){
            //非法请求跳转登录页
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(401);
            HttpServletResponse httpServletResponse = currentContext.getResponse();
            httpServletResponse.setContentType("text/html;charset=utf-8");
            try {
                httpServletResponse.getWriter().write("请登录后再访问");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
