package com.example.hiber.practic.hiber.practic.dao;

import com.example.hiber.practic.hiber.practic.model.User;
import com.example.hiber.practic.hiber.practic.util.Util;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

import static com.example.hiber.practic.hiber.practic.util.Util.*;

public class UserDaoHibernateImpl implements UserDao {
    Util util = new Util();


    public UserDaoHibernateImpl() {
    }

    /*fixme В этом классе во всех методах отсутствует открытие сессии. Для того, чтобы сессия открылась,
     *  придется открывать сессию в сервисном слое, или в методе main, как например сейчас.
     *  Здесь мы получаем проблему смешивания логики из разных слоев приложения:
     *  Слой dao отвечает за подключение к базе
     *  Слой сервисов отвечает за бизнес-логику
     *  В нашем же случае мы вынуждены в сервисном слое открывать сессию
     *  Session должна открываться в dao
     * */

    @Override
    public void createUsersTable() {
        Session session = util.startSession();
        Query query = session.createNativeQuery(CREATE_TABLE_USER);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void dropUsersTable() {
        Session session = util.startSession();
        Query query = session.createNativeQuery(DROP_TABLE_USER);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void saveUser(String name, String lastName, Integer age) {
        Session session = util.startSession();
        User saveUsers = new User();
        saveUsers.setName(name);
        saveUsers.setLastName(lastName);
        saveUsers.setAge(age);
        session.save(saveUsers);
        session.flush();
        session.getTransaction().commit();
        session.close();
    }


    @Override
    public void removeUserById(long id) {
        Session session = util.startSession();
        User user = session.find(User.class, id);
        session.delete(user);
        session.flush();
        session.clear();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<User> getAllUsers() {
        Session session = util.startSession();
        Query<User> userQuery = session.createNativeQuery(GET_ALL_USERS, User.class);
        List<User> userList = userQuery.list();
        session.getTransaction().commit();
        session.close();
        return userList;
    }

    @Override
    public void cleanUsersTable() {
        Session session = util.startSession();
        Query query = session.createNativeQuery(CLEAR_TABLE);
        session.getTransaction().commit();
        session.close();
    }


}

