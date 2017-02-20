package com.demo.toys.core.spider.domain;

import java.util.Date;

/**
 * Created by Kavinal on 2017/2/14.
 */
public class ItemDO {
    private Long id;
    private String url;
    private String title;
    private Date postTime;
    private Date gmtCreate;
    private Date gmtModified;
    private Short deleteMark;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemDO item = (ItemDO) o;

        if (url != null ? !url.equals(item.url) : item.url != null) return false;
        return title != null ? title.equals(item.title) : item.title == null;

    }

    @Override
    public int hashCode() {
        int result = url != null ? url.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Short getDeleteMark() {
        return deleteMark;
    }

    public void setDeleteMark(Short deleteMark) {
        this.deleteMark = deleteMark;
    }
}
