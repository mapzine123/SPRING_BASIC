package com.fastcampus.ch4.controller;

import com.fastcampus.ch4.domain.CommentDto;
import com.fastcampus.ch4.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

public class CommentController {
    @Autowired
    private CommentService service;
    
    // 지정된 댓글 삭제
    @DeleteMapping("/comments/{cno}") // comments/1 <-- 삭제할 댓글 번호
    @ResponseBody
    public ResponseEntity<String> remove(@PathVariable Integer bno, Integer cno, HttpSession session) {
        String commenter = (String)session.getAttribute("id");
        try {
            int rowCnt = service.remove(cno, bno, commenter);

            if(rowCnt != 1) {
              throw new Exception("Delete Failed");
            }
            return new ResponseEntity<>("DEL_OK", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



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
