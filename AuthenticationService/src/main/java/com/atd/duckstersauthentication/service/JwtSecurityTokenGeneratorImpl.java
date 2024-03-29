package com.atd.duckstersauthentication.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.atd.duckstersauthentication.model.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtSecurityTokenGeneratorImpl implements SecurityTokenGenerator {

	public JwtSecurityTokenGeneratorImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Map<String, String> generateToken(User user) {
		// TODO Auto-generated method stub
		String jwtToken = "";
		jwtToken = Jwts.builder().
				setSubject(user.getUserId())
				.setIssuedAt(new Date())
				.signWith(SignatureAlgorithm.HS256, "secretkey")
				.compact();
		Map<String, String> map = new HashMap<>();
		map.put("token", jwtToken);
		map.put("message", "User successfully logged in");

		return map;
	}

}
