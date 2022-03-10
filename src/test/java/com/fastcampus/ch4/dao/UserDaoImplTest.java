package com.fastcampus.ch4.dao;

import com.fastcampus.ch4.domain.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml")
public class UserDaoImplTest {

    private SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");

    @Autowired
    UserDao userDao;

    @Test
    public void delete() {
    }

    @Test
    public void select() throws Exception {
        UserDto dto = userDao.select("asdf");
        System.out.println("dto = " + dto);
        assertTrue(dto != null);
    }

    @Test
    public void insert() throws Exception {
        UserDto dto = new UserDto("as1df", "123", "name1", "asdf@naver.com", new java.sql.Date(new Date().getTime()), "fb");
        System.out.println("dto = " + dto);
        System.out.println(sdf.format(new Date()));
        int cnt = userDao.insert(dto);
        assertTrue(cnt == 1);
    }

    @Test
    public void update() {
        
    }

    @Test
    public void count() throws Exception {
        int cnt = userDao.count();
        System.out.println("cnt = " + cnt);
        assertTrue(cnt == 2);
    }

    @Test
    public void deleteAll() {
    }
}