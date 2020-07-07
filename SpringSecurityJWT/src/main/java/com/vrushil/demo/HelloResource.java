
package com.vrushil.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vrushil.demo.models.AuthenticationRequest;
import com.vrushil.demo.models.AuthenticationResponse;
import com.vrushil.demo.service.MyUserDetailsService;
import com.vrushil.demo.util.JwtUtil;

@RestController
public class HelloResource {
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	@Autowired
	JwtUtil jwtUtil;
	
	@RequestMapping({"/hello"})
	public String hello()
	{
	return "Hello World";
	
	}
	
	@RequestMapping(value="/authenticate", method= RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationrequest) throws Exception
	{
		try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationrequest.getUsername(), authenticationrequest.getPassword()));
		}
		catch (BadCredentialsException e) {
			// TODO: handle exception
			throw new Exception("Incorrect username or password "+e);
		}
		
		final UserDetails userDetails= userDetailsService.loadUserByUsername(authenticationrequest.getUsername());
		
		final String jwt= jwtUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
		}
}
