package com.fastcampus.ch4.dao;

import com.fastcampus.ch4.domain.BoardDto;
import com.fastcampus.ch4.domain.SearchCondition;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml")
public class BoardDaoImpl1Test {
    @Qualifier("boardDaoImpl")
    @Autowired
    BoardDao boardDao;

    @Test
    public void searchSelectPageTest() throws Exception {
        boardDao.deleteAll();
        for(int i = 0; i <= 20; i++) {
            BoardDto boardDto = new BoardDto("title" + i, "asdfdasllslflsdf", "asdf");
            boardDao.insert(boardDto);
        }

        SearchCondition sc = new SearchCondition(1, 10, "title2", "T");
        List<BoardDto> list = boardDao.searchSelectPage(sc);
        System.out.println("list = " + list);

        assertTrue(list.size() == 2);
    }

    @Test
    public void searchResultCount() throws Exception {
        boardDao.deleteAll();
        for(int i = 0; i <= 20; i++) {
            BoardDto boardDto = new BoardDto("title" + i, "asdfdasllslflsdf", "asdf");
            boardDao.insert(boardDto);
        }

        SearchCondition sc = new SearchCondition(1, 10, "title2", "T");
        int cnt = boardDao.searchResultCnt(sc);

        assertTrue(cnt == 2);
    }

    @Test
    public void select() throws Exception {
        BoardDto boardDto = boardDao.select(1);
        System.out.println("boardDto = " + boardDto);
        assertTrue(boardDto.getBno().equals(1));
    }
}