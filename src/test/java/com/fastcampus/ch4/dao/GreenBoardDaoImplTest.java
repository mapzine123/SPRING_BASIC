package com.fastcampus.ch4.dao;

import com.fastcampus.ch4.domain.GreenBoardDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml")
public class GreenBoardDaoImplTest {

    @Autowired
    GreenBoardDao greenBoardDao;

    @Test
    public void insert() {
        int cnt = 0;
        greenBoardDao.deleteAll();
        for(int i = 0; i < 100; i++) {
            GreenBoardDto dto = new GreenBoardDto("1234", "title" + i, "content" + i, "filename" + i);
            greenBoardDao.insert(dto);
            cnt++;
        }
        System.out.println(cnt);
        assertTrue(cnt == 100);
    }

    @Test
    public void selectAll() {
        List<GreenBoardDto> list = null;
        list = greenBoardDao.selectAll();

        for (GreenBoardDto dto : list) {
            System.out.println("dto = " + dto);
        }
    }

    @Test
    public void select() {
        GreenBoardDto dto = greenBoardDao.select(108);
        System.out.println("dto = " + dto);
        assertTrue(dto != null);
    }

    @Test
    public void getCount() {
        int cnt = greenBoardDao.getCount();
        System.out.println("cnt = " + cnt);
    }

    @Test
    public void delete() {
        int cnt = greenBoardDao.delete(107);
        assertTrue(cnt == 1);
    }

    @Test
    public void update() {
        GreenBoardDto dto = greenBoardDao.select(108);
        dto.setTitle("CHANGED TITLE!!!");
        int cnt = greenBoardDao.update(dto);
        assertTrue(cnt == 1);
    }
}