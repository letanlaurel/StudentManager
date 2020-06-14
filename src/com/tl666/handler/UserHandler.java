package com.tl666.handler;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.tl666.pojo.Achievement;
import com.tl666.pojo.Admin;
import com.tl666.pojo.Appendix;
import com.tl666.pojo.Department;
import com.tl666.pojo.LoginTemplate;
import com.tl666.pojo.Student;
import com.tl666.pojo.Teacher;
import com.tl666.service.IUserService;
import com.tl666.util.FilePath;
import com.tl666.util.TLFileUploadUtil;

@RequestMapping("UserHandler")
@Controller
@SessionAttributes(value = { "student", "teacher", "admin", "departmentList" })
public class UserHandler {
	@Autowired // 自动装配,spring会在ioc容器中找该类型，如果有就自动注入
	IUserService userService;
	
	@Resource
	FilePath filePath;
	
	
	/**
	 * 获取所有学生信息
	 * 
	 * @param identity
	 * @return
	 */
	@GetMapping("showAllStudent")
	public ModelAndView showAllStudent() {
		String type = "admin-index";
		ModelAndView view = new ModelAndView(type);
		List<Student> studentList = userService.getListStudentService();
		view.addObject("studentList", studentList);
		return view;
	}

	
	/**
	 * 获取院部学生信息
	 * 
	 * @param identity
	 * @return
	 */
	@GetMapping("showDepStudent")
	public ModelAndView showDepStudent(HttpSession session) {
		String type = "tea-index";
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		ModelAndView view = new ModelAndView(type);
		List<Student> studentDepList = userService.getDepStudentService(teacher.getDepartment_id());
		view.addObject("studentDepList", studentDepList);
		return view;
	}

	/**
	 * 退出登录
	 * 
	 * @param session
	 * @return
	 */
	@GetMapping("loginout")
	public ModelAndView loginout(HttpSession session,SessionStatus sessionStatus) {
		ModelAndView view = new ModelAndView("login");
		session.invalidate();
		sessionStatus.setComplete();//@SessionAttributes这个注解会影响退出，这句代码意思是清空@SessionAttributes
		return view;
	}

	/**
	 * 查看成绩
	 * 
	 * @param request
	 * @return
	 */
	@GetMapping("showAchievement")
	public ModelAndView showAchievement(HttpServletRequest request) {
		ModelAndView view = new ModelAndView("show-achievement");
		String stu_id = request.getParameter("stu_id");
		Student student = userService.getStudentService(stu_id);
		view.addObject("student", student);
		return view;
	}

//	/**
//	 * 查看个人信息
//	 * @param session
//	 * @return
//	 */
//	
//	@GetMapping("intoPersonal")
//	public ModelAndView intoPersonal(HttpSession session) {
//		ModelAndView view = new ModelAndView("personal-msg");
//		Teacher teacher = (Teacher)session.getAttribute("teacher");
//		Student student = (Student)session.getAttribute("student");
//		if(teacher != null) {
//			view.addObject("teacher",teacher);
//		} else if(student != null) {
//			view.addObject("student",student);
//		}	
//		return view;
//	}

