package com.fastcampus.ch4.board;

import com.fastcampus.ch4.domain.GreenBoardDto;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class BoardUtil {
    public static String toKor(String en) {
        String kor = null;
        try {
            kor = new String(en.getBytes("8859_1"), "euc_kr");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kor;
    }

    public static String toEn(String kor) {
        String en = null;
        try {
            en = new String(kor.getBytes("euc_kr"), "8859_1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return en;
    }

    public static GreenBoardDto toKorBoard(GreenBoardDto board) {
        board.setTitle(toKor(board.getTitle()));
        board.setContent(toKor(board.getContent()));
        board.setPwd(toKor(board.getPwd()));
        if(board.getFilename() != null ) {
            board.setFilename(toKor(board.getFilename()));
        }
        return board;
    }

    public static GreenBoardDto toEnBoard(GreenBoardDto board) {
        board.setTitle(toEn(board.getTitle()));
        board.setContent(toEn(board.getContent()));
        board.setPwd(toEn(board.getContent()));
        if (board.getFilename() != null) {
            board.setFilename(toEn(board.getFilename()));
        }
        return board;
    }
}






























