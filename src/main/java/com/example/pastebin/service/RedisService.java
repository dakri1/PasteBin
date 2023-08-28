package com.example.pastebin.service;

import com.example.pastebin.PostDto.PostDto;
import com.example.pastebin.entity.Post;
import com.example.pastebin.repository.PostRepo;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class RedisService {

    private final PostRepo postRepo;
    private final RedisTemplate<Long, String> redisTemplate;

    public RedisService(PostRepo postRepo, RedisTemplate redisTemplate) {
        this.postRepo = postRepo;
        this.redisTemplate = redisTemplate;
    }

    public void saveData(Long key, String value, short minutes) {
        redisTemplate.opsForValue().set(key, value);
        redisTemplate.expire(key, minutes, TimeUnit.MINUTES);
    }

    public PostDto getData(UUID url) {
        Post post = postRepo.findByUrl(url);
        if (post == null){
            return null;
        }
        PostDto postDto = new PostDto();
        postDto.setMinutes(post.getMinutes());
        String body = redisTemplate.opsForValue().get(post.getId());
        postDto.setBody(body);
        postDto.setTime_create(post.getTime_create());
        postDto.setUrl_id(url);
        return postDto;
    }
}
