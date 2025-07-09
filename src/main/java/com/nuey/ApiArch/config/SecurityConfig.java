package com.nuey.ApiArch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
	public BCryptPasswordEncoder bcryptPasswordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		// jwt방식은 상태 stateless로 관리하기 때문에 csrf를 방어하지 않아도 되서 disabled
		http
			.csrf(auth -> auth.disable());

		// form 로그인 방식 disable
		http
			.formLogin(auth -> auth.disable());

		// http basic 인증 방식 disable
		http
			.httpBasic(auth -> auth.disable());

		// 경로별 인가 작업
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/login", "/signup").permitAll()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/my/**").hasAnyRole("USER", "ADMIN")
                .anyRequest().denyAll()
            );

		// session
		http
			.sessionManagement(session -> session
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();

    }
}