	/**
	 * 修改个人信息
	 * 
	 * @param student
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@PostMapping("updateMsg")
	public ModelAndView updateMsg(Student student, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		System.out.println("ABCD" + student);
		student.setCreate_time(new Date());
		ModelAndView view = new ModelAndView();
		boolean b = userService.updateMsgService(student);
		if (student.getIdentity().equals("student")) {
			Student stu = userService.getStudentService(student.getId().toString());
			System.out.println("EEEF" + stu);
			view.addObject("student", stu);
			view.setViewName("student-msg");
		} else if (student.getIdentity().equals("teacher")) {
			Teacher tea = userService.getTeacherService(student.getId().toString());
			System.out.println("EEEF" + tea);
			view.addObject("teacher", tea);
			view.setViewName("teacher-msg");
		} else if (student.getIdentity().equals("admin")) {
			Admin admin = userService.getAdminService(student.getId().toString());
			view.addObject("admin", admin);
			view.setViewName("admin-msg");
		}
		view.addObject("update_status", b);
		return view;
	}

	/**
	 * 修改密码
	 * 
	 * @param loginTemplate
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@PostMapping("updatePwd")
	public ModelAndView updatePwd(LoginTemplate loginTemplate, HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		System.out.println(loginTemplate);
		ModelAndView md = new ModelAndView();
		boolean b = userService.updatePwdService(loginTemplate);
		if (loginTemplate.getIdentity().equals("student")) {
			md.setViewName("student-msg");
		} else if (loginTemplate.getIdentity().equals("teacher")) {
			md.setViewName("teacher-msg");
		} else if (loginTemplate.getIdentity().equals("admin")) {
			md.setViewName("admin-msg");
		}
		md.addObject("update_status", b);
		return md;
	}

	/**
	 * 登录
	 * 
	 * @param loginTemplate 登录模板，包含用户名 密码 身份
	 * @return
	 */
	@PostMapping("login")
	public ModelAndView login(LoginTemplate loginTemplate) {
		System.out.println(loginTemplate);
		ModelAndView view = new ModelAndView();
		List<Department> departmentList = userService.getListDepartmentService();
		view.addObject("departmentList", departmentList);
		if (loginTemplate.getIdentity().equals("student")) {
			Student student = userService.studentLoginService(loginTemplate);
			if (student != null) {
				view.setViewName("stu-index");
				view.addObject("student", student);
			} else {
				view.setViewName("login");
				view.addObject("login_status", "用户名或密码错误");
			}

		} else if (loginTemplate.getIdentity().equals("teacher")) {
			Teacher teacher = userService.teacherLoginService(loginTemplate);
			if (teacher != null) {
				view.setViewName("tea-index");
				view.addObject("teacher", teacher);
				List<Student> studentList = userService.getDepStudentService(teacher.getDepartment_id());
				view.addObject("studentDepList", studentList);
			} else {
//				view.setViewName("redirect:/jsp/login.jsp");
				view.setViewName("login");
				view.addObject("login_status", "用户名或密码错误");
			}
		} else if (loginTemplate.getIdentity().equals("admin")) {
			Admin admin = userService.adminLoginService(loginTemplate);
			if (admin != null) {
				view.setViewName("admin-index");
				List<Student> studentList = userService.getListStudentService();
				view.addObject("studentList", studentList);
				view.addObject("admin", admin);
			} else {
				view.setViewName("login");
				view.addObject("login_status", "用户名或密码错误");
			}
		}
		return view;
	}

	/**
	 * 添加学生
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping("addStudent")
	public ModelAndView addStudent(Student student) {
		String uid = UUID.randomUUID().toString().replaceAll("-", "");
		ModelAndView view = new ModelAndView("add-student");
		student.setCreate_time(new Date());
		student.setPwd(student.getUsername());
		student.setAppendix_id(uid);
		student.setAchievement_id(uid);
		System.out.println(student);
		boolean b = userService.addStudentService(student);
		List<Department> departmentList = userService.getListDepartmentService();
		view.addObject("departmentList", departmentList);
		view.addObject("update_status", b);
		return view;
	}

	/**
	 * 进入修改学生页面
	 * 
	 * @param request
	 * @return
	 */
	@GetMapping("intoUpdateStudent")
	public ModelAndView intoUpdateStudent(Student student) {
		ModelAndView view = new ModelAndView("update-student");
		Student stu = userService.getStudentService(student.getId().toString());
		view.addObject("student", stu);
		return view;
	}

	/**
	 * 修改学生信息
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping("updateStudent")
	public ModelAndView updateStudent(Student student) {
		ModelAndView view = new ModelAndView("update-student");
		student.setCreate_time(new Date());
		boolean b = userService.updateStudentService(student);
		view.addObject("update_status", b);
		return view;
	}

	/**
	 * 删除学生信息
	 * 
	 * @param request
	 * @return
	 */
	@GetMapping("delStudent")
	public ModelAndView delStudent(Student student) {
		String url = "forward:showDepStudent";
		if (student.getIdentity().equals("admin"))
			url = "forward:showAllStudent";
		ModelAndView view = new ModelAndView(url);
		userService.delStudentService(student.getId().toString());
		return view;
	}

	/**
	 * 进入添加成绩页面
	 * 
	 * @param session
	 * @return
	 */
	@GetMapping("intoAddAchievement")
	public ModelAndView intoAddAchievement(@Param("id") String id) {
		ModelAndView view = new ModelAndView("add-achievement");
		Student student = userService.getStudentService(id);
		view.addObject("student", student);
		System.out.println(student);
		return view;
	}

