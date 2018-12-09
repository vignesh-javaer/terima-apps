/**
 * 
 */
package com.terima.todo.resources.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.terima.todo.bean.TodoProfile;
import com.terima.todo.bean.UserProfile;
import com.terima.todo.exceptions.CustomTypeError;
import com.terima.todo.resources.UserRegisterResource;
import com.terima.todo.service.impl.UserProfileRegisterServiceImpl;

/**
 * @author vignesh
 *
 */
@RestController
@RequestMapping("/users")
public class UserRegisterResourceImpl implements UserRegisterResource {

	
	@Autowired private UserProfileRegisterServiceImpl userRegister;
	
	@Override
	@Deprecated
	@GetMapping("/test")
	public String test() {
		return "Test Successfull..";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	@PostMapping("/create")
	public ResponseEntity<UserProfile> createUserRegister(@RequestBody UserProfile user, UriComponentsBuilder ucBuilder) {
		final Long userId = userRegister.createProfile(user);
		final HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/users/{userId}").buildAndExpand(userId).toUri());
		if (userId == null) {
			return new ResponseEntity(new CustomTypeError("User Profile not created!"),
					HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<UserProfile>(headers, HttpStatus.CREATED);

	}

}
