package com.deep.example.SpringBootEx.controllers;

import com.deep.example.SpringBootEx.models.Todo;
import com.deep.example.SpringBootEx.services.TodoServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    Logger logger = LoggerFactory.getLogger(TodoController.class) ;

    @Autowired
    private TodoServices todoServices ;
    //create
    @PostMapping
    public ResponseEntity<Todo> createTodoHendler(@RequestBody Todo todo ){
        //create todo
        logger.info("Create Todo ");
        Todo todo1 = todoServices.createTodo(todo) ;
        ResponseEntity<Todo> todoResponse = new ResponseEntity<>(todo1 , HttpStatus.CREATED) ;
        return todoResponse ;
    }

    //all
    @GetMapping
    public ResponseEntity<List<Todo >> getAllTodos (){
        return new ResponseEntity<>(todoServices.getAllTodos(), HttpStatus.OK) ;
    }

    //get single
    @GetMapping("/{todoId}")
    public ResponseEntity<Todo> getSingleTodo(@PathVariable int todoId){
        return new ResponseEntity<>(todoServices.getSingleTodo(todoId), HttpStatus.OK) ;
    }
    //update todo ;
    @PutMapping("/update/{todoId}")
    public ResponseEntity<Todo> updateTodo(@PathVariable int todoId,@RequestBody Todo todo)
    {

      Todo updateTodo =   todoServices.updateTodo(todoId, todo ) ;
      return new ResponseEntity<>(updateTodo, HttpStatus.OK) ;
    }

    //delete todo
    @DeleteMapping("/{todoId}")
    public ResponseEntity<String> deleteTodo(@PathVariable int todoId){
        todoServices.delete(todoId) ;

        return new ResponseEntity<>("deleted" , HttpStatus.OK) ;

    }


}
