package com.example.hiber.practic.hiber.practic.util;

import com.example.hiber.practic.hiber.practic.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Util {

    public static final String JDBC_DRIVER = "org.postgresql.Driver";
    public static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/postgres";
    public static final String USER = "username";
    public static final String PASSWORD = "password";

    public static final String CREATE_TABLE_USER = "CREATE TABLE IF NOT EXISTS users (id BIGSERIAL PRIMARY KEY, name VARCHAR(255) NOT NULL,  last_name VARCHAR(255) NOT NULL, age INTEGER)";
    public static final String DROP_TABLE_USER = "DROP TABLE IF EXISTS users;";
    public static final String INSERT_USER = "INSERT INTO users (name, last_name, age) VALUES(?,?,?);";
    public static final String REMOVE_USER_ID = "DELETE FROM users WHERE id =?;";
    public static final String GET_ALL_USERS = "SELECT * FROM users; ";
    public static final String CLEAR_TABLE = "TRUNCATE TABLE users;; ";

    public final List<User> getUser() {
        List<User> usersList = new ArrayList<>();
        User user1 = new User("Mikel", "Liam", 34);
        User user2 = new User("Roma", "Nukson", 56);
        User user3 = new User("Denis", "Pons", 33);
        User user4 = new User("Rita", "Mita", 45);
        usersList.add(user1);
        usersList.add(user2);
        usersList.add(user3);
        usersList.add(user4);
        return usersList;
    }

    public Connection connectionDBJDBC() throws SQLException {
        final Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        return connection;
    }


}
