<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="/bpath.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>管理员主页</title>
<link rel="stylesheet" href="${path}/css/bootstrap.min.css">
<script type="text/javascript" src="${path}/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${path}/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="card">
		<div class="card-header">
			<h3 class="card-title float-left">管理员主页(学生管理)</h3>
			<div class="card-title float-right">
				欢迎登录：<a href="${path}/jsp/admin-msg.jsp" target="_blank"
					style="color: springgreen; font-weight: bold; text-decoration: none">${admin.name}</a>，<a
					href="${basePath}/UserHandler/loginout"
					style="text-decoration: none">退出</a>
			</div>
		</div>
		<div class="card-body">
			<div>
				<a href="${path}/jsp/add-student.jsp" target="_blank"
					class="btn btn-primary">添加学生</a> <a
					href="javascript:location.reload()" class="btn btn-primary ml-5">刷新</a>
				<input type="text" id="search" name="search_text"
					placeholder="请输入要搜索的内容.." style="margin-left: 25%"
					class="card-text"> <a target="_blank" href="#"
					onclick="searchSub(this)" class="btn-sm btn-primary">搜索</a> <a
					href="${basePath}/UserHandler/openTeacherList" target="_blank"
					class="btn-sm btn-success float-right ml-4">打开教师列表</a> <a
					href="${basePath}/UserHandler/openDepartmentList" target="_blank"
					class="btn-sm btn-success float-right">打开院部列表</a>
			</div>
			<table class="table table-hover" id="stu_list">
				<thead>
					<tr>
						<th>序号</th>
						<th>姓名</th>
						<th>性别</th>
						<th>学号</th>
						<th>院部</th>
						<th>邮箱</th>
						<th>手机号码</th>
						<th>成绩</th>
						<th>录入时间</th>
						<th>附件</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${studentList}" var="student" varStatus="i">
						<tr>
							<td>${i.index+1}</td>
							<td>${student.name}</td>
							<td>${student.sex}</td>
							<td>${student.username}</td>
							<td>${student.department.department_name}</td>
							<td>${student.email}</td>
							<td>${student.phone}</td>
							<td><a target="_blank"
								href="${basePath}/UserHandler/showAchievement?stu_id=${student.id}"
								class="btn-sm btn-primary">成绩管理</a></td>
							<td><fmt:formatDate value="${student.create_time}"
									pattern="yyyy-MM-dd" /></td>
							<c:if test="${!empty student.appendix}">
								<td><a
									href="${basePath}/UserHandler/download?path=${student.appendix.path}"
									class="btn-sm btn-primary">下载附件</a></td>
							</c:if>
							<c:if test="${empty student.appendix}">
								<td>没有上传附件</td>
							</c:if>
							<td><a
								href="${basePath}/UserHandler/initPwd?username=${student.username}&identity=${student.identity}&admin=admin"
								class="btn-sm btn-danger mr-2">重置密码</a> <a target="_blank"
								href="${basePath}/UserHandler/intoUpdateStudent?id=${student.id}"
								class="btn-sm btn-warning">修改</a> <a
								href="${basePath}/UserHandler/delStudent?id=${student.id}&identity=${admin.identity}"
								class="btn-sm btn-danger ml-3">删除</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
<script>
	if (GetQueryString('update_status') != ''
			&& GetQueryString('update_status') == 'true') {
		alert("操作成功！")
	} else if (GetQueryString('update_status') != ''
			&& GetQueryString('update_status') == 'false') {
		alert("操作失败！")
	}
	function GetQueryString(name) {//获取url后面的参数
		let reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
		let r = window.location.search.substr(1).match(reg);//search,查询？后面的参数，并匹配正则
		if (r != null)
			return decodeURI(r[2]);
		return null;
	}
	function searchSub(obj) {
		var value = $("#search").val();
		var url = "${basePath}/UserHandler/search?search_text=" + value
				+ "&type=student";
		if (value != '')
			$(obj).prop("href", url);
		else {
			alert("输入内容不能为空！")
			return false;
		}

	}
</script>
</html>