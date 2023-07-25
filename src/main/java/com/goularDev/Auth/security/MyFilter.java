package com.goularDev.Auth.security;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyFilter  extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		if (request.getHeader("Authorization")!=null) {
			Authentication auth = tokenUtil.decodeToken(request);
			if(auth!=null) {
				 SecurityContextHolder.getContext().setAuthentication(auth);
			}
			else {
				System.out.println("Erro no Token");
				ErroDTO erro = new ErroDTO(401,"Usuario não autorizado para este sistema");
				response.setStatus(erro.getStatus());
				response.setContentType("application/json");
				ObjectMapper mapper = new ObjectMapper();
				response.getWriter().print(mapper.writeValueAsString(erro));
				response.getWriter().flush();
				return;
				}	
		}
		//Passa a requisição pra frente
		 filterChain.doFilter(request, response);
	}
  
}
