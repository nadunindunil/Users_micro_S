package com.sysco.service;

import com.sysco.dao.UserDAO;
import com.sysco.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService{
        @Autowired
        private UserDAO userDAO;

        public void setUserDAO(UserDAO UserDAO) {
            this.userDAO = UserDAO;
        }

        @Override
        @Transactional
        public void addUser(User p) {
            this.userDAO.addUser(p);
        }

        @Override
        @Transactional
        public void updateUser(User p) {
            this.userDAO.updateUser(p);
        }

        @Override
        @Transactional
        public List<User> listUsers() {
            return this.userDAO.listUsers();
        }

        @Override
        @Transactional
        public User getUserById(int id) {
            return this.userDAO.getUserById(id);
        }

        @Override
        @Transactional
        public void removeUser(int id) {
            this.userDAO.removeUser(id);
        }
}
