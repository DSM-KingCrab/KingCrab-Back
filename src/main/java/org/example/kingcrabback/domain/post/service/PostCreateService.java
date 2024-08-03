package org.example.kingcrabback.domain.post.service;

import lombok.RequiredArgsConstructor;
import org.example.kingcrabback.domain.post.dto.PostRequest;
import org.example.kingcrabback.domain.post.entity.Post;
import org.example.kingcrabback.domain.post.repository.PostRepository;
import org.example.kingcrabback.domain.user.facade.UserFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostCreateService {
    private final PostRepository postRepository;
    private final UserFacade facade;

    @Transactional
    public void createPost(PostRequest postRequest){
         postRepository.save(
            Post.builder()
                    .name(facade.getCurrentUser().getUserName())
                    .title(postRequest.getTitle())
                    .content(postRequest.getContent())
                    .build()
        );
    }
}
