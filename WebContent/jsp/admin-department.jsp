<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/bpath.jsp" %>
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
        <h3 class="card-title float-left">管理员主页(院部管理)</h3>
        <div class="card-title float-right">
            欢迎登录：<a href="${path}/jsp/teacher-msg.jsp" target="_blank" style="color: springgreen;font-weight: bold;text-decoration:none">${admin.name}</a>，<a href="${basePath}/UserHandler/loginout"
                                                                                                          style="text-decoration:none">退出</a>
        </div>
    </div>
     <div class="card-body">
        <div>
            <Button onclick="addDep()" class="btn btn-primary">添加院部</Button>
            <a href="javascript:location.reload()"  class="btn btn-primary ml-5">刷新</a>
        </div>
        <table class="table table-hover" id="stu_list">
            <thead>
            <tr>
                <th>序号</th>
                <th>院部名称</th>
                <th>录入时间</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${departmentList}" var="department" varStatus="i">
            <tr>
                <td>${i.index+1}</td>
                <td>${department.department_name}</td>
                <td><fmt:formatDate value="${department.create_time}" pattern="yyyy-MM-dd"/></td>
                <td><a href="#" onclick="updateDep('${department.id}','${department.department_name}')" class="btn-sm btn-warning">修改</a>
                <a href="${basePath}/UserHandler/delDepartment?id=${department.id}" class="btn-sm btn-danger ml-3">删除</a></td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
 </div>
</body>
<script>
		function addDep(){
			 var dep_name = prompt("请输入院部名称");
			 if(dep_name.lenght != 0)
			 location.href = "${basePath}/UserHandler/addDepartment?department_name="+dep_name;
		}
		
		function updateDep(id,department_name){
			 var dep_name = prompt("请输入院部名称",department_name);
			 if(dep_name.lenght != 0)
			 location.href = "${basePath}/UserHandler/updateDepartment?id="+id+"&department_name="+dep_name;
		}
</script>
</html>