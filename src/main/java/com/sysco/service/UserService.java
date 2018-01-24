package com.sysco.service;

import com.sysco.model.User;

import java.util.List;

public interface UserService {
    public void addUser(User p);
    public void updateUser(User p);
    public List<User> listUsers();
    public User getUserById(int id);
    public void removeUser(int id);
}
