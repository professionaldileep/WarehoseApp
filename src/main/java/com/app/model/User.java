package com.app.model;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "usertab")
public class User {
	
	@GeneratedValue
	@Id
	@Column(name = "id")
	private Integer userId;
	
	@Column(name = "uname")
	private String userName;
	@Column(name = "uemail")
	private String userEmail;
	@Column(name = "upwd")
	private String userPwd;
	
	@Column(name = "roles")
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "user_roles_tab", joinColumns = @JoinColumn(name="id"))
	private Set<String> roles;

	public User() {
		super();
	}

	public User(Integer userId) {
		super();
		this.userId = userId;
	}

	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userPwd=" + userPwd
				+ ", roles=" + roles + "]";
	}
	
	
}
