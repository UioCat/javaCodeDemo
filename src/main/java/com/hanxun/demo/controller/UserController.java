package com.hanxun.demo.controller;

import com.github.pagehelper.Page;
import com.hanxun.demo.common.BackEnum;
import com.hanxun.demo.common.BackMessage;
import com.hanxun.demo.controller.base.BaseController;
import com.hanxun.demo.controller.req.LoginReq;
import com.hanxun.demo.controller.req.RegisterReq;
import com.hanxun.demo.entity.UserDO;
import com.hanxun.demo.manager.UserDOManager;
import com.hanxun.demo.utils.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author han xun      
 * Date 2021-11-10 14:19   
 * Description  
 */
@RestController
@Slf4j
public class UserController extends BaseController {

    @Autowired
    private UserDOManager userDOManager;

    /**
     * 注册用户
     * @param registerReq
     * @return
     */
    @PostMapping("/register")
    public BackMessage<Void> register(@RequestBody RegisterReq registerReq) {
        UserDO userDO = new UserDO();
        userDO.setTelephone(registerReq.getTelephone());
        userDO.setUsername(registerReq.getUsername());
        userDO.setPassword(registerReq.getPassword());
        userDOManager.insertOrUpdate(userDO);
        return BackMessage.success();
    }

    /**
     * 用户登陆
     * @param loginReq
     * @return
     */
    @PostMapping("/login")
    public BackMessage<String> login(@RequestBody LoginReq loginReq) {
        UserDO userDo = userDOManager.getUserDo(loginReq.getTelephone());
        if (userDo.getPassword().endsWith(loginReq.getPassword())) {
            return BackMessage.success(TokenUtils.getToken(userDo.getId()));
        }
        return new BackMessage<>(BackEnum.PWD_ERROR);
    }

    /**
     * 查询其他用户
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/query")
    public BackMessage<Page<UserDO>> query(@RequestParam("pageNum") Integer pageNum,
                             @RequestParam("pageSize") Integer pageSize) {
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize > 100 ? 100 : pageSize;
        Long userId = super.getUserId();
        log.info("get user info, userId:{}", userId);
        Page<UserDO> userDOPage = userDOManager.queryByPage(pageNum, pageSize);
        return BackMessage.success(userDOPage);
    }

}
