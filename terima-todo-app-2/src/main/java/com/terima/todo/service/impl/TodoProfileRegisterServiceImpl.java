package com.terima.todo.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.terima.todo.bean.TodoProfile;
import com.terima.todo.dao.TodoRegisterDao;
import com.terima.todo.service.TodoRegisterService;

@Repository
@Transactional
public class TodoProfileRegisterServiceImpl implements TodoRegisterService {

	
	@Autowired private TodoRegisterDao todoRegister;
	
	@Override
	public Long createTodo(TodoProfile todoProfile) {
		Long todoId = todoRegister.save(todoProfile).getTodoId();
		return todoId;
	}

	@Override
	public List<TodoProfile> getAllTodoByUserId(Long todoId) {
		return null;
	}

	@Override
	public List<TodoProfile> getAllTodoByStatus(Long todoId, String status) {
		return null;
	}

	@Override
	public List<TodoProfile> getAllTodoByCloseDate(Long todoId, Date closeDate) {
		return null;
	}

	@Override
	public TodoProfile updateTodoRegister(TodoProfile todoProfile) {
		return todoRegister.save(todoProfile);
		
	}

	@Override
	public Optional<TodoProfile> getTodoProfileById(Long todoId) {
		return todoRegister.findById(todoId);
	}

	
}
