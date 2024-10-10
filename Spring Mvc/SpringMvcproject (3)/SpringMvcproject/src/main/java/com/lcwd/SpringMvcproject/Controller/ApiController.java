package com.lcwd.SpringMvcproject.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

//@Controller
@RestController
@RequestMapping("/api")
public class ApiController {

    @RequestMapping(value="hello" ,method= RequestMethod.GET)
//    @ResponseBody
    public String apiHandler() {
        return "hello , how are you " ;
    }
    @RequestMapping(value="/users" , method = RequestMethod.GET)
//    @ResponseBody
    public List<String> getUserData(){
        return Arrays.asList("Ram ", "Shyam", "chikan") ;
    }

    @RequestMapping(value = "/hi" ,method = RequestMethod.POST)
    public String hiHandler(){
        return "this is hi handler" ;
    }

    @RequestMapping(value = "/greet", method = RequestMethod.POST)
    public String greetHandler(){
        return "good morning" ;
    }
}

