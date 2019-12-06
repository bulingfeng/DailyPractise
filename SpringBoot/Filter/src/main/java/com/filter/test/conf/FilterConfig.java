package com.filter.test.conf;

import com.filter.test.filter.MyFilter;
import com.filter.test.filter.TokenAuthorFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author:bulingfeng
 * @Date: 2019-12-06
 */
@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean registFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyFilter());
        registration.addUrlPatterns("/filter/*");
        registration.setName("LogCostFilter");
        registration.setOrder(1);
        return registration;
    }

    @Bean
    public FilterRegistrationBean registFilter2() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new TokenAuthorFilter());
        registration.addUrlPatterns("/filter/test");
        registration.setOrder(2);
        return registration;
    }
}
