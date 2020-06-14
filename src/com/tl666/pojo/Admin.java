package com.tl666.pojo;

public class Admin {
	private Integer id; //主键
	private String name;//姓名
	private String username;//工号
	private String pwd;//密码
	private String identity; //身份
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", username=" + username + ", pwd=" + pwd + ", identity="
				+ identity + "]";
	}
	
	
}
