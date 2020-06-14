package com.tl666.pojo;

import java.util.Date;

public class Achievement {
	private String count; //主键
	private String id; //对应学生的achievement_id
	private String course_name; // 学科名字
	private String score;// 分值
	private Date create_time; //创建时间
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}

	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Achievement [id=" + id + ", course_name=" + course_name + ", score=" + score + ", create_time="
				+ create_time + "]";
	}
	
}
