package com.hanxun.demo.controller.base;

import com.hanxun.demo.common.BackEnum;
import com.hanxun.demo.common.CustomException;
import com.hanxun.demo.utils.ThreadLocalUtils;

/**
 * @author han xun
 * Date 2021-10-14 09:55
 * Description 基础Controller
 */
public class BaseController {

    /**
     * 获取用户ID
     * @return
     */
    public Long getUserId() {
        UserToken currentUser = ThreadLocalUtils.getCurrentUser();
        if (currentUser == null) {
            throw new CustomException(BackEnum.UNAUTHORIZED);
        }
        return currentUser.getId();
    }
}
