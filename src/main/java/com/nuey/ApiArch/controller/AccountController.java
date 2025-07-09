package com.nuey.ApiArch.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nuey.ApiArch.entity.User;
import com.nuey.ApiArch.service.AccountService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

	@PostMapping("/signup")
	public String singup(User user) {
		return accountService.signup(user) > 0 ? "success" : "failed";
	}
}
