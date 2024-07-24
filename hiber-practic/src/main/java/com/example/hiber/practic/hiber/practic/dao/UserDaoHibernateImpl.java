package com.example.hiber.practic.hiber.practic.dao;

import com.example.hiber.practic.hiber.practic.model.User;
import com.example.hiber.practic.hiber.practic.util.Util;
//import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;


import java.util.ArrayList;
import java.util.List;

import static com.example.hiber.practic.hiber.practic.util.Util.*;

public class UserDaoHibernateImpl implements UserDao {
    Util util = new Util();

    public UserDaoHibernateImpl() {

    }


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
        Query query = session.createNativeQuery(INSERT_USER);
        query.setParameter(1, name);
        query.setParameter(2, lastName);
        query.setParameter(3, age);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }


    @Override
    public void removeUserById(long id) {
        try {
            Session session = util.startSession();
            Query query = session.createNativeQuery(REMOVE_USER_ID);
            query.setParameter(1, id);
            if (id > 0) {
                query.executeUpdate();
                session.getTransaction().commit();
                session.close();
            }
        } catch (Exception e) {
            System.out.println("БД начинается с 1");
        }
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

