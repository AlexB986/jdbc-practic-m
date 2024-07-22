package com.example.hiber.practic.hiber.practic.util;

import java.sql.*;

public class Util {
    //FIXME неиспользуемая константа, нужно удалить, если и без указания драйвера все работает
    public static final String JDBC_DRIVER = "org.postgresql.Driver";
    public static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/postgres";

    public static final String USER = "username";
    public static final String PASSWORD = "password";

    public static final String CREATE_TABLE_USER = "CREATE TABLE IF NOT EXISTS users (id BIGSERIAL PRIMARY KEY, name VARCHAR(255) NOT NULL,  last_name VARCHAR(255) NOT NULL, age INTEGER)";
    public static final String DROP_TABLE_USER ="DROP TABLE IF EXISTS users;";
    public static final String INSERT_USER ="INSERT INTO users (name, last_name, age) VALUES(?,?,?);";
    public static final String REMOVE_USER_ID = "DELETE FROM users WHERE id =?;";
    public static final String GET_ALL_USERS= "SELECT * FROM users; ";
    public static final String CLEAR_TABLE= "TRUNCATE TABLE users;; ";

    public Connection connectionDB() throws SQLException {
        final Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

        return connection;
    }
}
