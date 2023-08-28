package com.example.pastebin.service;

import com.example.pastebin.entity.Post;
import com.example.pastebin.repository.PostRepo;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PostService {
    private final PostRepo postRepo;

    public PostService(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    public Long create(UUID url_id, short minutes){
        Post post = new Post(url_id, minutes);
        return postRepo.save(post).getId();
    }
}
