package cn.woukfun.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    //使用方法跳转到后台首页
    @RequestMapping("/login")
    public String login() {
        return "home/main";
    }

    //让后台首页Daohome
    @RequestMapping("/home")
    public String home() {
        return "home/home";
    }
}
