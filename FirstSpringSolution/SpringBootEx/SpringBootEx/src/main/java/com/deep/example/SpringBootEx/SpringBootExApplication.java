package com.deep.example.SpringBootEx;

import com.deep.example.SpringBootEx.dao.TodoDao;
import com.deep.example.SpringBootEx.models.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Map;

@SpringBootApplication
public class SpringBootExApplication implements CommandLineRunner {

	@Autowired
	private TodoDao todoDao ;

	Logger logger = LoggerFactory.getLogger(SpringBootExApplication.class)  ;
	public static void main(String[] args) {
		SpringApplication.run(SpringBootExApplication.class, args);
	}

    @Override
	public void run(String...args) throws Exception{
//		System.out.println("application  started");
//		JdbcTemplate template = todoDao.getTemplate() ;
//		logger.info("Template ,  :{}", template) ;
//        logger.info("Template Object {}" ,template.getDataSource());

//		String  query   =  "select * from todos Where id = ? " ;
//		Map<String,  Object > todoData  =  template.queryForMap(query  ,  id)  ;
//
//		logger.info("Todo : {} ",  todoData)  ;
//		Todo todo =  new Todo () ;



	}


}
