package com.example.hiber.practic.hiber.practic.dao;
import com.example.hiber.practic.hiber.practic.model.User;
import com.example.hiber.practic.hiber.practic.util.Util;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;
import static com.example.hiber.practic.hiber.practic.util.Util.*;

public class UserDaoHibernateImpl implements UserDao {
    Util util = new Util();
    private Session session;

    public UserDaoHibernateImpl(Session session) {
        this.session = session;
    }

    @Override
    public void createUsersTable() {
        Query query = session.createNativeQuery(CREATE_TABLE_USER);
        query.executeUpdate();
    }

    @Override
    public void dropUsersTable() {
        Query query = session.createNativeQuery(DROP_TABLE_USER);
        query.executeUpdate();
    }

    //fixme Здесь нужно реализовать через hibernate, он позволяет сохранять сразу целую сущность, session.persist(Object object)
    @Override
    public void saveUser(String name, String lastName, Integer age) {
        User saveUsers = new User();
        saveUsers.setName(name);
        saveUsers.setLastName(lastName);
        saveUsers.setAge(age);
        session.save(saveUsers);
        session.flush();
    }


    @Override
    //fixme Здесь тоже нужно реализовать через hibernate, сначала достать сущность из базы по id, и потом удалить,
    // используя соответствующие методы объекта Session
    public void removeUserById(long id) {
        User user = session.find(User.class, id);
        session.delete(user);
        session.flush();
        session.clear();
    }

    @Override
    public List<User> getAllUsers() {
        Query<User> userQuery = session.createNativeQuery(GET_ALL_USERS, User.class);
        List<User> userList = userQuery.list();
        return userList;
    }

    @Override
    public void cleanUsersTable() {
        Query query = session.createNativeQuery(CLEAR_TABLE);
    }
}

