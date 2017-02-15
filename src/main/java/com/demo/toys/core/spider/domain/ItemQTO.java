package com.demo.toys.core.spider.domain;

import java.util.Date;

/**
 * Created by Kavinal on 2017/2/14.
 */
public class ItemQTO {
    private String url;
    private String title;
    private Date postTime;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPostTime() {
        return postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }
}
