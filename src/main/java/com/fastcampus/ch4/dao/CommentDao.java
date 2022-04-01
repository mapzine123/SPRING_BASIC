package com.fastcampus.ch4.dao;

import com.fastcampus.ch4.domain.CommentDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CommentDao {
    @Autowired
    private SqlSession session;
    private static String namespace = "com.fastcampus.ch4.dao.commentMapper.";

    public int deleteAll(Integer bno) throws Exception {
        return session.delete(namespace + "deleteAll", bno);
    }

    public int count(Integer bno) throws Exception {
        return session.selectOne(namespace + "count", bno);
    }

    public int delete(Integer cno, String commenter) throws Exception {
        Map map = new HashMap();
        map.put("cno", cno);
        map.put("commenter", commenter);
        return session.delete(namespace + "delete", map);
    }

    public int insert(CommentDto dto) throws Exception {
        return session.insert(namespace + "insert", dto);
    }

    public List<CommentDto> selectAll(Integer bno) throws Exception {
        return session.selectList(namespace + "selectAll", bno);
    }

    public CommentDto select(Integer cno) throws Exception {
        return session.selectOne(namespace + "select", cno);
    }

    public int update(CommentDto dto) throws Exception {
        return session.update(namespace + "update", dto);
    }
}

