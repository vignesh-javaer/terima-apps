package com.terima.todo.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.terima.todo.bean.UserProfile;


/**
 * @author VIGNESH
 *
 */
@Component
public interface UserProfileRegisterService {

	public Long createProfile(UserProfile userProfile);
	
	public UserProfile fetchUser(Long userId);
	
	public List<UserProfile> fetchAllUsers();
	
	public boolean deleteUser(Long userId);
	
	public Long countUsers();
}
