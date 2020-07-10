package com.sly.webrtcserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author SLY
 * @description TODO
 * @date 2020/7/10
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(HttpServletRequest request, String userId) {
        request.setAttribute("userId", userId);
        return "index.html";
    }
}
