package com.nice.controller;

import com.google.gson.Gson;
import com.nice.dto.CommentsDto;
import com.nice.model.Comments;
import com.nice.model.User;
import com.nice.service.ArticleService;
import com.nice.service.CommentsService;
import com.nice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("/comments")
public class CommentsController {

    @Autowired
    private CommentsService commentsService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private UserService userService;

    @ResponseBody
    @GetMapping("/add")
    public void addComments(Long articleId, String commentContent, HttpServletRequest request){
        Comments comments = new Comments();
        comments.setCommentContent(commentContent);
        comments.setArticleId(articleId);
        Date date = new Date();
        comments.setCreateCommentDate(date);
        comments.setUpdateCommentDate(date);
        User user = (User) request.getSession().getAttribute("USER");
        comments.setUserId(user.getUserId());
        commentsService.addComments(comments);
    }

    @ResponseBody
    @GetMapping("/query/comments")
    public String queryCommentsByArticleId(Long articleId,Long pageNum){
        List<Comments>  commentsList= commentsService.queryCommentsByArticleId(articleId,pageNum);
        List<CommentsDto> commentsDtoList = new ArrayList<CommentsDto>();
        for (Comments comments : commentsList) {
            CommentsDto commentsDto = new CommentsDto();
            commentsDto.setCommentsContent(comments.getCommentContent());
            commentsDto.setCommentsId(comments.getCommentId());
            commentsDto.setUserName(userService.queryUserNameByUserId(comments.getUserId()));
            commentsDtoList.add(commentsDto);
        }
        Long allPages = commentsService.queryCommentsPagesByArticleId(articleId);
        Map map = new HashMap();
        map.put("commentsDtoList",commentsDtoList);
        map.put("allPages",allPages);
        Gson gson = new Gson();
        return gson.toJson(map);
    }

    /**
     * 发送一个articleId到前端生成一个隐藏域，以便用ajax进行分页
     * @param articleId
     * @return
     */
    @GetMapping("/manager/{articleId}")
    public String commentsManagerThymeleaf(@PathVariable("articleId")Long articleId){
        ModelAndView view = new ModelAndView();
        view.addObject("articleId",articleId);
        return "article/commentsManager";
    }

    @GetMapping("/delete/{commentsId}")
    public String deleteComments(@PathVariable("commentsId") Long commentsId){
        commentsService.deleteComments(commentsId);
        return "redirect:../../article/user/list";
    }

}
