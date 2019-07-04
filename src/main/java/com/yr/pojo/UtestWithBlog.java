package com.yr.pojo;

import java.util.List;

public class UtestWithBlog extends Utest {


    public List<Blog> getBlog() {
        return blogList;
    }

    public void setBlog(List<Blog> blogList) {
        this.blogList = blogList;
    }

    private List<Blog> blogList;


}
