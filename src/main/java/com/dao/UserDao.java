package com.dao;

import com.domain.User;

import java.sql.*;

//public abstract class UserDao
public class UserDao {

    private SimpleConnectionMaker connectionMaker;

    public UserDao() {
        connectionMaker = new SimpleConnectionMaker();
        //-> 상태를 관리하는 것도 아니니 한 번만 만들어 인스턴스
        // 변수에 저장해 두고 메소드에서 사용하게 한다.
    }

    // 중복된 코드를 독립적인 메소드로 만들어서 중복을 제거했다.
    //abstract는 안에 내용이 있으면 안되기 떄문에 ;를 해준다.

    //본체가 있는 메소드는 abstract 키워드를 가질 수 없다. ex) public abstract int c() {System.out.println("hello");}
    //추상 클래스 내에는 추상 메소드가 아닌 메소드가 존재할 수 없다.
//    public abstract Connection getConnection() throws ClassNotFoundException, SQLException;
    // -> 구현 코드는 제거되고 추상 메소드로 바뀌었다 메소드의 구현은 서브 클래스가 담당한다.

    public void add(User user) throws ClassNotFoundException, SQLException {
        Connection c = connectionMaker.makeConnection();
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

//        Connection c = getConnection(); // DB 연결 기능이 필요하면 getConnection() 메소드를 이용하게 된다.
        Connection c = connectionMaker.makeConnection();
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
