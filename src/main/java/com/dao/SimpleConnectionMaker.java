package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleConnectionMaker { // -> 더 이상 상속을 이용한 확장 방식을 사용할 필요가 없으니
                                // 추상 클랜스로 만들 필요가 없다.
    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost/myshop"
                ,"root","ikok9636*");

        return c;
    }
}
