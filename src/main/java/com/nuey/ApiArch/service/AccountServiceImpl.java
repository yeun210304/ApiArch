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
        String username = user.getUsername();
		boolean isExist = this.existsByUsername(username);
		if (isExist) {
			return 0;
		}

        User data = User.builder()
            .username(username)
            .password(passwordEncoder.encode(user.getPassword()))
            .role(user.getRole() != null ? user.getRole() : "ROLE_USER")
            .build();

		return accountMapper.insertUser(data);
    }

    public boolean existsByUsername(String username) {
		return accountMapper.existsByUsername(username);
	}
}
