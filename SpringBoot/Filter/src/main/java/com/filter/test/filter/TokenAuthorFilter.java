package com.filter.test.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author:bulingfeng
 * @Date: 2019-12-06
 */
@Slf4j
public class TokenAuthorFilter implements Filter {
    /**
     * 拦截器的执行逻辑
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("开始调用TokenAuthorFilter");
        filterChain.doFilter(servletRequest,servletResponse);
        log.info("调用TokenAuthorFilter结束");
    }
}
