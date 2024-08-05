package org.example.kingcrabback.domain.comment.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
public class CommentResponse {
    private String username;
    private LocalDateTime now;
    private String comment;
    private Long commentId;
    private Integer count;

    public CommentResponse(String username, LocalDateTime now, String comment, Long commentId, Integer count) {
        this.username = username;
        this.now = now;
        this.comment = comment;
        this.commentId = commentId;
        this.count = count;
    }
}
