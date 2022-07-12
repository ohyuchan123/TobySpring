package com.dao;

import com.domain.User;

import java.sql.*;

public class UserDao {
    public void add(User user) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost/myshop"
                ,"root","ikok9636*");

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

        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection(
                "jdbc:mysql://localhost/myshop","root","ikok9636*"
        );

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
