package com.lcwd.todoapplicationjdbc.TodoApplication.dao;

import com.lcwd.todoapplicationjdbc.TodoApplication.helper.Helper;
import com.lcwd.todoapplicationjdbc.TodoApplication.model.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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


    //save todo on data base  or create todo

    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    //create todo
    public Todo saveTodo(Todo todo) {
        String insertQueury = "insert into todos(id , title,content ,  status,addedDate,todoDate) values(?,?,?,?,?,?)" ;
        int rowsA =  template.update(insertQueury, todo.getId(),todo.getTitle(),todo.getContent(),todo.getStatus(),todo.getAddedDate(), todo.getTodoDate());
        logger.info("Jdbc OPERATION  ROWS : {} inserted ", rowsA) ;
        return todo ;
    }

    //get single todo from database
     public  Todo getTodo(int id) throws ParseException {
        String query = "select * from todos WHERE id=?" ;
        Map<String,Object> todoData =  template.queryForMap(query,id);
        logger.info("TODO :{}",todoData);

         Todo todo = new Todo( ) ;
         todo.setId((int)todoData.get("id"));
         todo.setTitle((String)todoData.get("title"));
         todo.setContent((String)todoData.get("content"));
         todo.setStatus((String)todoData.get("status"));
         todo.setTodoDate(Helper.parseDate((LocalDateTime)todoData.get("addedDate")));
         todo.setTodoDate(Helper.parseDate((LocalDateTime)todoData.get("todoDate")));

         return todo ;
     }

     //get all todos

    public List<Todo> getAllTodos(){
        String query = "select * from todos" ;
        List<Map<String,Object>> maps = template.queryForList(query)  ;

        List<Todo> todos =   maps.stream().map((map)->{

             Todo todo = new Todo( ) ;
             todo.setId((int)map.get("id"));
             todo.setTitle((String)map.get("title"));
             todo.setContent((String)map.get("content"));
             todo.setStatus((String)map.get("status"));
             try {
                 todo.setTodoDate(Helper.parseDate((LocalDateTime)map.get("addedDate")));
                 todo.setTodoDate(Helper.parseDate((LocalDateTime)map.get("todoDate")));

             } catch (ParseException e) {
                 throw new RuntimeException(e);
             }
             return todo;
         }).collect(Collectors.toList());

        return  todos;
    }

    //update todo

    public Todo updateTodo (int id ,  Todo newTodo) {

        String query = "update todos set title= ?,content=?, status=?, addedDate=? ,todoDate=? where id=?";

        int update =   template.update(query , newTodo.getTitle(),newTodo.getContent(),newTodo.getStatus(),newTodo.getAddedDate(),newTodo.getTodoDate(),id) ;
        logger.info("updated :{}",update);
        newTodo.setId(id);
        return newTodo;
    }


}
