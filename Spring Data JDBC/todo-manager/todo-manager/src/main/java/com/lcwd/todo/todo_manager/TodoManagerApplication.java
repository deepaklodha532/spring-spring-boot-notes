package com.lcwd.todo.todo_manager;

import com.lcwd.todo.todo_manager.dao.TodoDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class TodoManagerApplication  {

//	Logger logger = LoggerFactory.getLogger(TodoManagerApplication.class);
//    @Autowired
//	private TodoDao todoDao  ;
	public static void main(String[] args) {
		SpringApplication.run(TodoManagerApplication.class, args);
	}


//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println("application  started   ");
//		System.out.println(todoDao.getTemplate()) ;
//		JdbcTemplate template = todoDao.getTemplate();
//		logger.info("Template object  : {} ",template) ;
//
//	}
}
