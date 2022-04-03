package com.fastcampus.ch4.controller;

import com.fastcampus.ch4.domain.CommentDto;
import com.fastcampus.ch4.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public class CommentController {
    @Autowired
    private CommentService service;




    // Entity : 응답 보낼때 보내려는 알맹이 ( 여기선 list )
    // 지정된 댓글 가져오는 메서드
    @RequestMapping("/comments")
    public ResponseEntity<List<CommentDto>> list(Integer bno) {
        List<CommentDto> list = null;
        try {
            list = service.getList(bno);
            return new ResponseEntity<List<CommentDto>>(list, HttpStatus.OK) ;
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<CommentDto>>(list, HttpStatus.BAD_REQUEST) ;
        }
    }
}
