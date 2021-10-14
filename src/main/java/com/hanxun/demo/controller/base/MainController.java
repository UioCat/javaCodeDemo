package com.hanxun.demo.controller.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author han xun
 * @date 2021-10-14 09:56
 * @description
 */
@Controller
public class MainController {

    @GetMapping("/check")
    public @ResponseBody String check() {
        return "success";
    }
}
