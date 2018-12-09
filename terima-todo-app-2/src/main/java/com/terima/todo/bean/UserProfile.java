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
@Table(name="user_profile")
@JsonIgnoreProperties(ignoreUnknown=true)
@Getter @Setter @ToString
public class UserProfile implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2971548771845823538L;

	@Id
	@GenericGenerator(name="uid-generator",strategy="com.terima.todo.generators.UserIdGenerators")
	@GeneratedValue(generator="uid-generator")
	@Column(name="user_id")
	private Long userId;
	
	@NonNull
	@Column(name="user_name")
	private String userName;
	
	@NonNull
	@Column(name="user_pwe")
	private String userpwe;

	
	@Column(name="last_login")
	private Date userLastLogin;


	public UserProfile() {
		super();
	}

}
