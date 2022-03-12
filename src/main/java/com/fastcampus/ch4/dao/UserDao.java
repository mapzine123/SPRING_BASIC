package com.fastcampus.ch4.dao;

import com.fastcampus.ch4.domain.*;
import org.springframework.stereotype.Component;

@Component
public interface UserDao {
    UserDto select(String id) throws Exception;
    int delete(String id) throws Exception;
    int insert(UserDto user) throws Exception;
    int update(UserDto user) throws Exception;
    int count() throws Exception;
    int deleteAll() throws Exception;
}