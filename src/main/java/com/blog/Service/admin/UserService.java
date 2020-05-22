package com.blog.Service.admin;

import com.blog.vo.admin.User;

public interface UserService {
    User checkUser(String username, String password);
}
