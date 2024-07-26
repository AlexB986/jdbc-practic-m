package com.example.hiber.practic.hiber.practic.util;

import com.example.hiber.practic.hiber.practic.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

import static com.example.hiber.practic.hiber.practic.util.Util.*;

public class StartSession {
    private static StartSession startSession;

    public static StartSession getConnected() {
        if (startSession == null) {
            startSession = new StartSession();
        }
        return startSession;
    }

    private StartSession() {
    }


    private static Properties configProp() {
        Properties prop = new Properties();
        prop.setProperty("dialect", "org.hibernate.dialect.PostgresSQL");
        prop.setProperty("hibernate.connection.url", DATABASE_URL);
        prop.setProperty("hibernate.connection.username", USER);
        prop.setProperty("hibernate.connection.password", PASSWORD);
        prop.setProperty("hibernate.connection.driver_class", JDBC_DRIVER);
        prop.setProperty("show_sql", "true");
        prop.setProperty("hibernate.show_sql", "true");

        return prop;
    }

    /*fixme Здесь мы создаем SessionFactory, и надеемся, что метод startSession() будет вызван только 1 раз
     *  (чтобы гарантировать создание SessionFactory только 1 раз),
     *  но если метод публичный, это гарантировать невозможно. То есть, мы все еще не позаботились о том,
     *  чтобы был создан только 1 объект SessionFactory.
     *  Сам факт того, что ссылка находится в методе, а не в классе, означает, что SessionFactory будет создаваться
     *  каждый раз при вызове метода. Рекомендую ознакомиться с паттерном программирования Singleton,
     *  возможно, стоит использовать какие-то его элементы
     *
     */
    public static Session startSession() {
        SessionFactory sessionFactory = new Configuration().addProperties(configProp()).addAnnotatedClass(User.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        return session;
    }



}
