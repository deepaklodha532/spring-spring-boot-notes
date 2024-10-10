package com.lcwd.todo.todo_manager.dao;

import com.lcwd.todo.todo_manager.models.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class TodoDao {

    Logger logger = LoggerFactory.getLogger(TodoDao.class) ;

    private JdbcTemplate template ;
    public TodoDao(@Autowired JdbcTemplate template) {
        this.template = template ;
        //create table does not exists
        String createTable  = "create table IF NOT EXISTS todos(id int, title varchar(200) not null , content varchar(500), status varchar(10) not null , addedDate  datetime,todoDate datetime" ;
         template.update(createTable) ;
         logger.info("TODO TABLE CREATED");
    }

    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    //save todo on data base  or create todo

    public Todo saveTodo(Todo todo) {
        String insertQueury = "insert into todos(id , title,content ,  status,addedDate,todoDate) values(?,?,?,?,?,?)" ;
        int rowsA =  template.update(insertQueury, todo.getId(),todo.getTitle(),todo.getContent(),todo.getStatus(),todo.getAddedDate(), todo.getTodoDate());
        logger.info("Jdbc OPERATION  ROWS : {} inserted ", rowsA) ;
        return todo ;
    }


}
