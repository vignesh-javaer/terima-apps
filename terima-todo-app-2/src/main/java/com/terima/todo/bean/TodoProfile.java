/**
 * 
 */
package com.terima.todo.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

/**
 * @author vignesh
 *
 */
@Entity
@Table(name="todo_profile")
@JsonIgnoreProperties(ignoreUnknown=true)
@Getter @Setter @ToString
public class TodoProfile implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4882125398362555981L;

	@Id
	@GeneratedValue(generator="todoid-generator")
	@GenericGenerator(name="todoid-generator",strategy="com.terima.todo.generators.TodoIdGenerators")
	@Column(name="todo_id")
	private Long todoId;
	
	@NonNull
	@Column(name="user_id")
	private Long userId;
	
	@NonNull
	@Column(name="todo_title")
	private String title;
	
	@NonNull
	@Column(name="todo_desc")
	private String description;
	
	@NonNull
	@Column(name="todo_created")
	private Date created;
	
	@NonNull
	@Column(name="todo_status")
	private String status;
	
	@NonNull
	@Column(name="todo_close_dt")
	private Date closeDt;
	
	public TodoProfile() {
		super();
	}
	
	
	
}
