package com.lcwd.orm.services;

import com.lcwd.orm.entity.User;
import com.lcwd.orm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface UserService  {

     User saveUser(User user) ;

     User updateUser(User user,  int userId) ;

     void deleteUser(int userId);

     List<User> getAllUser()  ;

     User getUser(int userId) ;
}
