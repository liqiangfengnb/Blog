package com.blog.mapper.home;

import com.blog.vo.home.User2;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iUserRepository extends JpaRepository<User2, Long>{
}
