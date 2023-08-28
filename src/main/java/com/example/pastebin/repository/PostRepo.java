package com.example.pastebin.repository;

import com.example.pastebin.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PostRepo extends JpaRepository<Post, Long> {
    Post findByUrl(UUID url);
}
