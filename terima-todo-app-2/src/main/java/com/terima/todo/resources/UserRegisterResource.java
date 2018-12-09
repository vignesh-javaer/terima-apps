package com.terima.todo.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import com.terima.todo.bean.UserProfile;

public interface UserRegisterResource {

	@Deprecated
	public String test();

	public ResponseEntity<?> createUserRegister(final UserProfile user, final UriComponentsBuilder ucBuilder);

}
