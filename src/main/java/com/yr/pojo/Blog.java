package com.yr.pojo;

import java.util.List;

public class Blog {
    private Integer id;

    private Integer uId;

    private String title;

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    //体现博客与评论之间是一对多的关系
    private List<Comment> commentList;

    private String summary;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", uId=" + uId +
                ", title='" + title + '\'' +
                ", commentList=" + commentList +
                ", summary='" + summary + '\'' +
                '}';
    }
}