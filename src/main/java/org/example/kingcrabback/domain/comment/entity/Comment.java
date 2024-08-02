package org.example.kingcrabback.domain.comment.entity;

import lombok.*;
import org.example.kingcrabback.domain.post.entity.Post;
import org.example.kingcrabback.domain.user.entity.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;
    private String comment;

    private LocalDateTime now;

    @ManyToOne
    private Post post;
    public void updateComment(String comment) {
        this.comment = comment;
    }
}
