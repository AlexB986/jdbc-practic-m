package com.example.hiber.practic.hiber.practic;

import com.example.hiber.practic.hiber.practic.dao.UserDao;
import com.example.hiber.practic.hiber.practic.dao.UserDaoHibernateImpl;
import com.example.hiber.practic.hiber.practic.dao.UserDaoJDBCImpl;
import com.example.hiber.practic.hiber.practic.model.User;
import com.example.hiber.practic.hiber.practic.service.UserService;
import com.example.hiber.practic.hiber.practic.service.UserServiceImpl;
import com.example.hiber.practic.hiber.practic.util.Util;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;
import java.util.List;

import static com.example.hiber.practic.hiber.practic.util.Util.*;

@SpringBootApplication
public class HiberPracticApplication {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl(new UserDaoHibernateImpl());

        /*
         *Hibernet
         */
        userService.createUsersTable();

        Util util = new Util();
        List <User> userList = util.getUser();
        for(User u : userList){
            userService.saveUser(u.getName(),u.getLastName(),u.getAge());
        }
        userService.removeUserById(4);
        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();


        /*
         *jbBC
         */
//        UserServiceImpl userService = new UserServiceImpl(new UserDaoJDBCImpl());

//        userService.createUsersTable();
//
//        Util util = new Util();
//        List<User> userList = util.getUser();
//        for (User u : userList) {
//            userService.saveUser(u.getName(), u.getLastName(), u.getAge());
//
//        }
//        userService.removeUserById(4);
//
//        userService.getAllUsers();
//
//        userService.cleanUsersTable();
//
//        userService.dropUsersTable();

//        SpringApplication.run(HiberPracticApplication.class, args);


    }
}
//https://github.com/AlexB986/jdbc-practic-m.git