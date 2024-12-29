package com.practice.catsgram.controller;

import com.practice.catsgram.model.Post;
import com.practice.catsgram.service.PostService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private static final Logger log = LoggerFactory.getLogger(PostController.class);
    private final PostService postService;

    @GetMapping("/posts/{id}")
    public Post findById(@PathVariable int id) {
        return postService.findById(id);
    }

    @GetMapping
    public Collection<Post> findAll() {
        Collection<Post> posts = postService.findAll();
        log.debug("Текущее количество постов: {}", posts.size());
        return posts;
    }

    @PostMapping
    public Post create(@RequestBody Post post) {
        return postService.create(post); // Используем PostService для создания поста
    }

    @DeleteMapping("/{author}")
    public void deletePostsByAuthor(@PathVariable String author) {
        log.debug("Удаление постов автора: {}", author);
        postService.deletePostsByAuthor(author);

    }

}

