package com.nuey.ApiArch.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.nuey.ApiArch.entity.User;

@Mapper
public interface AccountMapper {

    public int insertUser(User user);

    public int existsByUsername(String username);
}
