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
			<h3 class="card-title float-left">管理员主页(教师管理)</h3>
			<div class="card-title float-right">
				欢迎登录：<a href="${path}/jsp/teacher-msg.jsp" target="_blank"
					style="color: springgreen; font-weight: bold; text-decoration: none">${admin.name}</a>，<a
					href="${basePath}/UserHandler/loginout"
					style="text-decoration: none">退出</a>
			</div>
		</div>
		<div class="card-body">
			<div>
				<a href="${path}/jsp/add-teacher.jsp" target="_blank"
					class="btn btn-primary">添加教师</a> <a
					href="javascript:location.reload()" class="btn btn-primary ml-5">刷新</a>
				<input type="text" id="search" name="search_text"
					placeholder="请输入要搜索的内容.." style="margin-left: 25%"
					class="card-text"> <a target="_blank" href="#"
					onclick="searchSub(this)" class="btn-sm btn-primary">搜索</a>
			</div>
			<table class="table table-hover" id="stu_list">
				<thead>
					<tr>
						<th>序号</th>
						<th>姓名</th>
						<th>性别</th>
						<th>工号</th>
						<th>邮箱</th>
						<th>手机号码</th>
						<th>院部</th>
						<th>录入时间</th>
						<th>附件</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${teacherList}" var="teacher" varStatus="i">
						<tr>
							<td>${i.index+1}</td>
							<td>${teacher.name}</td>
							<td>${teacher.sex}</td>
							<td>${teacher.username}</td>
							<td>${teacher.email}</td>
							<td>${teacher.phone}</td>
							<td>${teacher.department.department_name}</td>
							<td><fmt:formatDate value="${teacher.create_time}"
									pattern="yyyy-MM-dd" /></td>
							<c:if test="${!empty teacher.appendix}">
								<td><a
									href="${basePath}/UserHandler/download?path=${teacher.appendix.path}"
									class="btn-sm btn-primary">下载附件</a></td>
							</c:if>
							<c:if test="${empty teacher.appendix}">
								<td>没有上传附件</td>
							</c:if>
							<td><a
								href="${basePath}/UserHandler/initPwd?username=${teacher.username}&identity=${teacher.identity}"
								class="btn-sm btn-danger mr-2">重置密码</a><a target="_blank"
								href="${basePath}/UserHandler/intoUpdateTeacher?id=${teacher.id}"
								class="btn-sm btn-warning">修改</a> <a
								href="${basePath}/UserHandler/delTeacher?id=${teacher.id}"
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
				+ "&type=teacher";
		if (value != '')
			$(obj).prop("href", url);
		else {
			alert("输入内容不能为空！")
			return false;
		}

	}
</script>
</html>