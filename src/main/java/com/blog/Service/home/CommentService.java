package com.blog.Service.home;

import com.blog.vo.home.Comment;
import java.util.List;

public interface CommentService {

    List<Comment> listCommentByBlogId(Long blogId);

    Comment saveComment(Comment comment);
}
