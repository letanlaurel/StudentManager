package com.tl666.service;

import java.util.List;


import com.tl666.pojo.Achievement;
import com.tl666.pojo.Admin;
import com.tl666.pojo.Appendix;
import com.tl666.pojo.Department;
import com.tl666.pojo.LoginTemplate;
import com.tl666.pojo.Student;
import com.tl666.pojo.Teacher;

public interface IUserService {
	/**
	 *      管理员登录
	 * @param admin
	 * @return
	 */
	Admin adminLoginService(LoginTemplate admin);
	
	/**
	 * 添加学生
	 * @param student
	 * @return
	 */
	boolean addStudentService(Student student);
	
	/**
	 * 修改学生
	 * @param student
	 * @return
	 */
	boolean updateStudentService(Student student);
	
	/**
	 * 删除学生
	 * @param id
	 * @return
	 */
	boolean delStudentService(String id);
	
	/**
	 * 获取学生个人信息
	 * @param id
	 * @return
	 */
	Student getStudentService(String id);
	
	/**
	 *     添加老师
	 * @param student
	 * @return
	 */
	boolean addTeacherService(Teacher teacher);
	
	
	/**
	 * 删除教师
	 * @param id
	 * @return
	 */
	boolean delTeacherService(String id);
	
	/**
	 * 获取教师个人信息
	 * @param id
	 * @return
	 */
	Teacher getTeacherService(String id);
	
	/**
	 *      学生登录
	 * @param admin
	 * @return
	 */
	Student studentLoginService(LoginTemplate student);
	
	/**
	 *      老师登录
	 * @param admin
	 * @return
	 */
	Teacher teacherLoginService(LoginTemplate teacher);
	
	/**
	 * 获取所有学生信息
	 * @return
	 */
	List<Student> getListStudentService();
	/**
	 * 获取所有老师信息
	 * @return
	 */
	List<Teacher> getListTeacherService();
	
	/**
	 * 获取所有院部信息
	 * @return
	 */
	List<Department> getListDepartmentService();
	
	/**
	 *   修改密码
	 * @return
	 */
	boolean updatePwdService(LoginTemplate loginTemplate);
	
	/**
	 * 修改个人信息
	 * @param student
	 * @return
	 */
	boolean updateMsgService(Student student);
	
	/**
	 * 添加成绩
	 */
	boolean addAchievement(Achievement achievement);
	boolean addAchievementId(String id,String department_id);
	
	/**
	 * 修改成绩
	 * @param achievement
	 * @return
	 */
	boolean updateAchievement(Achievement achievement);
	/**
	 * 删除成绩
	 * @param count
	 */
	boolean delAchievement(String count);

	List<Student> searchStudent(String text);
	/**
	 * 添加院部
	 * @param department
	 * @return
	 */
	boolean addDepartmentService(Department department);
	
	/**
	 * 修改院部
	 * @param department
	 * @return
	 */
	boolean updateDepartmentService(Department department);
	
	/**
	 * 删除院部
	 * @param department
	 * @return
	 */
	boolean delDepartmentService(String id);
	/**
	 * 搜索教师
	 * @param text
	 * @return
	 */
	List<Teacher> searchTeacher(String text);
	/**
	 * 获取管理员信息
	 * @param string
	 * @return
	 */
	Admin getAdminService(String string);
	/**
	 * 获取院部学生信息
	 * @return
	 */
	List<Student> getDepStudentService(String department_id);
	/**
	 * 重置密码
	 * @param user
	 * @return
	 */
	boolean initPwdService(Student user);
	
	/**
	 * 上传文件
	 * @param user
	 * @return
	 */
	boolean uploadService(Appendix appendix);
	/**
	 * 删除附件
	 * @param appendix_id
	 * @return
	 */
	boolean delAppendixService(String appendix_id);
}
