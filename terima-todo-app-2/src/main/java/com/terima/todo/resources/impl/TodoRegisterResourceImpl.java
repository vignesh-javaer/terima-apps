/**
 * 
 */
package com.terima.todo.resources.impl;

import java.util.Optional;

import javax.ws.rs.QueryParam;

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
import com.terima.todo.exceptions.CustomTypeError;
import com.terima.todo.resources.TodoRegisterResource;
import com.terima.todo.service.impl.TodoProfileRegisterServiceImpl;

/**
 * @author vignesh
 *
 */
@RestController
@RequestMapping("/todo")
public class TodoRegisterResourceImpl implements TodoRegisterResource {

	@Autowired
	private TodoProfileRegisterServiceImpl todoRegister;

	@Override
	@Deprecated
	@GetMapping("/test")
	public String test() {
		return "Testing successful...";
	}

	@Override
	@PostMapping("/create")
	public ResponseEntity<?> createTodoRegister(@RequestBody TodoProfile todo, UriComponentsBuilder ucBuilder) {
		final Long todoId = todoRegister.createTodo(todo);
		final HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/todo/{todoId}").buildAndExpand(todoId).toUri());
		if (todoId == null) {
			return new ResponseEntity<Object>(new CustomTypeError("Todo Profile not created for todoId : " + todoId),
					HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<TodoProfile>(headers, HttpStatus.CREATED);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	@PostMapping("/update")
	public ResponseEntity<TodoProfile> updateTaskStatus(@QueryParam("todoId") Long todoId, @QueryParam("status") String status, UriComponentsBuilder ucBuilder) {
		Optional<TodoProfile> todoProf = todoRegister.getTodoProfileById(todoId);
		if (todoProf.isPresent()) {
			TodoProfile todoProfile = todoProf.get();
			todoProfile.setStatus(status);
			TodoProfile todoUpdated = todoRegister.updateTodoRegister(todoProfile);
			final HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/profiles/{userId}").buildAndExpand(todoUpdated.getTodoId()).toUri());
			return new ResponseEntity<TodoProfile>(headers, HttpStatus.OK);
		}
		return new ResponseEntity(new CustomTypeError("Cannot find Todo Profile for TODO_ID: " + todoId),
				HttpStatus.EXPECTATION_FAILED);
	}

}
