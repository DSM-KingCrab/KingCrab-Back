package org.example.kingcrabback.domain.post.like.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostLikeRequest {
    private final Long postId;
}
