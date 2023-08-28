package com.example.pastebin.controller;


import com.example.pastebin.PostDto.PostDto;
import com.example.pastebin.service.PostService;
import com.example.pastebin.service.RedisService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/")
public class PostController {
    private final PostService postService;
    private final RedisService redisService;

    public PostController(PostService postService, RedisService redisService) {
        this.postService = postService;
        this.redisService = redisService;
    }

    @PostMapping
    public PostDto createPost(@RequestBody PostDto postDto) {
        postDto.setUrl_id(UUID.randomUUID());
        Long id = postService.create(postDto.getUrl_id(), postDto.getMinutes());
        redisService.saveData(id, postDto.getBody(), postDto.getMinutes());
        return postDto;
    }

    @GetMapping("/{url}")
    public PostDto getData(@PathVariable UUID url) {
        return redisService.getData(url);
    }
}
