package org.example.kingcrabback.domain.comment.like.entity;

import lombok.*;
import org.example.kingcrabback.domain.comment.entity.Comment;
import org.example.kingcrabback.domain.post.entity.Post;
import org.example.kingcrabback.domain.user.entity.User;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CommentLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id_like", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id_like", nullable = false)
    private Post post;

    @ManyToOne
    @JoinColumn(name = "comment_id", nullable = false)
    private Comment comment;

    public CommentLike(User user, Post post, Comment comment) {
        this.user = user;
        this.post = post;
        this.comment = comment;
    }
}
