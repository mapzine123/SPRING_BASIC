package com.fastcampus.ch4.service;

import com.fastcampus.ch4.dao.UserDao;
import com.fastcampus.ch4.domain.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public int getCount() throws Exception {
        return userDao.count();
    }

    public int remove(String id) throws Exception {
        return userDao.delete(id);
    }



}
