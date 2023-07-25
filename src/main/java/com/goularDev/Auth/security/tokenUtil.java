package com.goularDev.Auth.security;

import java.util.Collections;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import jakarta.servlet.http.HttpServletRequest;

public class tokenUtil {
 
	public static Authentication decodeToken(HttpServletRequest request){
		if(request.getHeader("Authorization").equals("Bearer *gabriel123")) {
			return new UsernamePasswordAuthenticationToken("User",null,Collections.emptyList());
		}
		return null;
	}
	
}
