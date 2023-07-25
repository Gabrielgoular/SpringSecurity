package com.goularDev.Auth.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class MySecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()  //desabilito o csrf(vou tratar a autenticação dos usuarios)
			.authorizeHttpRequests()      //agora as requisições http são passiveis de automatização
			.requestMatchers(HttpMethod.GET,"/free").permitAll() // especificando quem vai ter acesso 
			.anyRequest().authenticated().and().cors();//todas as outras URLs terão necessidade de autenticação 
			
			http.addFilterBefore(new MyFilter(), UsernamePasswordAuthenticationFilter.class);
			return http.build();
	}
}
