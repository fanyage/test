package com.up.entity;

/**
 * @Author:BJP
 * @CreateTime:2019/10/7 20:43
 * @Package:com.up.entity
 */
public class CommentInfo {
    private int id;
    private String comment;//评论的内容
    private String star;//评分，几颗星
    private String starcount;//总次数
    private String starsum;//总分数
    private int pid;//评论的商品ID

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getStarcount() {
        return starcount;
    }

    public void setStarcount(String starcount) {
        this.starcount = starcount;
    }

    public String getStarsum() {
        return starsum;
    }

    public void setStarsum(String starsum) {
        this.starsum = starsum;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "CommentInfo{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", star='" + star + '\'' +
                ", starcount='" + starcount + '\'' +
                ", starsum='" + starsum + '\'' +
                ", pid=" + pid +
                '}';
    }
}
