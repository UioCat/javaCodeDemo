package com.hanxun.demo.controller;

import com.hanxun.demo.utils.TokenUtils;

/**
 * @author han xun
 * @date 2021-10-14 09:55
 * @description
 */
public class BaseController {

    // todo 在AOP中 直接获取到 http header上的token进行解析存放到 ThreadLocal
    /**
     * 根据用户ID生成一个token
     * @param id
     * @return
     */
    public String getToken(Long id) {
        return TokenUtils.getToken(id);
    }

    /**
     * 获取用户ID
     * @return
     */
    public Long getUserId(String token) {
        return TokenUtils.getIdAndVerify(token);
    }
}
