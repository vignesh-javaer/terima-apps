package com.terima.todo.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.terima.todo.bean.TodoProfile;

@Component
public interface TodoRegisterService {

	public Long createTodo(TodoProfile todoProfile);
	
	public Optional<TodoProfile> getTodoProfileById(Long todoId);
	
	public List<TodoProfile> getAllTodoByUserId(Long todoId);
	
	public List<TodoProfile> getAllTodoByStatus(Long todoId, String status);
	
	public List<TodoProfile> getAllTodoByCloseDate(Long todoId, Date CloseDate);
	
	public TodoProfile updateTodoRegister(TodoProfile todoProfile);
}
