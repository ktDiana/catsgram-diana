package com.practice.catsgram.controller;

import com.practice.catsgram.exception.InvalidEmailException;
import com.practice.catsgram.exception.UserAlreadyExistsException;
import com.practice.catsgram.model.User;
import com.practice.catsgram.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

//    private final Map<String, User> users = new HashMap<>() {{
//        put("tom@email.org", new User(){{
//            setEmail("tom@email.org");
//            setNickname("tom");
//            setBirthday(LocalDate.of(2000, 1, 1));
//        }});
//
//        put("dylan@email.org", new User(){{
//            setEmail("dylan@email.org");
//            setNickname("dylan");
//            setBirthday(LocalDate.of(2000, 2, 3));
//        }});
//    }};

    @GetMapping     // GET /users
    public Collection<User> findAll() {
        return userService.findAll();
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping
    public User update(@RequestBody User user) {
        return userService.create(user);
    }

}