	/**
	 * 添加成绩
	 * 
	 * @param session
	 * @return
	 */
	@PostMapping("addAchievement")
	public ModelAndView addAchievement(Achievement achievement, Student student) {
		ModelAndView view = new ModelAndView("redirect:showAchievement?stu_id=" + student.getId());
		achievement.setCreate_time(new Date());
		achievement.setId(student.getAchievement_id());
		System.out.println(achievement);
		System.out.println(student);
		userService.addAchievement(achievement);
		userService.addAchievementId(student.getId().toString(), student.getAchievement_id());
		return view;
	}

	/**
	 * 修改成绩
	 * 
	 * @param session
	 * @return
	 */
	@PostMapping("updateAchievement")
	public ModelAndView updateAchievement(Achievement achievement, @Param("stu_id") String stu_id) {
		ModelAndView view = new ModelAndView("redirect:showAchievement?stu_id=" + stu_id);
		achievement.setCreate_time(new Date());
		System.out.println(achievement);
		userService.updateAchievement(achievement);
		return view;
	}

	/**
	 * 删除成绩
	 * 
	 * @param session
	 * @return
	 */
	@GetMapping("delAchievement")
	public ModelAndView delAchievement(@Param("count") String count, @Param("stu_id") String stu_id) {
		ModelAndView view = new ModelAndView("redirect:showAchievement?stu_id=" + stu_id);
		userService.delAchievement(count);
		return view;
	}

	/**
	 * 搜索
	 * 
	 * @param session
	 * @return
	 */
	@GetMapping("search")
	public ModelAndView searchMsg(HttpServletRequest request) {
		ModelAndView view = new ModelAndView("search");
		String text = request.getParameter("search_text");
		String type = request.getParameter("type");
		if (type.equals("student")) {
			List<Student> searchStudent = userService.searchStudent(text);
			view.addObject("searchStudent", searchStudent);
		} else if (type.equals("teacher")) {
			List<Teacher> searchTeacher = userService.searchTeacher(text);
			view.addObject("searchTeacher", searchTeacher);
		}
		System.out.println(text);
		return view;
	}

	/**
	 * 打开教师列表
	 * 
	 * @param session
	 * @return
	 */
	@GetMapping("openTeacherList")
	public ModelAndView openTeacherList(HttpServletRequest request) {
		ModelAndView view = new ModelAndView("admin-teacher");
		List<Teacher> teacherList = userService.getListTeacherService();
		view.addObject("teacherList", teacherList);
		return view;
	}

	/**
	 * 添加教师
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping("addTeacher")
	public ModelAndView addTeacher(Teacher teacher) {
		String uid = UUID.randomUUID().toString().replaceAll("-", "");
		ModelAndView view = new ModelAndView("add-teacher");
		teacher.setCreate_time(new Date());
		teacher.setPwd(teacher.getUsername());
		teacher.setAppendix_id(uid);
		System.out.println(teacher);
		boolean b = userService.addTeacherService(teacher);
		List<Department> departmentList = userService.getListDepartmentService();
		view.addObject("departmentList", departmentList);
		view.addObject("update_status", b);
		return view;
	}

	/**
	 * 进入修改教师页面
	 * 
	 * @param request
	 * @return
	 */
	@GetMapping("intoUpdateTeacher")
	public ModelAndView intoUpdateTeacher(Teacher teacher) {
		ModelAndView view = new ModelAndView("update-teacher");
		Teacher tea = userService.getTeacherService(teacher.getId().toString());
		view.addObject("teacher", tea);
		return view;
	}

	/**
	 * 修改教师信息
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping("updateTeacher")
	public ModelAndView updateTeacher(Student teacher) {
		ModelAndView view = new ModelAndView("update-teacher");
		teacher.setCreate_time(new Date());
		boolean b = userService.updateMsgService(teacher);
		view.addObject("update_status", b);
		return view;
	}

	/**
	 * 删除教师信息
	 * 
	 * @param request
	 * @return
	 */
	@GetMapping("delTeacher")
	public ModelAndView delStudent(Teacher teacher) {
		ModelAndView view = new ModelAndView("forward:openTeacherList");
		System.out.println(teacher);
		userService.delTeacherService(teacher.getId().toString());
		return view;
	}

	/**
	 * 打开院部列表
	 * 
	 * @param session
	 * @return
	 */
	@GetMapping("openDepartmentList")
	public ModelAndView openDepartmentList(HttpServletRequest request) {
		ModelAndView view = new ModelAndView("admin-department");
		List<Department> departmentList = userService.getListDepartmentService();
		view.addObject("departmentList", departmentList);
		return view;
	}

