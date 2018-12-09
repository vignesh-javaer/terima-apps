package com.terima.todo.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.terima.todo.bean.UserProfile;
import com.terima.todo.dao.UserRegisterDao;
import com.terima.todo.service.UserProfileRegisterService;

@Repository
@Transactional
public class UserProfileRegisterServiceImpl implements UserProfileRegisterService {

	
	@Autowired private UserRegisterDao userRegister;
	
	@Override
	public Long createProfile(UserProfile user) {
		Long userId = userRegister.save(user).getUserId();
		return userId;
	}

	@Override
	public UserProfile fetchUser(Long userId) {
		return null;
	}

	@Override
	public List<UserProfile> fetchAllUsers() {
		return null;
	}

	@Override
	public boolean deleteUser(Long userId) {
		return false;
	}

	@Override
	public Long countUsers() {
		return null;
	}

}
