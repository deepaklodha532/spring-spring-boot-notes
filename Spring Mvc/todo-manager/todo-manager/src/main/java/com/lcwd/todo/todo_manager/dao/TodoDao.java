package com.lcwd.todo.todo_manager.dao;

import com.lcwd.todo.todo_manager.models.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class TodoDao {
    public TodoDao(@Autowired JdbcTemplate template) {
        this.template = template;

        //create table if does not exist
        String createTable = "create table IF NOT EXiSTS todos(id int primary key, title varchar(100) not null, content varchar(500),status varchar(30) not null ,addedDate datetime, todoDate datetime )" ;
        int update=template.update(createTable) ;
        logger.info("Todo table created {}",update);
    }


    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
    Logger logger = LoggerFactory.getLogger(TodoDao.class) ;



    //save todo in data base
    public Todo saveTodo(Todo todo){
        String insertQuery = " insert into todos(id,title, content ,status ,addedDate,todoDate) values(?,?,?,?,?,?) " ;
         int rows=  template.update(insertQuery,todo.getId(),todo.getTitle(),todo.getContent(),todo.getStatus(),todo.getAddedDate(),todo.getTodoDate());
         logger.info("JDBC OPERATION :{} inserted ",rows);
         return  todo ;
    }
    //get single todo from database

    //get all todo from database

    //update todo

    //delete data from data base


}
