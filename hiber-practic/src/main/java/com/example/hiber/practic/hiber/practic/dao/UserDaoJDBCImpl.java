package com.example.hiber.practic.hiber.practic.dao;

import com.example.hiber.practic.hiber.practic.model.User;
import com.example.hiber.practic.hiber.practic.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.example.hiber.practic.hiber.practic.util.Util.*;

public class UserDaoJDBCImpl implements UserDao {
    Util util = new Util();

    public UserDaoJDBCImpl() {

    }

    @Override
    public void createUsersTable() {
        try (Connection connection = util.connectionDB()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(CREATE_TABLE_USER);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dropUsersTable() {
        try (Connection connection = util.connectionDB()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(DROP_TABLE_USER);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void saveUser(String name, String lastName, Integer age) {
        try (Connection connection = util.connectionDB()) {
            PreparedStatement statement = connection.prepareStatement(INSERT_USER);
            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setInt(3, age);
            statement.executeUpdate();
            System.out.println("Имя "+name+" Фамилия "+lastName+" Возраст "+age);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserById(long id) {
        try (Connection connection = util.connectionDB()) {
            PreparedStatement statement = connection.prepareStatement(REMOVE_USER_ID);
            statement.setLong(1, id);
            if (id > 0) {
                statement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        try (Connection connection = util.connectionDB()) {
            PreparedStatement statement = connection.prepareStatement(GET_ALL_USERS);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("last_name");
                Integer age = resultSet.getInt("age");
                User users = new User(id, name, lastName, age);
                userList.add(users);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        System.out.println(userList);
        return userList;
    }

    @Override
    public void cleanUsersTable() {
        try (Connection connection = util.connectionDB()) {
            Statement statrment = connection.createStatement();
            statrment.executeUpdate(CLEAR_TABLE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
