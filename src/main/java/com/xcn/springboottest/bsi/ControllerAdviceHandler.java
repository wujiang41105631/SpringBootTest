package com.xcn.springboottest.bsi;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: xupeng.guo
 * @date: 2019/6/14
 * @description
 */
@RestControllerAdvice
public class ControllerAdviceHandler {


    @ExceptionHandler(value = Exception.class)
    public Object exceptionHandler(Exception e, WebRequest request) {
        Map<String, String> value = new HashMap<>();
        value.put("code", "4000");
        value.put("msg", "跳转错误");
        return value;
    }
}
