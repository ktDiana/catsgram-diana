package com.practice.catsgram.service;

import com.practice.catsgram.exceptions.InvalidEmailException;
import com.practice.catsgram.exceptions.UserAlreadyExistsException;
import com.practice.catsgram.exceptions.UserNotFoundException;
import com.practice.catsgram.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private final Map<String, User> users = new HashMap<>();

    public UserService() {
        users.put("tom@email.org", new User() {{
            setEmail("tom@email.org");
            setNickname("tom");
            setBirthday(LocalDate.of(2000, 1, 1));
        }});
        users.put("dylan@email.org", new User() {{
            setEmail("dylan@email.org");
            setNickname("dylan");
            setBirthday(LocalDate.of(2000, 2, 3));
        }});
    }

    public Collection<User> findAll() {
        return users.values();
    }

    public User create(User user) {
        if (user.getEmail() == null || user.getEmail().isBlank()) {
            throw new InvalidEmailException("Почта не может быть пустой");
        }
        if (users.containsKey(user.getEmail())) {
            throw new UserAlreadyExistsException("Пользователь с такой почтой уже существует");
        }
        users.put(user.getEmail(), user);
        return user;
    }

    public User update(User user) {
        if (user.getEmail() == null || user.getEmail().isBlank()) {
            throw new InvalidEmailException("Почта не может быть пустой");
        }
        users.put(user.getEmail(), user);
        return user;
    }

    public User findByEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new UserNotFoundException("Пользователь не найден: " + email);
        }
        User user = users.get(email);
        if (user == null) {
            throw new UserNotFoundException("Пользователь не найден: " + email);
        }
        return user;
    }
}
