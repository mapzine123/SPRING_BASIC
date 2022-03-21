package com.fastcampus.ch4.dao;

import com.fastcampus.ch4.domain.BoardDto;
import com.fastcampus.ch4.domain.SearchCondition;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface BoardDao {
    // SELECT
    BoardDto select(int bno) throws Exception;

    List<BoardDto> selectAll() throws Exception;

    int count() throws Exception;

    List<BoardDto> selectPage(Map map) throws Exception;

    //DELETE
    int delete(int bno, String writer) throws Exception;

    int deleteAll() throws Exception;

    // INSERT
    int insert(BoardDto dto) throws Exception;

    // UPDATE
    int update(BoardDto dto) throws Exception;

    int increaseViewCnt(int bno) throws Exception;
    List<BoardDto> searchSelectPage(SearchCondition sc) throws Exception;
    int searchResultCnt(SearchCondition sc) throws Exception;
}
