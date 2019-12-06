package com.filter.test.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author:bulingfeng
 * @Date: 2019-12-06
 */
@Slf4j
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("开始请求filter");
        filterChain.doFilter(servletRequest,servletResponse);
        log.info("请求filter结束");
    }
}
