package com.example.hiber.practic.hiber.practic;
import com.example.hiber.practic.hiber.practic.dao.UserDaoHibernateImpl;
import com.example.hiber.practic.hiber.practic.model.User;
import com.example.hiber.practic.hiber.practic.service.UserServiceImpl;
import com.example.hiber.practic.hiber.practic.util.Util;
import org.hibernate.Session;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;

@SpringBootApplication
public class HiberPracticApplication {
    public static void main(String[] args) {
        Util util = new Util();
        Session session = util.startSession();
        UserServiceImpl userService = new UserServiceImpl(new UserDaoHibernateImpl(session));

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

        util.endSession(session);


    }
}
