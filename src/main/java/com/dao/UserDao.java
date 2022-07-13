package com.dao;

import com.domain.User;

import java.sql.*;

public class UserDao {

    // 중복된 코드를 독립적인 메소드로 만들어서 중복을 제거했다.
    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost/myshop"
                ,"root","ikok9636*");

        return c;
    }

    public void add(User user) throws ClassNotFoundException, SQLException {
        Connection c = getConnection();
        PreparedStatement ps = c.prepareStatement(
                "insert into users(id,name,password) values (?,?,?)"
        );
        ps.setString(1,user.getId());
        ps.setString(2,user.getName());
        ps.setString(3,user.getPassword());

//        ps.setString(1,"0");
//        ps.setString(2,"yuchan");
//        ps.setString(3,"ikok9636*");

        ps.executeUpdate();

        ps.close();
        c.close();
    }
    public User get(String id) throws ClassNotFoundException, SQLException {
        User user = new User();

        Connection c = getConnection(); // DB 연결 기능이 필요하면 getConnection() 메소드를 이용하게 된다.

        PreparedStatement ps = c.prepareStatement(
                "select * from users where id=?"
        );
        ps.setString(1,id);

        ResultSet rs = ps.executeQuery();
        rs.next();

        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        c.close();

        return user;
    }
}
