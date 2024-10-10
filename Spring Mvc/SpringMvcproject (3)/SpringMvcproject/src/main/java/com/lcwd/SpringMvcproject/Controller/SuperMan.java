package com.lcwd.SpringMvcproject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//@Component
//@RequestMapping
@Controller
public class SuperMan {
//    @RequestMapping is used for mapping the url with method
    @RequestMapping("/about")
    public String aboutRequestHandler(){
        System.out.println("proccessing about request");
       return "About" ;
   }

   @RequestMapping("contact")
    public String contactRequestHandler() {
       System.out.println("proccessing contact request ");
       return  "Contact";

   }
}
