package com.lcwd.SpringMvcproject.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
@RestController
public class FeedBackController {

    @GetMapping("/feedback")
    public List<String> getFeedBack() {
        List<String> list = Arrays.asList(
                "good Morning" ,
                "Nice One" ,
                "Valuable thing"
        );
        return list;

    }

    @PostMapping("/create-feedback")
    public List<String> createFeedBack(){
        List<String> list = Arrays.asList(
                "crete good Morning" ,
                "create Nice One" ,
                "create Valuable thing"
        );
        return list;
    }
}
