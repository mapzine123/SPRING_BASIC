package com.fastcampus.ch4.service;

import com.fastcampus.ch4.dao.BoardDao;
import com.fastcampus.ch4.dao.CommentDao;
import com.fastcampus.ch4.domain.CommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentService {
//    @Autowired
    BoardDao boardDao;
//    @Autowired
    CommentDao commentDao;

    public CommentService(BoardDao boardDao, CommentDao commentDao) {
        this.commentDao = commentDao;
        this.boardDao = boardDao;
    }

    public int getCount(Integer bno) throws Exception {
        return commentDao.count(bno);
    }

    @Transactional(rollbackFor = Exception.class)
    public int remove(Integer cno, Integer bno, String commenter) throws Exception {
        int rowCnt = boardDao.updateCommentCnt(bno, -1);
        System.out.println("updateCommentCnt - rowCnt = " + rowCnt);
        rowCnt = commentDao.delete(cno, commenter);
        System.out.println("rowCnt = " + rowCnt);
        return rowCnt;
    }

    @Transactional
    public int write(CommentDto commentDto) throws Exception {
        boardDao.updateCommentCnt(commentDto.getBno(), 1);
        return commentDao.insert(commentDto);
    }

    public List<CommentDto> getList(Integer bno) throws Exception {
        return commentDao.selectAll(bno);
    }

    public CommentDto read(Integer cno) throws Exception {
        return commentDao.select(cno);
    }
    public int modify(CommentDto commentDto) throws Exception {
        return commentDao.update(commentDto);
    }
}















