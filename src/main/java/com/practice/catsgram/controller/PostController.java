package com.practice.catsgram.controller;

import com.practice.catsgram.model.Post;
import com.practice.catsgram.service.PostService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private static final Logger log = LoggerFactory.getLogger(PostController.class);
    private final PostService postService;

    @GetMapping("/{id}")
    public Post findPostById(@PathVariable int id) {
        return postService.findPostById(id);
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

