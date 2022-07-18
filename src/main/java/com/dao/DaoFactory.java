package com.dao;

public class DaoFactory {
    private ConnectionMaker connectionMaker(){
        NConnectionMaker nConnectionMaker = new NConnectionMaker();
        return nConnectionMaker;
    }

    public UserDao userDao(){
        UserDao userDao = new UserDao(connectionMaker());
        return userDao;
    }
}
