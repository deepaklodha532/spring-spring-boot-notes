package com.deep.example.SpringBootEx.dao;

import com.deep.example.SpringBootEx.models.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jms.JmsProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class TodoDao {



    Logger logger = LoggerFactory.getLogger(TodoDao.class) ;


    private JdbcTemplate template ;

    public TodoDao(@Autowired  JdbcTemplate template ){
        this.template = template  ;
        //create table if does not exists

        String createTable = "create table IF NOT EXISTS todos(id int primary key ,title varchar(100) not null ,content  varchar(500) ,status varchar(10) not null ,  addDate datetime " ;
    }

    public JdbcTemplate getTemplate(){
        return template ;
    }

    public void setTemplate(JdbcTemplate template){
        this.template = template ;
    }

    //save todo in database

    public Todo saveTodo(Todo todo){
         String insertQuerye  ="insert into todos (id  , title ,  content,status,addDate) values(?,?,?,?,?)";
          int rows= template.update(insertQuerye ,   todo.getId() , todo.getTitle(), todo.getContent(), todo.getStatus(), todo.getAddDate()) ;
          logger.info("How many rows effected : {} ", rows);
         return todo;
    }

    //get  single todo from database

    public void  getTodo (int id) {
        String query  = "select * from todos Where id = ? " ;
        Map <String,  Object > todoData  =  template.queryForMap(query,id) ;
        logger.info("TODO :{}", todoData) ;
        Todo todo =  new Todo() ;

        
    }
}
