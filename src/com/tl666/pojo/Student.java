package com.tl666.pojo;

import java.util.Date;
import java.util.List;

/**
 * 学生实体类
 * @author 19760
 *
 */
public class Student {
	private Integer id; //主键
	private String name;//姓名
	private String sex;//性别
	private String username;//工号
	private String pwd;//密码
	private String phone;//手机号码
	private String email;//邮箱
	private String identity;//身份
	private String department_id;//院部id
	private String appendix_id;//附件id
	private String achievement_id;//成绩id
	private Date create_time;//创建时间
	private Appendix appendix;//附件
	private Department department;//院部
	private List<Achievement> achievementList;
	
	public Appendix getAppendix() {
		return appendix;
	}
	public void setAppendix(Appendix appendix) {
		this.appendix = appendix;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public List<Achievement> getAchievementList() {
		return achievementList;
	}
	public void setAchievementList(List<Achievement> achievementList) {
		this.achievementList = achievementList;
	}
	
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(String department_id) {
		this.department_id = department_id;
	}
	
	public String getAppendix_id() {
		return appendix_id;
	}
	public void setAppendix_id(String appendix_id) {
		this.appendix_id = appendix_id;
	}
	public String getAchievement_id() {
		return achievement_id;
	}
	public void setAchievement_id(String achievement_id) {
		this.achievement_id = achievement_id;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", sex=" + sex + ", username=" + username + ", pwd=" + pwd
				+ ", phone=" + phone + ", email=" + email + ", identity=" + identity + ", department_id="
				+ department_id + ", create_time=" + create_time + ", appendix=" + appendix + ", department="
				+ department + ", achievementList=" + achievementList + "]";
	}
	
	

	
}
