<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/bpath.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>搜索结果</title>
    <link rel="stylesheet" href="${path}/css/bootstrap.min.css">
    <script type="text/javascript" src="${path}/js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="${path}/js/bootstrap.min.js"></script>
</head>
<body>
<div class="card">
    <div class="card-header">
        <h3 class="card-title float-left">搜索结果</h3>
    </div>
     <div class="card-body">
        <div>
            <a href="javascript:location.reload()"  class="btn btn-primary ml-5">刷新</a>
        </div>
        <c:if test="${!empty searchStudent && empty searchTeacher}">
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
            <c:forEach items="${searchStudent}" var="student" varStatus="i">
            <tr>
                <td>${i.index+1}</td>
                <td>${student.name}</td>
                <td>${student.sex}</td>
                <td>${student.username}</td>
                <td>${student.department.department_name}</td>
                <td>${student.email}</td>
                <td>${student.phone}</td>
                <td>
                <a target="_blank" href="${basePath}/UserHandler/showAchievement?stu_id=${student.id}" class="btn-sm btn-primary">成绩管理</a>
                </td>
                <td><fmt:formatDate value="${student.create_time}" pattern="yyyy-MM-dd"/></td>
                <td><a href="${basePath}/UserHandler/download?path=${student.appendix.path}" class="btn-sm btn-primary">下载附件</a></td>
                <td><a target="_blank" href="${basePath}/UserHandler/intoUpdateStudent?id=${student.id}" class="btn-sm btn-warning">修改</a>
                <a href="${basePath}/UserHandler/delStudent?id=${student.id}&identity=${teacher.identity}" class="btn-sm btn-danger ml-3">删除</a></td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
        </c:if>
    	<c:if test="${empty searchStudent && !empty searchTeacher}">
			 <table class="table table-hover">
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
            <c:forEach items="${searchTeacher}" var="teacher" varStatus="i">
            <tr>
                <td>${i.index+1}</td>
                <td>${teacher.name}</td>
                <td>${teacher.sex}</td>
                <td>${teacher.username}</td>
                <td>${teacher.email}</td>
                <td>${teacher.phone}</td>
                <td>${teacher.department.department_name}</td>
                <td><fmt:formatDate value="${teacher.create_time}" pattern="yyyy-MM-dd"/></td>
                <td><a href="${basePath}/UserHandler/download?path=${teacher.appendix.path}" class="btn-sm btn-primary">下载附件</a></td>
                <td><a target="_blank" href="${basePath}/UserHandler/intoUpdateTeacher?id=${teacher.id}" class="btn-sm btn-warning">修改</a>
                <a href="${basePath}/UserHandler/delTeacher?id=${teacher.id}" class="btn-sm btn-danger ml-3">删除</a></td>
            </tr>
            </c:forEach>
            </tbody>
        </table>  	
    	</c:if>
    </div>
 </div>
</body>
</html>