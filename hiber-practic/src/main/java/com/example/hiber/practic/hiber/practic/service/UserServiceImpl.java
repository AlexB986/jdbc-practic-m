package com.example.hiber.practic.hiber.practic.service;

import com.example.hiber.practic.hiber.practic.dao.UserDao;
import com.example.hiber.practic.hiber.practic.dao.UserDaoJDBCImpl;
import com.example.hiber.practic.hiber.practic.model.User;


import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDaoJDBCImpl userDao;


    @Override
    public void createUsersTable() {
        System.out.println("create table users");
        userDao.createUsersTable();
    }

    @Override
    public void dropUsersTable() {
        System.out.println("drop table user");
        userDao.dropUsersTable();
    }

    @Override
    public void saveUser(String name, String lastName, Integer age){
        System.out.println("insert user");
        userDao.saveUser(name,lastName,age);
//        userDao.saveUser("Anna", "Zueva", (byte)19);
    }

    @Override
    public void removeUserById(long id) {
        userDao.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        List<User>allUser = userDao.getAllUsers();
        System.out.println(allUser);
        return allUser;
    }

    @Override
    public void cleanUsersTable() {
        userDao.cleanUsersTable();

    }
}
