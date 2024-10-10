package com.deep.example.SpringBootEx.models;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Todo {
    private int id ;
    private String title ;
    private String content ;
    private String status ;
    private Date addDate ;
}
