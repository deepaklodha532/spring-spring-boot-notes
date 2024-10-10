package com.lcwd.todoapplicationjdbc.TodoApplication;

import com.lcwd.todoapplicationjdbc.TodoApplication.dao.TodoDao;
import com.lcwd.todoapplicationjdbc.TodoApplication.model.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;


@SpringBootApplication
public class TodoApplication implements CommandLineRunner {
	Logger logger = LoggerFactory.getLogger(
			TodoApplication.class
	) ;
	@Autowired
    private TodoDao todoDao ;
	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Todo todo = new Todo() ;
//		todo.setId(223) ;
//		todo.setTitle("this is deepak  bhao ");
//		todo.setContent("this is content");
//		todo.setStatus("wow awesome status ");
//		todo.setAddedDate(new Date());
//		todo.setTodoDate(new Date());

	//	todoDao.saveTodo(todo) ;
		Todo todo = todoDao.getTodo(123) ;
		logger.info("TODO :{}",todo);
	}
}
