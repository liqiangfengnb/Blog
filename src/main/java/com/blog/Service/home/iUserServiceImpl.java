package com.blog.Service.home;


import com.blog.mapper.home.iUserRepository;
import com.blog.vo.home.User2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class iUserServiceImpl implements iUserService{

    @Autowired
    private iUserRepository iuserRepository;

    @Override
    public List<User2> iuser() {
        return iuserRepository.findAll();
    }
}
