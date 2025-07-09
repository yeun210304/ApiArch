package com.nuey.ApiArch.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
public class User {
    private String username;
	private String password;
	private String role;

    @Builder
    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
