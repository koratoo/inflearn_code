package com.bbs.jskim.service;

import com.bbs.jskim.domain.Post;
import com.bbs.jskim.request.PostEdit;
import com.bbs.jskim.response.PostResponse;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {



    public void edit(Long id, PostEdit postEdit){
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalAccessException("존재하지 않는 글입니다."));
        post.setTitle("");
        post.setContent("");
    }
}
