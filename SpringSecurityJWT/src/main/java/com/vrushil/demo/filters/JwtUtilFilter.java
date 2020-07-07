package com.vrushil.demo.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.vrushil.demo.service.MyUserDetailsService;
import com.vrushil.demo.util.JwtUtil;
@Component
public class JwtUtilFilter extends OncePerRequestFilter {

	@Autowired
	MyUserDetailsService userDetailsService;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		final String authorizationheader= request.getHeader("Authorization");
		String username= null;
		String jwt= null;
		
		if(authorizationheader != null && authorizationheader.startsWith("Bearer"))
				{
			
			jwt= authorizationheader.substring(7);
			username= jwtUtil.extractUsername(jwt);
				}
		
		if (username!= null &&  SecurityContextHolder.getContext().getAuthentication()== null)
		{
			UserDetails userDetails=  this.userDetailsService.loadUserByUsername(username);
			if(jwtUtil.validateToken(jwt, userDetails))
			{
			UsernamePasswordAuthenticationToken upat=  new UsernamePasswordAuthenticationToken(userDetails,null, userDetails.getAuthorities());
			upat.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			SecurityContextHolder.getContext().setAuthentication(upat);
			}
			}
		filterChain.doFilter(request, response);
		
	}

}
