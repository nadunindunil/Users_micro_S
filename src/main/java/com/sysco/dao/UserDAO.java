package com.sysco.dao;

import com.sysco.model.User;

import java.util.List;

public interface UserDAO {
    public void addUser(User p);
    public void updateUser(User p);
    public List<User> listUsers();
    public User getUserById(int id);
    public void removeUser(int id);

}
