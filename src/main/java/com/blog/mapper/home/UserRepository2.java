package com.blog.mapper.home;

import com.blog.vo.home.User2;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository2 extends JpaRepository<User2,Long> {
    User2 findByUsernameAndPassword(String username, String password);

}
