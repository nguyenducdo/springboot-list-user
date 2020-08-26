package training.model;

import training.entity.UserEntity;

public class UserModel {
	
	private Long id;
	private String username;
	private String password;
	private UserEntity.Role role;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserEntity.Role getRole() {
		return role;
	}
	public void setRole(UserEntity.Role role) {
		this.role = role;
	}
}
