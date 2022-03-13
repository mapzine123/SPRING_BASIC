package com.fastcampus.ch4.dao;

import com.fastcampus.ch4.domain.GreenBoardDto;

import java.util.List;

public interface GreenBoardDao {
    int insert(GreenBoardDto dto);

    List<GreenBoardDto> selectAll();

    GreenBoardDto select(int id);

    int getCount();

    int delete(int id);
    int deleteAll();

    int update(GreenBoardDto dto);


}
