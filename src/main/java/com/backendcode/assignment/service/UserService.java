package com.backendcode.assignment.service;

import com.backendcode.assignment.model.User;

public interface UserService {
    User getUserByEmail(String email);
    User getdUserByUserName(String userName);
    User saveUser(User user);
    void createAdminUser();
}
