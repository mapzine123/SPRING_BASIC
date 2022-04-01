package com.fastcampus.ch4.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/**/root-context.xml")
public class CommentDaoTest {
    @Autowired
    CommentDao commentDao;

    @Test
    public void count() throws Exception {
        commentDao.deleteAll(1);
        assertTrue(commentDao.count(1) == 0);
    }
}