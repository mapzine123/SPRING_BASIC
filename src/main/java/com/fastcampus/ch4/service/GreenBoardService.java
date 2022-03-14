package com.fastcampus.ch4.service;

import com.fastcampus.ch4.dao.GreenBoardDao;
import com.fastcampus.ch4.domain.GreenBoardDto;
import org.springframework.beans.factory.annotation.Autowired;

public class GreenBoardService {
    @Autowired
    private GreenBoardDao greenBoardDao;
    private int perPage = 5;

}
