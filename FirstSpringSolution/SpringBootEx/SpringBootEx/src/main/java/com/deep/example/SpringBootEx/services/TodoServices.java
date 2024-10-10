package com.deep.example.SpringBootEx.services;
import java.util.*;
import java.util.stream.Collectors;

import com.deep.example.SpringBootEx.models.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
public class TodoServices {

    Logger logger = LoggerFactory.getLogger(TodoServices.class) ;
    List<Todo> todos= new ArrayList<>() ;

    Random random = new Random() ;
    //create todo method
    public Todo createTodo(Todo todo ){
        //create ...
        logger.info("{}",todo);
         int id = random.nextInt(999999999);
         Date date = new Date() ;
         todo.setId(id) ;
         todo.setAddDate(date);
         todos.add(todo)  ;
         return  todo;
    }


    public List<Todo> getAllTodos(){
        return todos;
    }

    //get todo from userId

    public Todo getSingleTodo(int todoId) {

       Todo todo= todos
                .stream()
                .filter(t->todoId==t.getId()).findAny().get();

        logger.info("{}" ,todo);

       return todo;
    }

    //updated todo
    public Todo updateTodo(int todoId, Todo todo  ){
        List<Todo> newUpdateTodos= todos.stream()
//                .filter(t->todoId == t.getId()).findAny().get();
        .map((t)->{
            if(t.getId() == todoId){
                return  todo ;
            }
            else{
                return  t;
            }
        }).collect(Collectors.toList());
        todos = newUpdateTodos;
        todo.setId(todoId) ;

        return  todo;
    }

    //delete todo
    public void delete(int  todoId){
        List<Todo> newList =todos.stream().filter(t-> t.getId()!=todoId).collect(Collectors.toList());

        todos = newList;


    }

}
