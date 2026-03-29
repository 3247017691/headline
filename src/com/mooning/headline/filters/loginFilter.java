package com.mooning.headline.filters;

import com.mooning.headline.common.Result;
import com.mooning.headline.common.ResultCodeEnum;
import com.mooning.headline.util.JwtHelper;
import com.mooning.headline.util.WebUtil;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("/headline/*")
public class loginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String token = request.getHeader("token");


        boolean flag = null != token && (!JwtHelper.isExpiration(token));

        if (flag){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            WebUtil.writeJson(response, Result.build(null, ResultCodeEnum.NOTLOGIN));
        }
    }
}
