package com.nuey.ApiArch.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nuey.ApiArch.entity.User;
import com.nuey.ApiArch.mapper.AccountMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountMapper accountMapper;

	private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public int signup(User user) {
        return 0;
    }

    public boolean existsByUsername(String username) {
		
		return false;
	}
}
