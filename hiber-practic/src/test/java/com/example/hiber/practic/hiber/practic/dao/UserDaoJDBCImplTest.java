package com.example.hiber.practic.hiber.practic.dao;

import com.example.hiber.practic.hiber.practic.model.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserDaoJDBCImplTest {
    private final UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();

    private final Long testId = 1L;
    private final String testName = "Name";
    private final String testLastName = "LastName";
    private final Integer testAge = 16;

    @Test
    public void createUsersTable() {
        try {
            userDaoJDBC.createUsersTable();

        } catch (Exception e) {
            Assert.fail("При тестировании создание таблицы произошло исключение\n" + e);
        }

    }

    @Test
    public void dropUsersTable() {
        try {
            userDaoJDBC.createUsersTable();
            userDaoJDBC.dropUsersTable();
        } catch (Exception e) {
            Assert.fail("При тестировании удаление таблицы произошло исключение\n" + e);

        }
    }

    @Test
    public void saveUser() {
        try {
            userDaoJDBC.dropUsersTable();
            userDaoJDBC.createUsersTable();
            userDaoJDBC.saveUser(testName, testLastName, testAge);

            User user = userDaoJDBC.getAllUsers().get(0);
            System.out.println(user);
            if (!testName.equals(user.getName()) || !testLastName.equals(user.getLastName()) || testAge != user.getAge()) {
                Assert.fail("Данные не корректные");
            }
        } catch (Exception e) {
            Assert.fail("При сохранение произошла ощибка");
        }
    }

    @Test
    public void removeUserById() {
        try {

            userDaoJDBC.dropUsersTable();
            userDaoJDBC.createUsersTable();
            userDaoJDBC.saveUser(testName, testLastName, testAge);
            userDaoJDBC.removeUserById(testId);

        }catch (Exception e){
            Assert.fail("При удаление произошла ощибка");
        }
    }
    @Test
    public void  getAllUsers(){
        try{
            userDaoJDBC.dropUsersTable();
            userDaoJDBC.createUsersTable();
            userDaoJDBC.saveUser(testName, testLastName, testAge);
            List<User>testUserList= userDaoJDBC.getAllUsers();
            if (testUserList.size()!=1){
                Assert.fail("лист пустой");
            }
        }catch (Exception e){
            Assert.fail("попытка достать данные провалилась");
        }
    }
    @Test
    public void cleanUsersTable(){
        try {
            userDaoJDBC.dropUsersTable();
            userDaoJDBC.createUsersTable();
            userDaoJDBC.saveUser(testName, testLastName, testAge);
            userDaoJDBC.cleanUsersTable();
            if(userDaoJDBC.getAllUsers().size()!=0){
                Assert.fail("таблица не очишена");
            }
        }catch (Exception e){
            Assert.fail("не корректный метод очистки");
        }
    }
}