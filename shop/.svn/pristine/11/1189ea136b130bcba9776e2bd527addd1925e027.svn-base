package com.up.controller;

import com.up.entity.CommentInfo;
import com.up.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author:BJP
 * @CreateTime:2019/10/7 21:05
 * @Package:com.up.controller
 */
@Controller
@RequestMapping("comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    //跳转添加评论页面
    @RequestMapping("toadd")
    public String toadd(){
        return "forward:/WEB-INF/comment/add.jsp";
    }

    //添加评论方法
    @RequestMapping("addComment")
    public String addComment(CommentInfo c){
        this.commentService.addComment(c);
        //return "redirect:/comment/queryCommentList.do";
        return "forward:/WEB-INF/comment/table.jsp";
    }

    //查询所有的评论
    @RequestMapping("queryCommentList")
    @ResponseBody
    public List<CommentInfo> queryCommentList(){
        List<CommentInfo> list = this.commentService.queryCommentList();
        return list;
    }

    //根据ID回显
    @RequestMapping("queryById")
    public String queryById(HttpServletRequest req,Integer id){
        CommentInfo c = commentService.queryById(id);
        req.setAttribute("c",c);
        return "forward:/WEB-INF/comment/add.jsp";
    }

    //根据ID删除
    @RequestMapping("deleteId")
    public String deleteId(Integer id){
        commentService.deleteId(id);
        return "redirect:/comment/queryCommentList.do";
        //return "forward:/WEB-INF/comment/table.jsp";
    }
}
