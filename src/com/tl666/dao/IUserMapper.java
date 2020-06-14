package com.tl666.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.tl666.pojo.Achievement;
import com.tl666.pojo.Admin;
import com.tl666.pojo.Appendix;
import com.tl666.pojo.Department;
import com.tl666.pojo.LoginTemplate;
import com.tl666.pojo.Student;
import com.tl666.pojo.Teacher;

public interface IUserMapper {
	/**
	 *      管理员登录
	 * @param admin
	 * @return
	 */
	@Select("select * from admin where username = #{username} and pwd = #{pwd}")
	Admin adminLogin(LoginTemplate admin);
	
	/**
	 * 添加学生
	 * @param student
	 * @return
	 */
	@Insert("insert into student (name,sex,username,pwd,phone,email,create_time,department_id,appendix_id,achievement_id)"
			+ "values(#{name},#{sex},#{username},#{pwd},#{phone},#{email},#{create_time},#{department_id},#{appendix_id},#{achievement_id})")
	boolean addStudent(Student student);
	
	/**
	 * 修改学生
	 * @param student
	 * @return
	 */
	@Update("update student set name = #{name},sex=#{sex},phone=#{phone},email=#{email},create_time = #{create_time}"
			+ ",department_id=#{department_id} where id = #{id}")
	boolean updateStudent(Student student);
	
	/**
	 * 删除学生
	 * @param id
	 * @return
	 */
	@Delete("delete from student where id = #{id}")
	boolean delStudent(String id);
	
	/**
	 * 获取学生个人信息
	 * @param id
	 * @return
	 */
	Student getStudent(String id);
	
	/**
	 *     添加老师
	 * @param student
	 * @return
	 */
	@Insert("insert into teacher (name,sex,username,pwd,phone,email,create_time,department_id,appendix_id)"
			+ "values(#{name},#{sex},#{username},#{pwd},#{phone},#{email},#{create_time},#{department_id},#{appendix_id})")
	boolean addTeacher(Teacher teacher);
	
	/**
	 * 修改教师
	 * @param student
	 * @return
	 */
	@Update("update teacher set name = #{name},sex=#{sex},phone=#{phone},email=#{email},create_time = #{create_time}"
			+ ",department_id=#{department_id} where id = #{id}")
	boolean updateTeacher(Student teacher);
	
	/**
	 * 删除教师
	 * @param id
	 * @return
	 */
	@Delete("delete from teacher where id = #{id}")
	boolean delTeacher(String id);
	
	/**
	 * 获取教师个人信息
	 * @param id
	 * @return
	 */
	Teacher getTeacher(String id);
	
	/**
	 *      学生登录
	 * @param admin
	 * @return
	 */
	Student studentLogin(LoginTemplate student);
	
	/**
	 *      老师登录
	 * @param admin
	 * @return
	 */
	Teacher teacherLogin(LoginTemplate teacher);
	
	/**
	 * 获取所有学生信息
	 * @return
	 */
	List<Student> getListStudent();
	
	/**
	 * 获取所有教师信息
	 * @return
	 */
	List<Teacher> getListTeacher();
	
	/**
	 * 获取所有院部信息
	 * @return
	 */
	@Select("select * from department")
	List<Department> getListDepartment();
	
	/**
	 *   修改密码
	 * @return
	 */
	@Update("update student set pwd = #{pwd} where username = #{username}")
	boolean updatePwdByStudent(LoginTemplate loginTemplate);
	
	/**
	 *   修改密码
	 * @return
	 */
	@Update("update teacher set pwd = #{pwd} where username = #{username}")
	boolean updatePwdByTeacher(LoginTemplate loginTemplate);
	
	/**
	 *   修改密码
	 * @return
	 */
	@Update("update admin set pwd = #{pwd} where username = #{username}")
	boolean updatePwdByAdmin(LoginTemplate loginTemplate);
	
	/**
	 * 添加成绩
	 */
	@Insert("insert into achievement (id,course_name,score,create_time) values(#{id},#{course_name},#{score},#{create_time})")
	boolean addAchievement(Achievement achievement);
	@Update("update student set achievement_id = #{achievement_id} where id = #{id}")
	boolean addAchievementId(Map<String,Object> map);
	
	/**
	 * 修改成绩
	 * @param achievement
	 * @return
	 */
	@Update("update achievement set course_name = #{course_name},score=#{score} where count = #{count} and id=#{id}")
	boolean updateAchievement(Achievement achievement);
	
	/**
	 * 删除成绩
	 * @param count
	 * @return
	 */
	@Delete("delete from achievement where count = #{count}")
	boolean delAchievement(String count);
	
	/**
	 * 搜索学生列表
	 * @param text
	 * @return
	 */
	List<Student> searchStudent(String text);
	
	/**
	 * 添加院部
	 * @param department
	 * @return
	 */
	@Insert("insert into department (department_name,create_time) values(#{department_name},#{create_time})")
	boolean addDepartment(Department department);
	/**
	 * 修改院部
	 * @param department
	 * @return
	 */
	@Update("update department set department_name = #{department_name},create_time=#{create_time} where id = #{id}")
	boolean updateDepartment(Department department);
	
	/**
	 * 删除院部
	 * @param department
	 * @return
	 */
	@Delete("delete from department where id = #{id}")
	boolean delDepartment(String id);
	/**
	 * 搜索教师
	 * @param text
	 * @return
	 */
	List<Teacher> searchTeacher(String text);
	/**
	 * 获取管理员信息
	 * @param id
	 * @return
	 */
	@Select("select * from admin where id = #{id}")
	Admin getAdmin(String id);
	
	/**
	 * 修改管理员信息
	 * @param admin
	 * @return
	 */
	@Update("update admin set name=#{name} where id = #{id}")
	boolean updateAdmin(Student admin);
	/**
	 * 获取院部学生信息
	 * @param department_id
	 * @return
	 */
	List<Student> getDepStudent(String department_id);
	
	/**
	 * 重置教师密码
	 * @param user
	 * @return
	 */
	@Update("update teacher set pwd = #{username} where username = #{username}")
	boolean initPwdForTeacher(Student user);
	
	/**
	 * 重置学生密码
	 * @param user
	 * @return
	 */
	@Update("update student set pwd = #{username} where username = #{username}")
	boolean initPwdForStudent(Student user);
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	@Insert("insert into appendix (id,path,create_time) values(#{id},#{path},#{create_time})")
	boolean uploadFile(Appendix appendix);
	
	/**
	 * 删除附件
	 * @param appendix_id
	 * @return
	 */
	@Delete("delete from appendix where id = #{appendix_id}")
	boolean delAppendix(String appendix_id);
}
