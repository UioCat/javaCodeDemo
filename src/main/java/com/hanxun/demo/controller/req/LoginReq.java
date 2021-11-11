package com.hanxun.demo.controller.req;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author han xun      
 * Date 2021-11-10 15:05   
 * Description  
 */
@ToString
@Setter
@Getter
public class LoginReq {

    private String telephone;

    private String password;
}
