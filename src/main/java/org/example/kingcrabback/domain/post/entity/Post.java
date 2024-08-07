package org.example.kingcrabback.domain.post.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.kingcrabback.domain.comment.entity.Comment;
import org.example.kingcrabback.domain.post.like.entity.PostLike;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String title;
    private String content;
    private Integer commentNum;
    private LocalDateTime now;

    @Column(columnDefinition = "INT")
    private Integer count = 0;

    @OneToMany(mappedBy = "post")
    private List<PostLike> postLikes = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<Comment> commentList;

    public void addComment() {
        this.commentNum++;
    }

    public void removeComment() {
        this.commentNum--;
    }

    public void updatePost(String title , String content){
        this.title = title;
        this.content = content;
    }
    public void addLike() {
        if(this.count == null){
            this.count = 0;
        }
        this.count += 1;
    }

    public void minusLike() {
        if(this.count == null){
            this.count = 0;
        }
        this.count -= 1;
    }
}
