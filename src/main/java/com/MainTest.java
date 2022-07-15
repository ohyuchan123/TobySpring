package com;

import com.dao.NUserDao;
import com.dao.UserDao;
import com.domain.User;

import java.sql.SQLException;

public class MainTest {
    //main을 이용해서 test하는 프로그램
    // 이 클래스를 실행하면 즉 main() 메소드가 등록 성공,조회 성공과 같은 테스트 성공
    // 메세지를 얻을 수 있다.
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDao userDao = new NUserDao();

        User user = new User();
        user.setId("oyc");
        user.setName("yuchan");
        user.setPassword("ikok9636*");

        userDao.add(user);

        System.out.println(user.getId()+" 등록 성공");

        User result = userDao.get(user.getId());

        System.out.println(result.getName());
        System.out.println(result.getPassword());

        System.out.println(result.getId()+"조회 성공");
    }
}
