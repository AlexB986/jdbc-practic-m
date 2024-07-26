package com.example.hiber.practic.hiber.practic;

import com.example.hiber.practic.hiber.practic.dao.UserDaoHibernateImpl;
import com.example.hiber.practic.hiber.practic.model.User;
import com.example.hiber.practic.hiber.practic.service.UserServiceImpl;
import com.example.hiber.practic.hiber.practic.util.StartSession;
import com.example.hiber.practic.hiber.practic.util.Util;
import org.hibernate.Session;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class HiberPracticApplication {
    public static void main(String[] args) {
        final Util util = new Util();
        /*fixme Теперь SessionFactory создается только 1 раз, но если вызвать startSession()
         *  в другой части кода - мы получаем ту же самую проблемму: появляется 2 и более SessionFactory.
         *  Ответственность класса Util - следить за тем, чтобы SessionFactory была только одна
         */
        UserServiceImpl userService = new UserServiceImpl(new UserDaoHibernateImpl());

        /*
         *Hibernet
         */
        userService.createUsersTable();

        List<User> userList = util.getUser();
        for (User u : userList) {
            userService.saveUser(u.getName(), u.getLastName(), u.getAge());
        }
        userService.removeUserById(4);

        userService.getAllUsers();


        userService.cleanUsersTable();

        userService.dropUsersTable();

        userService.endSession();


    }
}
