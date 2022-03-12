package com.fastcampus.ch4.dao;

import com.fastcampus.ch4.domain.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml")
public class UserDaoImplBatisTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void delete() throws Exception {
        int cnt = userDao.delete("asdf33");
        assertTrue(cnt == 1);
    }

    @Test
    public void select() throws Exception {
        UserDto dto = userDao.select("asdf33");
        assertTrue(dto != null);
    }

    @Test
    public void insert() throws Exception {
        int cnt = 0;
        for(int i = 1; i < 100; i++) {
            UserDto dto = new UserDto("asdf" + i, "1234", "name", "asdf@naver.com", new Date(), "fb");
            cnt += userDao.insert(dto);
        }
        assertTrue(cnt == 99);
    }

    @Test
    public void update() throws Exception {
        UserDto dto = new UserDto("asdf1", "1234", "iiuuspdm", "mmdiiduf@naver.com", new Date(), "instagram");
        int cnt = userDao.update(dto);
        assertTrue(cnt == 1);
    }

    @Test
    public void count() throws Exception {
        int cnt = userDao.count();
        System.out.println("cnt = " + cnt);
    }

    @Test
    public void deleteAll() {
    }
}