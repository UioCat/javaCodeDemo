package com.hanxun.demo.controller.base;

import com.hanxun.demo.utils.ThreadLocalUtils;
import com.hanxun.demo.utils.TokenUtils;

/**
 * @author han xun
 * @date 2021-10-14 09:55
 * @description
 */
public class BaseController {

    /**
     * 获取用户ID
     * @return
     */
    public Long getUserId() {
        return ThreadLocalUtils.getCurrentUser().getId();
    }
}
