package com.dao;

import com.domain.User;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class UserDaoTest {
    @Test
    public void addAndGet() throws SQLException, ClassNotFoundException {

        DaoFactory daoFactory = new DaoFactory();

//        UserDao userDao = new NUserDao();
//        UserDao userDao = new UserDao(new NConnectionMaker());

        UserDao userDao = daoFactory.userDao();
        // UserDao userDao = new daoFactory().userDao();

        User user = new User();
        user.setId("0");
        user.setName("yuchan");
        user.setPassword("ikok9636*");
        userDao.add(user);

        User result = userDao.get("0");
        System.out.println(result.getId());
        System.out.println(result.getName());
        assertEquals("0",result.getId());
    }
}