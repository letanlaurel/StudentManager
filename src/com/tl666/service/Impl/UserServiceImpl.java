package com.tl666.service.Impl;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tl666.dao.IUserMapper;
import com.tl666.pojo.Achievement;
import com.tl666.pojo.Admin;
import com.tl666.pojo.Appendix;
import com.tl666.pojo.Department;
import com.tl666.pojo.LoginTemplate;
import com.tl666.pojo.Student;
import com.tl666.pojo.Teacher;
import com.tl666.service.IUserService;
@Service
public class UserServiceImpl implements IUserService {
	@Autowired//自动装配,spring会在ioc容器中找该类型，如果有就自动注入，但前提是该类必须有set方法
	private IUserMapper iUserMapper;

	@Override
	public Admin adminLoginService(LoginTemplate admin) {
		return iUserMapper.adminLogin(admin);
	}

	@Override
	public boolean addStudentService(Student student) {
		return iUserMapper.addStudent(student);
	}

	@Override
	public boolean updateStudentService(Student student) {
		return iUserMapper.updateStudent(student);
	}

	@Override
	public boolean delStudentService(String id) {
		return iUserMapper.delStudent(id);
	}

	@Override
	public Student getStudentService(String id) {
		return iUserMapper.getStudent(id);
	}

	@Override
	public boolean addTeacherService(Teacher teacher) {
		return iUserMapper.addTeacher(teacher);
	}

	@Override
	public boolean delTeacherService(String id) {
		return iUserMapper.delTeacher(id);
	}

	@Override
	public Teacher getTeacherService(String id) {
		return iUserMapper.getTeacher(id);
	}

	@Override
	public Student studentLoginService(LoginTemplate student) {
		return iUserMapper.studentLogin(student);
	}

	@Override
	public Teacher teacherLoginService(LoginTemplate teacher) {
		return iUserMapper.teacherLogin(teacher);
	}

	@Override
	public List<Student> getListStudentService() {
		return iUserMapper.getListStudent();
	}

	@Override
	public List<Teacher> getListTeacherService() {
		return iUserMapper.getListTeacher();
	}

	@Override
	public List<Department> getListDepartmentService() {
		return iUserMapper.getListDepartment();
	}

	@Override
	public boolean updatePwdService(LoginTemplate loginTemplate) {
		boolean b = false;
		if(loginTemplate.getIdentity().equals("student"))
			b = iUserMapper.updatePwdByStudent(loginTemplate);
		else if(loginTemplate.getIdentity().equals("teacher"))
			b = iUserMapper.updatePwdByTeacher(loginTemplate);
		else if(loginTemplate.getIdentity().equals("admin"))
			b = iUserMapper.updatePwdByAdmin(loginTemplate);
		return b;
	}

	@Override
	public boolean updateMsgService(Student user) {
		boolean b = false;
		if(user.getIdentity().equals("student")) {
			b = iUserMapper.updateStudent(user);
		}else if(user.getIdentity().equals("teacher")) {
			b = iUserMapper.updateTeacher(user);
		}else if(user.getIdentity().equals("admin")) {
			b = iUserMapper.updateAdmin(user);
		}
		return b;
	}

	@Override
	public boolean addAchievement(Achievement achievement) {
		return iUserMapper.addAchievement(achievement);
	}

	@Override
	public boolean addAchievementId(String id, String achievement_id) {
		Map<String,Object> map = new HashMap<>();
		map.put("id", id);
		map.put("achievement_id", achievement_id);
		return iUserMapper.addAchievementId(map);
	}

	@Override
	public boolean updateAchievement(Achievement achievement) {
		return iUserMapper.updateAchievement(achievement);
	}

	@Override
	public boolean delAchievement(String count) {
		return iUserMapper.delAchievement(count);
	}

	@Override
	public List<Student> searchStudent(String text) {
		return iUserMapper.searchStudent(text);
	}

	@Override
	public boolean addDepartmentService(Department department) {
		return iUserMapper.addDepartment(department);
	}

	@Override
	public boolean updateDepartmentService(Department department) {
		return iUserMapper.updateDepartment(department);
	}

	@Override
	public boolean delDepartmentService(String id) {
		return iUserMapper.delDepartment(id);
	}

	@Override
	public List<Teacher> searchTeacher(String text) {
		return iUserMapper.searchTeacher(text);
	}

	@Override
	public Admin getAdminService(String id) {
		return iUserMapper.getAdmin(id);
	}

	@Override
	public List<Student> getDepStudentService(String department_id) {
		return iUserMapper.getDepStudent(department_id);
	}

	@Override
	public boolean initPwdService(Student user) {
		boolean b = false;
		if(user.getIdentity().equals("teacher"))
			b = iUserMapper.initPwdForTeacher(user);
		else if(user.getIdentity().equals("student"))
			b = iUserMapper.initPwdForStudent(user);
		return b;
	}

	@Override
	public boolean uploadService(Appendix appendix) {
		return iUserMapper.uploadFile(appendix);
	}

	@Override
	public boolean delAppendixService(String appendix_id) {
		return iUserMapper.delAppendix(appendix_id);
	}
	
}
