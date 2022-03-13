package com.fastcampus.ch4.domain;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public class GreenBoardDto {
    private int id;
    private String pwd;
    private String title;
    private String content;
    private Date reg_date;
    private String filename;
    private MultipartFile file;

    public GreenBoardDto() {
    }

    public GreenBoardDto(String pwd, String title, String content, String filename) {
        this.pwd = pwd;
        this.title = title;
        this.content = content;
        this.filename = filename;
    }

    public GreenBoardDto(String pwd, String title, String content, Date reg_date, String filename) {
        this.pwd = pwd;
        this.title = title;
        this.content = content;
        this.reg_date = reg_date;
        this.filename = filename;
    }

    public GreenBoardDto(int id, String pwd, String title, String content, Date reg_date, String filename) {
        this.id = id;
        this.pwd = pwd;
        this.title = title;
        this.content = content;
        this.reg_date = reg_date;
        this.filename = filename;
    }

    @Override
    public String toString() {
        return "GreenBoardDto{" +
                "id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", reg_date=" + reg_date +
                ", filename='" + filename + '\'' +
                ", file=" + file +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getReg_date() {
        return reg_date;
    }

    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
