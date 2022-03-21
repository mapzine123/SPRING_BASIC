package com.fastcampus.ch4.dao;

import com.fastcampus.ch4.domain.BoardDto;
import com.fastcampus.ch4.domain.SearchCondition;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BoardDaoImpl implements BoardDao {
    @Autowired
    public SqlSession session;

    private String namespace = "com.fastcampus.ch4.dao.BoardMapper.";

    // SELECT
    @Override
    public BoardDto select(int bno) throws Exception {
        return session.selectOne(namespace + "select", bno);
    }
    @Override
    public List<BoardDto> selectAll() throws Exception {
        return session.selectList(namespace + "selectAll");
    }
    @Override
    public int count() throws Exception {
        return session.selectOne(namespace + "count");
    }
    @Override
    public List<BoardDto> selectPage(Map map) throws Exception {
        return session.selectList(namespace + "selectPage", map);

    }

    public String printSession() {
        return session.toString();
    }


    //DELETE
    @Override
    public int delete(int bno, String writer) throws Exception {
        Map map = new HashMap();
        map.put("bno", bno);
        map.put("writer", writer);
        return session.delete(namespace + "delete", map);
    }

    @Override
    public int deleteAll() throws Exception {
        return session.delete(namespace + "deleteAll");
    }

    // INSERT
    @Override
    public int insert(BoardDto dto) throws Exception {
        return session.insert(namespace + "insert", dto);
    }

    // UPDATE
    @Override
    public int update(BoardDto dto) throws Exception {
        return session.update(namespace + "update", dto);
    }
    @Override
    public int increaseViewCnt(int bno) throws Exception {
        return session.update(namespace + "increaseViewCnt", bno);
    }

    @Override
    public int searchResultCnt(SearchCondition sc) throws Exception {
        return session.selectOne(namespace + "searchResultCnt", sc);
    }

    @Override
    public List<BoardDto> searchSelectPage(SearchCondition sc) throws Exception {
        return session.selectList(namespace + "searchSelectPage", sc);
    }
}





























