package com.blog.Service.admin;

import com.blog.mapper.admin.UserRepository;
import com.blog.util.MD5Utils;
import com.blog.vo.admin.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Override
    public User checkUser(String username, String password) {
                User user = userRepository.findByUsernameAndPassword(username, MD5Utils.code(password));
                return user;
    }
}


