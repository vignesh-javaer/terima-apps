package com.terima.todo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.terima.todo.bean.TodoProfile;
import com.terima.todo.bean.UserProfile;

/**
 * @author vignesh
 *
 */
@Component
public interface TodoRegisterDao extends CrudRepository<TodoProfile, Long>{

}
