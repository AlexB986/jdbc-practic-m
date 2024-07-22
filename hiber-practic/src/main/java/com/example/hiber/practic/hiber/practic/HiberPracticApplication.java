package com.example.hiber.practic.hiber.practic;

import com.example.hiber.practic.hiber.practic.dao.UserDao;
import com.example.hiber.practic.hiber.practic.dao.UserDaoJDBCImpl;
import com.example.hiber.practic.hiber.practic.service.UserService;
import com.example.hiber.practic.hiber.practic.service.UserServiceImpl;
import com.example.hiber.practic.hiber.practic.util.Util;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

import static com.example.hiber.practic.hiber.practic.util.Util.*;

@SpringBootApplication
public class HiberPracticApplication {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoJDBCImpl();

		userDao.createUsersTable();

//		userDao.dropUsersTable();
//		userDao.saveUser("Anna","Zaic", 13);

//        userDao.removeUserById(4);
//		userDao.getAllUsers();
//		userDao.cleanUsersTable();

//		UserServiceImpl userService = new UserServiceImpl();???????
//		userService.createUsersTable();????????


//		SpringApplication.run(HiberPracticApplication.class, args);
    }
}
