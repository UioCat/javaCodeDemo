package com.hanxun.demo.controller.req;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author han xun      
 * Date 2021-11-10 14:52   
 * Description  
 */
@ToString
@Getter
@Setter
public class RegisterReq {

    private String telephone;

    private String password;

    private String username;
}
