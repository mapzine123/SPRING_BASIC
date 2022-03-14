package com.fastcampus.ch4.dao;

import com.fastcampus.ch4.domain.UserDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    public SqlSession session;

    private String namespace = "com.fastcampus.ch4.dao.userMapper.";

    public int delete(String id) throws Exception {
        return session.delete(namespace + "delete", id);
    }

    public UserDto select(String id) throws Exception {
        return session.selectOne(namespace + "select", id);
    }

    // 사용자 정보를 user_info테이블에 저장하는 메서드
    public int insert(UserDto dto) throws Exception {
        return session.insert(namespace + "insert", dto);
    }

    public int update(UserDto dto) throws Exception {
        return session.update(namespace + "update", dto);
    }

    public int count() throws Exception {
        return session.selectOne(namespace + "count");
    }

    public int deleteAll() throws Exception {
        return session.delete(namespace + "deleteAll");
    }
}