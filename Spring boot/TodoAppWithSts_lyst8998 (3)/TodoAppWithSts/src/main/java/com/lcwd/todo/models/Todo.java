package com.lcwd.todo.models;

public class Todo {

	private int id;
	private String todo;
	
	

	public Todo() {
	
	}

	public Todo(int id, String todo) {
		super();
		this.id = id;
		this.todo = todo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTodo() {
		return todo;
	}

	public void setTodo(String todo) {
		this.todo = todo;
	}

}
