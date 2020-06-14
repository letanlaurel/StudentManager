package com.tl666.pojo;

import java.util.Date;
/**
 * 附件实体类
 * @author 19760
 *
 */
public class Appendix {
	private String id; //关联老师，学生的appendix_id
	private String path; //文件路径
	private Date create_time; //创建时间
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	@Override
	public String toString() {
		return "Appendix [id=" + id + ", path=" + path + ", create_time=" + create_time + "]";
	}
	
}
