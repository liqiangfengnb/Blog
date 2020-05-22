package com.blog.vo.admin;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Data
@Table(name = "t_comment")
public class Comment2 {

    @Id
    @GeneratedValue
    private Long id;
    private String nickname;
    private String email;
    private String content;
    private String avatar;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @ManyToOne
    private Blog blog;

    @OneToMany(mappedBy = "parentComment")
    private List<Comment2> replyComments = new ArrayList<>();

    @ManyToOne
    private Comment2 parentComment;

    private boolean adminComment;

    public Comment2() {
    }


}
