package com.example.hiber.practic.hiber.practic.dao;
import com.example.hiber.practic.hiber.practic.model.User;
import java.util.List;

public interface UserDao {

    void createUsersTable();

    void dropUsersTable();

    void saveUser(String name, String lastName, Integer age);

    void removeUserById(long id);

    List<User> getAllUsers();

    void cleanUsersTable();
}
