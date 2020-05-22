package com.blog.Service.home;

import com.blog.mapper.home.UserRepository2;
import com.blog.util.MD5Utils;
import com.blog.vo.home.User2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl2 implements UserService2 {

    @Autowired
    private UserRepository2 userRepository2;
    @Override
    public User2 checkUser2(String username, String password) {
                User2 user2 = userRepository2.findByUsernameAndPassword(username, MD5Utils.code(password));
                return user2;
    }
}


