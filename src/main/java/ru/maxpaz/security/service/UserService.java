package ru.maxpaz.security.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.maxpaz.security.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    void saveUser(User user);
    void removeUserById(Long id);
    List<User> getAllUsers();
    void updateUser(Long id, User user);
    User getUserById(Long id);
    User getUserByUsername(String username);
}

