/**
 * 
 */
package com.terima.todo.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import com.terima.todo.bean.TodoProfile;

/**
 * @author vignesh
 *
 */
public interface TodoRegisterResource {

	@Deprecated
	public String test();

	public ResponseEntity<?> createTodoRegister(final TodoProfile todo, final UriComponentsBuilder ucBuilder);

	public ResponseEntity<?> updateTaskStatus(final Long taskId, final String taskStatus, final UriComponentsBuilder ucBuilder);
	
}
