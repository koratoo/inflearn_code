package com.bbs.jskim.controller;

import com.bbs.jskim.request.PostCreate;
import com.bbs.jskim.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequiredArgsConstructor
public class PostController {


    private final PostService postService;

    @GetMapping("/posts")
    public String get(){
        return "Hello World";
    }

    @PostMapping("/posts")
    public String post(@RequestBody PostCreate params){
        log.info("params={}" , params.toString());

        String title = params.getTitle();
        String content = params.getContent();


         return "Hello World!";
    }


}
