package com.lcwd.orm;


import com.lcwd.orm.entity.Address;
import com.lcwd.orm.entity.Student;
import com.lcwd.orm.services.LaptopRepository;
import com.lcwd.orm.services.StudentReository;
import com.lcwd.orm.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class LearnSpringOrmApplication implements CommandLineRunner {


    Logger logger = LoggerFactory.getLogger(LearnSpringOrmApplication.class) ;
	@Autowired
	private LaptopRepository laptopRepository ;
	@Autowired
	private StudentReository studentReository ;
	@Autowired
	private UserService userService ;
	public static void main(String[] args) {
		SpringApplication.run(LearnSpringOrmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		User user = new User() ;
//		user.setName("aneesha");
//		user.setCity("guna");
//		user.setAge(20) ;
//		User savedUser = userService.saveUser(user) ;
//		logger.info("saved user : {}" ,savedUser.getId() );
//
//		List<User> users= userService.getAllUser();
//		logger.info("size Is : {}", users.size());
//
//		for (User user :users ){
//
//			logger.info("{}",user);
//		}

//		User user = userService.getUser(2) ;
//		logger.info("{}",user);

//		User user = new User() ;
//		user.setName("laxmi");
//		user.setCity("guna");
//		user.setAge(16);
//		User userUpdated = userService.updateUser(user, 2) ;
//	    logger.info("{}",userUpdated.getId());

//		userService.deleteUser(2);
//---------------------------------------------------
		// OneToOne mapping
//		Student student =  new Student();
//		student.setStudentId(14);
//		student.setStudentName("maneesha");
//		student.setAbout("i bought a laptop ");
//
//
//
//		Laptop laptop = new Laptop() ;
//		laptop.setLaptopId(1231);
//		laptop.setBrand("HP");
//		laptop.setModelNumber("92399");
//
//		//important
//		laptop.setStudent(student);
//		student.setLaptop(laptop) ;
//
//		//manually laptop ko save karo
//		//laptop repository
//
//		Student save = studentReository.save(student) ;
//		logger.info("saved student : {}",save.getStudentId());

//		Student student = studentReository.findById(14).get();
//        logger.info("Name is {} ", student.getStudentName());
//
//		Laptop laptop = student.getLaptop() ;
//		logger.info("Laptop :{} {}",laptop.getBrand(),laptop.getModelNumber());
//------------------------------------
		// one to many

		Student student = new Student() ;
		student.setStudentName("ravi tiwari " );
		student.setAbout("i am software engineer");
		student.setStudentId(131);

		List<Address> list = new ArrayList<>() ;

		Address  a1 = new Address() ;
		a1.setAddressId(131);
		a1.setStreet("253/234");
		a1.setCity("guna");
		a1.setCountry("india");
        a1.setStudent(student);
		list.add(a1) ;

		Address a2 = new Address() ;
		a2.setAddressId(133);
		a2.setStreet("42/43");
		a2.setCity("pune");
		a2.setCountry("usa");
		a2.setStudent(student);

		list.add(a2) ;
		student.setAddressList(list);
		Student save = studentReository.save(student) ;
		logger.info("Student created : with address !");
	}
}

