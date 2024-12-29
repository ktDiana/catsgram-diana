package com.practice.catsgram.service;

import com.practice.catsgram.exceptions.PostNotFoundException;
import com.practice.catsgram.exceptions.UserNotFoundException;
import com.practice.catsgram.model.Post;
import com.practice.catsgram.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor

public class PostService {

    private final List<Post> posts = new ArrayList<>();
    private final UserService userService;
    private int nextId = 1;

    public Collection<Post> findAll() {
        return posts;
    }

    public Post create(Post post) {
        User user = userService.findByEmail(post.getAuthor());
        if (user == null) {
            throw new UserNotFoundException(String.format("Пользователь %s не найден", post.getAuthor()));
        }
        post.setId(nextId++);
        posts.add(post);
        return post;
    }

    public void deletePostsByAuthor(String author) {
        posts.removeIf(post -> post.getAuthor().equalsIgnoreCase(author));
    }

    public Post findPostById(int id) {
        return posts.stream()
                .filter(post -> post.getId() == id)
                .findFirst()
                .orElseThrow(() -> new PostNotFoundException(String.format("Пост №%d не найден", id)));
    }

//        return posts.stream()
//                .filter(post -> post.getId() == id)
//                .findFirst()
//                .orElse(null);
}

