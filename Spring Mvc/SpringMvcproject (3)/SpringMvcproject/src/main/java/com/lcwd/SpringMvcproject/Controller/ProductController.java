package com.lcwd.SpringMvcproject.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    Logger logger = LoggerFactory.getLogger(ProductController.class) ;
    @GetMapping("/getProduct")
    public void getProducts(
            @RequestParam("productname" )String name ,
            @RequestParam(value="productrating",defaultValue = "0", required = false) int rating ,
            @RequestParam("productprice") int price

    ){
        System.out.println("product name " +name);
        System.out.println("product rating "+rating);
        System.out.println("product price " +price)  ;
    }

    @GetMapping("/getproduct2/{productname}/{productrating}/{productprice}")
    public String getProduct2(
            @PathVariable("productname") String name ,
            @PathVariable("productrating") int rating,
            @PathVariable("productprice") int price

    ){
//        System.out.println(name);
//        System.out.println(rating);
//        System.out.println(price);
        logger.error("productName "+ name);
        logger.warn("rating "+rating);
        logger.info("price" +price);
        return "this is checking the concept of path variable " ;
    }
}
