package com.nowcoder.community.controller.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lh on 2022/8/12
 */
@Component
public class TestInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(TestInterceptor.class);

    //在Controller之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.debug("preHandle"+handler.toString());
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    //在Controller之后
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.debug("postHandle"+handler.toString());
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    //在TemplateEngine之后执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.debug("afterCompletion"+handler.toString());
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
