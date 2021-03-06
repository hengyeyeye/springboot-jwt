package com.example.jwt.dao;

import com.example.jwt.entity.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserDAO {
    User login(User user);
}
