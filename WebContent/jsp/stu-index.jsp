<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/bpath.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>学生主页</title>
    <link rel="stylesheet" href="${path}/css/bootstrap.min.css">
    <script type="text/javascript" src="${path}/js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="${path}/js/bootstrap.min.js"></script>
</head>
<body>
<div class="card">
    <div class="card-header">
        <h3 class="card-title float-left">学生主页</h3>
        <div class="card-title float-right">
            欢迎登录：<a href="${path}/jsp/student-msg.jsp" target="_blank" style="color: springgreen;font-weight: bold;text-decoration:none">${student.name}</a>，<a href="${basePath}/UserHandler/loginout"
                                                                                                          style="text-decoration:none">退出</a>
        </div>
    </div>
    <div class="card-body">
        <div>
            <span class="text-info" style="font-size: x-large">我的成绩</span>
            <a href="javascript:location.reload()"  class="btn btn-primary ml-5">刷新</a>
            <c:if test="${empty student.appendix}">
            <form action="${basePath}/UserHandler/upload" method="post" enctype="multipart/form-data" class="float-right">
            <input type="hidden" name="id" value="${student.appendix_id}"/>
            <input type="hidden" name="identity" value="student"/>
            <input type="hidden" name="stu_id" value="${student.id }"/>
            <input type="file" name="upFile"/>
            <button class="btn-sm btn-primary">上传附件</button>
           	</form>
           	</c:if>
           	<c:if test="${!empty student.appendix}">
            <a href="${basePath}/UserHandler/download?path=${student.appendix.path}"  class="btn btn-primary float-right ml-3">下载附件</a>
            <form action="${basePath}/UserHandler/delAppendix" method="post"class="float-right">
            <input type="hidden" name="appendix_id" value="${student.appendix_id}" />
            <input type="hidden" name="identity" value="student" />
            <input type="hidden" name="path" value="${student.appendix.path}" />
            <input type="hidden" name="stu_id" value="${student.id}" />
            <button class="btn btn-primary">删除附件</button>
            </form>
           	</c:if>
        </div>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>序号</th>
                <th>课程名称</th>
                <th>分数</th>
                <th>录入时间</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${student.achievementList}" var="achievement" varStatus="i">
            <tr>
                <td>${i.index+1}</td>
                <td>${achievement.course_name}</td>
                <td>${achievement.score}</td>
                <td><fmt:formatDate value="${achievement.create_time}" pattern="yyyy-MM-dd"/></td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>