package com.example.jwt.service.impl;

import com.example.jwt.dao.UserDAO;
import com.example.jwt.entity.User;
import com.example.jwt.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User login(User user){
        //根据接受的用户名密码查询数据库
        User userDB=userDAO.login(user);
        if(userDB!=null){
            return userDB;
        }
        throw new RuntimeException("登录失败");
    }
}
