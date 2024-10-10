package com.lcwd.todo.todo_manager.controllers;

import com.lcwd.todo.todo_manager.models.Todo;
import com.lcwd.todo.todo_manager.services.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/todos")
public class TodoContrller {
    Logger logger = LoggerFactory.getLogger(TodoContrller.class);
    @Autowired
    private TodoService todoServices ;
    Random random = new Random() ;
    // create

    @PostMapping
    public ResponseEntity<Todo> createTodoHandler(@RequestBody Todo todo){
        //create todo
        int id = random.nextInt(9999999);
        todo.setId(id) ;
        //create date with system default current date
        Date currentDate = new Date() ;
        logger.info("Current Date{}",currentDate) ;
        todo.setAddedDate(currentDate);
        logger.info("Create Todo " ) ;
        // call services to create todo
        Todo todo1 =   todoServices.createTodo(todo) ;
        ResponseEntity<Todo> rspTodo  = new ResponseEntity<>(todo1, HttpStatus.CREATED) ;
        return rspTodo ;
    }
    //get all todo  method
    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodoHandler(){
        List<Todo> allTodos =  todoServices.getAllTodos() ;
        return new ResponseEntity<>(allTodos, HttpStatus.OK) ;
    }


   // get todo from id
    @GetMapping("/{todoId}" )
    public  ResponseEntity<Todo> getSingleTodoHandler(@PathVariable int todoId) {
      Todo   todo =    todoServices.getTodo(todoId) ;
        return ResponseEntity.ok(todo) ; 
    }

    // updated todo
    @PutMapping("/{todoId}")
    public ResponseEntity<Todo> updateTodoHandler(@RequestBody Todo todoWithNewDetials,  @PathVariable int todoId  ){

      Todo todo = todoServices.updateTodo(todoId, todoWithNewDetials) ;
      return   ResponseEntity.ok(todo) ;

    }

    //delete the todo
     @DeleteMapping("/{todoId}")
    public ResponseEntity<String> deleteTodo(@PathVariable int todoId){
        todoServices.deleteTodo(todoId);
        return ResponseEntity.ok("TodoSuccessfully deleted") ;
    }
}
