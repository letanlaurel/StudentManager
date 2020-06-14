<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/bpath.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加成绩</title>
<link rel="stylesheet" href="${path}/css/bootstrap.min.css">
<script type="text/javascript" src="${path}/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${path}/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="card-header">
		<h2 class="card-title" align="center">添加成绩信息</h2>
	</div>
	<div class="card-body">
		<form action="${basePath}/UserHandler/addAchievement" method="post">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-body">
						<div class="form-group">
							<input type="hidden" name="id"  value="${student.id}">
							<input type="hidden" name="achievement_id"  value="${student.achievement_id}">
							姓名：<input type="text" value="${student.name}" class="form-control" readonly="readonly"
								 name="name" placeholder="姓名" required
								autocomplete="off">
						</div>
						<div class="form-group">
							学号： <input type="text" 
								name="username" value="${student.username}" readonly="readonly" class="form-control"
								placeholder="学号" required autocomplete="off">
						</div>
						
						<div class="form-group">
							课程名称： <input type="text" 
								name="course_name"  class="form-control"
								placeholder="课程名称" required autocomplete="off">
						</div>
						
						<div class="form-group">
							分数： <input type="number" 
								name="score"  class="form-control"
								placeholder="请输入分值" min="0" max="100" required autocomplete="off">
						</div>
						
					</div>
					<div class="modal-footer">
						<div class="form-group">
							<button type="submit" class="btn btn-primary form-control">添加</button>
						</div>
						<div class="form-group">
							<c:if test="${empty admin && !empty teacher }">
								<a
									href="${basePath}/UserHandler/showDepStudent"
									class="btn btn-success form-control">返回</a>
							</c:if>
							<c:if test="${!empty admin && empty teacher }">
								<a
									href="${basePath}/UserHandler/showAllStudent"
									class="btn btn-success form-control">返回</a>
							</c:if>
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