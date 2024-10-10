package com.lcwd.SpringMvcproject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
    @RequestMapping("/login")
    public String  showLoginPageHandler (){
        System.out.println("this is login page");
        return "login" ;
    } ;
}
