<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/bpath.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改教师信息</title>
<link rel="stylesheet" href="${path}/css/bootstrap.min.css">
<script type="text/javascript" src="${path}/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${path}/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="card-header">
		<h2 class="card-title" align="center">修改教师信息</h2>
	</div>
	<div class="card-body">
		<form action="${basePath}/UserHandler/updateTeacher" method="post">
			<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-body">
								<div class="form-group">
									<input type="hidden" name="id" value="${teacher.id}"> <input
										type="hidden" name="identity" value="${teacher.identity}">
									姓名：<input type="text" class="form-control"
										value="${teacher.name}" name="name" placeholder="姓名" required
										autocomplete="off">
								</div>
								<div class="form-group">
									工号： <input type="text" value="${teacher.username}"
										name="username" readonly="readonly" class="form-control"
										placeholder="学号/工号" required autocomplete="off">
								</div>
								<div class="form-group">
									性别： <select name="sex" class="form-control">
										<option value="男"
											<c:if test="${'男' eq teacher.sex}">selected</c:if>>男</option>
										<option value="女"
											<c:if test="${'女' eq teacher.sex}">selected</c:if>>女</option>
									</select>
								</div>
								<div class="form-group">
									邮箱： <input type="text" value="${teacher.email}" name="email"
										class="form-control" placeholder="邮箱" required
										autocomplete="off">
								</div>
								<div class="form-group">
									手机号码： <input type="text" value="${teacher.phone}" name="phone"
										class="form-control" placeholder="手机号码" required
										autocomplete="off">
								</div>
								<div class="form-group">
									院部： <select name="department_id" id="" class="form-control">
										<c:forEach items="${departmentList}" varStatus="i"
											var="department">
											<c:if test="${teacher.department.id == department.id}">
												<option value="${department.id}" selected>${department.department_name}</option>
											</c:if>
											<c:if test="${teacher.department.id != department.id}">
												<option value="${department.id}">${department.department_name}</option>
											</c:if>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="modal-footer">
								<div class="form-group">
									<button type="submit" class="btn btn-primary form-control">修改</button>
								</div>
								<div class="form-group">
									<a href="${basePath}/UserHandler/openTeacherList"
										class="btn btn-success form-control">返回</a>
								</div>
							</div>
						</div>
					</div>
		</form>
	</div>
</body>
<c:if test="${!empty update_status && update_status}">
	<script>
		alert("操作成功！")
	</script>
</c:if>
<c:if test="${!empty update_status && !update_status}">
	<script>
		alert("操作失败！")
	</script>
</c:if>
</html>