	/**
	 * 添加院部
	 * 
	 * @param session
	 * @return
	 */
	@GetMapping("addDepartment")
	public ModelAndView addDepartment(Department department) {
		ModelAndView view = new ModelAndView("redirect:openDepartmentList");
		department.setCreate_time(new Date());
		System.out.println(department);
		userService.addDepartmentService(department);
		return view;
	}

	/**
	 * 删除院部
	 * 
	 * @param session
	 * @return
	 */
	@GetMapping("delDepartment")
	public ModelAndView delDepartment(Department department) {
		ModelAndView view = new ModelAndView("redirect:openDepartmentList");
		department.setCreate_time(new Date());
		System.out.println(department);
		userService.delDepartmentService(department.getId().toString());
		return view;
	}

	/**
	 * 修改院部
	 * 
	 * @param session
	 * @return
	 */
	@GetMapping("updateDepartment")
	public ModelAndView updateDepartment(Department department) {
		ModelAndView view = new ModelAndView("redirect:openDepartmentList");
		department.setCreate_time(new Date());
		System.out.println(department);
		userService.updateDepartmentService(department);
		return view;
	}

	/**
	 * 重置密码
	 * 
	 * @param session
	 * @return
	 */
	@GetMapping("initPwd")
	public ModelAndView initPwd(Student user, @Param("admin") String admin) {
		String url = "redirect:showDepStudent";
		if (user.getIdentity().equals("teacher"))
			url = "redirect:openTeacherList";
		else if (admin.equals("admin"))
			url = "redirect:showAllStudent";
		ModelAndView view = new ModelAndView(url);
		boolean b = userService.initPwdService(user);
		view.addObject("update_status", b);
		return view;
	}

	/**
	 * 上传文件
	 * 
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@PostMapping("upload")
	public ModelAndView upload(Appendix appendix, @RequestParam("identity") String identity,
			@RequestParam("upFile") MultipartFile file,@RequestParam("stu_id") String stu_id, HttpServletResponse response) throws Exception {
		String path = filePath.getFilePath();
		if (file.isEmpty()) {
			response.getWriter().write("<script>alert('File Can’t Empty！')</script>");
			return null;
		} else {
			File f = new File(path);
			if (!f.exists()) {
				f.mkdirs();
			}
			String fn = file.getOriginalFilename();
			String filename = TLFileUploadUtil.TL.upLoad(file, fn, path);
			appendix.setPath(path + filename);
		}
		ModelAndView view = new ModelAndView();
		boolean b = false;
		appendix.setCreate_time(new Date());
		b = userService.uploadService(appendix);
		if (identity.equals("student")) {
			view.setViewName("stu-index");
			Student student = userService.getStudentService(stu_id);
			view.addObject("student",student);
		} else if (identity.equals("teacher")) {
			view.setViewName("redirect:showDepStudent");
			Teacher teacher = userService.getTeacherService(stu_id);
			view.addObject("teacher",teacher);
		}
		view.addObject("update_status", b);
		return view;
	}

	/**
	 * 删除附件
	 * 
	 * @param session
	 * @return
	 */
	@PostMapping("delAppendix")
	public ModelAndView delAppendix(@RequestParam("appendix_id") String appendix_id, @RequestParam("path") String path,
			@RequestParam("identity") String identity,@RequestParam("stu_id") String stu_id) {
		ModelAndView view = new ModelAndView();
		boolean b = userService.delAppendixService(appendix_id);
		if (b) {
			File file = new File(path);
			file.delete();
		}
		if (identity.equals("teacher")) {
			view.setViewName("redirect:showDepStudent");
			Teacher teacher = userService.getTeacherService(stu_id);
			view.addObject("teacher",teacher);
		}
		else if(identity.equals("student")) {
		view.setViewName("stu-index");
		Student student = userService.getStudentService(stu_id);
		view.addObject("student",student);
		}
		return view;
	}
	

	/**
	 * 下载附件
	 * 
	 * @param session
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@GetMapping("download")
	public ModelAndView download(@RequestParam("path") String path,HttpServletResponse response) throws UnsupportedEncodingException {
		String filepath = path;
        //设置文件路径
        File file = new File(filepath);
        //File file = new File(realPath , fileName);
        if (file.exists()) {
            response.setContentType("application/octet-stream");// 设置强制下载不打开
            response.addHeader("Content-Disposition", "attachment;fileName=\"" + new String(file.getName().getBytes(),"iso8859-1") + "\"");// 设置文件名
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream os = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
                os.flush();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
		return null;
	}

}
