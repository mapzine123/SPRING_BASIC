package com.fastcampus.ch4.dao;

import com.fastcampus.ch4.domain.GreenBoardDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GreenBoardDaoImpl implements GreenBoardDao {
    @Autowired
    private SqlSession session;

    private String namespace = "com.fastcampus.ch4.GreenBoardMapper.";

    @Override
    public int insert(GreenBoardDto dto) {
        return session.insert(namespace + "insert", dto);
    }

    @Override
    public List<GreenBoardDto> selectAll() {
        return session.selectList(namespace + "selectAll");
    }

    @Override
    public GreenBoardDto select(int id) {
        return session.selectOne(namespace + "select", id);
    }

    @Override
    public int getCount() {
        return session.selectOne(namespace + "count");
    }

    @Override
    public int delete(int id) {
        return session.delete(namespace + "delete", id);
    }

    @Override
    public int deleteAll() {
        return session.delete(namespace + "deleteAll");
    }

    @Override
    public int update(GreenBoardDto dto) {
        return session.update(namespace + "update", dto);
    }

}
