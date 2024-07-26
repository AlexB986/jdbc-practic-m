package com.example.hiber.practic.hiber.practic.service;

import com.example.hiber.practic.hiber.practic.dao.UserDao;
import com.example.hiber.practic.hiber.practic.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    /*
     *Hibernet
     */
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void createUsersTable() {
        System.out.println("create table users ");
        userDao.createUsersTable();

    }

    @Override
    public void dropUsersTable() {
        System.out.println("drop table user");
        userDao.dropUsersTable();

    }

    @Override
    public void saveUser(String name, String lastName, Integer age) {
        System.out.println("insert user " + name + " " + lastName + " " + age);
        userDao.saveUser(name, lastName, age);
    }

    @Override
    public void removeUserById(long id) {
        System.out.println("delete user in " + id);
        userDao.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> allUser = userDao.getAllUsers();
        System.out.println("Все пользователи " + allUser);
        return allUser;
    }

    @Override
    public void cleanUsersTable() {
        System.out.println("clean table");
        userDao.cleanUsersTable();
    }

}
