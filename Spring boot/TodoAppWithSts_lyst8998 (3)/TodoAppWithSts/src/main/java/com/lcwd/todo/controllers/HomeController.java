package com.lcwd.todo.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.todo.models.Todo;

@RestController
public class HomeController {

	// /todos
	@RequestMapping("/todos")
	public List<Todo> getTodos() {

		List<Todo> todos = Arrays.asList(new Todo(12, "Learn Python "), new Todo(13, "learn Django")

		);

		return todos;
	}
}
