package com.tl666.pojo;

import java.util.Date;

public class Department {
	private Integer id;//对应老师，学生的department_id
	private String department_name; //院部名称
	private Date create_time;//创建时间
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", department_name=" + department_name + ", create_time=" + create_time + "]";
	}
	
}
