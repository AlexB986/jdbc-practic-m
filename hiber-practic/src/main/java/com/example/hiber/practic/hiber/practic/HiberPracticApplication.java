package com.example.hiber.practic.hiber.practic;

import com.example.hiber.practic.hiber.practic.dao.UserDao;
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
        /*fixme
         *  Как я понял, здесь вопрос в том, что работает код с использованием UserDao, но не работает через UserService:
         *  Проблема в том что мы здесь не используем Spring, а значит, мы сами должны позаботиться о том, чтобы все классы получили свои зависимости.
         *  В классе UserServiceImpl есть зависимость - объект UserDao, с помощью которого совершаются все операции. При создании
         * объекта UserServiceImpl мы создаем сам объект, но не передаем ему объект UserDao, вследстие чего внутри сервиса
         * dao будет null. Нужно передать UserDao при создании объекта UserServiceImpl, через конструктор или сеттер.
         *  Spring решает эту проблему внедрения зависимостей за нас, но мы будем его использовать в последующих задачах.
         * Если интересно, как внедрить зависимости с помощью Spring, можно посмотреть про аннотации @Component и @Autowired
         * */
        UserServiceImpl userService = new UserServiceImpl(new UserDaoJDBCImpl());


        userService.createUsersTable();

        Util util = new Util();
        List<User> userList = util.getUser();
        for (User u : userList) {
            userService.saveUser(u.getName(), u.getLastName(), u.getAge());

        }
        userService.removeUserById(4);

        userService.getAllUsers();

        userService.cleanUsersTable();

        userService.dropUsersTable();



    }
}
//https://github.com/AlexB986/jdbc-practic-m.git