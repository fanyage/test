package com.up.mapper;

import com.up.entity.CommentInfo;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@MapperScan
public interface CommentMapper {

    void addComment(CommentInfo c);

    List<CommentInfo> queryCommentList();

    CommentInfo queryById(Integer id);

    void deleteId(Integer id);
}
