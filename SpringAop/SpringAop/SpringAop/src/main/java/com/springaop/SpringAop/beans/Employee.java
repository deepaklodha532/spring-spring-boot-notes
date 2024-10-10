package com.springaop.SpringAop.beans;


import org.springframework.stereotype.Component;

@Component
public class Employee {

    public Employee(){
        System.out.println("Employee created");
    }

    public void work(){
        System.out.println("Employee is working ");
     }
}
