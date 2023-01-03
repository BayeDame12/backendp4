package com.backendp4.backendp4.service;

import com.backendp4.backendp4.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();

    User createUser(User user);

    User updateUser(long id, User user);

    void deleteUser(long id);

    User getUserById(long id);
}
