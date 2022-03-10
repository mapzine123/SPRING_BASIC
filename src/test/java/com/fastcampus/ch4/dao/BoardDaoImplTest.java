package com.fastcampus.ch4.dao;

import com.fastcampus.ch4.domain.BoardDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml")
public class BoardDaoImplTest {
    @Qualifier("boardDaoImpl")
    @Autowired
    BoardDao boardDao;

    @Test
    public void select() throws Exception {
        BoardDto boardDto = boardDao.select(1);
        System.out.println("boardDto = " + boardDto);
        assertTrue(boardDto.getBno().equals(1));
    }

    @Test
    public void insert() throws Exception {
        BoardDto dto = new BoardDto("1title", "content", "writer");
        int cnt = boardDao.insert(dto);
        assertTrue(cnt == 1);
    }
}