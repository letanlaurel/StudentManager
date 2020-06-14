<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/bpath.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>查看成绩</title>
    <link rel="stylesheet" href="${path}/css/bootstrap.min.css">
    <script type="text/javascript" src="${path}/js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="${path}/js/bootstrap.min.js"></script>
</head>
<body>
<div class="card">
    <div class="card-header">
        <h3 class="card-title float-left">${student.name}的成绩 (${student.username})</h3>
        <a href="${basePath}/UserHandler/${empty admin? 'showDepStudent':'showAllStudent'}" class="btn btn-success float-right">返回</a>
    </div>
    <div class="card-body">
        <div>
            <a href="${basePath}/UserHandler/intoAddAchievement?id=${student.id}" target="_blank" class="btn-sm btn-success">添加</a>
            <a href="javascript:location.reload()"  class="btn btn-primary ml-5">刷新</a>
            <span style="color:red;margin-left: 24%">修改后请点击刷新按钮刷新页面</span>
        </div>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>序号</th>
                <th>课程名称</th>
                <th>分数</th>
                <th>录入时间</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${student.achievementList}" var="achievement" varStatus="i">
            <tr>
                <td>${i.index+1}</td>
                <td>${achievement.course_name}</td>
                <td>${achievement.score}</td>
                <td><fmt:formatDate value="${achievement.create_time}" pattern="yyyy-MM-dd"/></td>
                <td><button onclick="update('${achievement.count}','${achievement.id}','${achievement.course_name}','${achievement.score}','${student.id}')" class="btn-sm btn-warning">修改</button>
                <a href="${basePath}/UserHandler/delAchievement?count=${achievement.count}&stu_id=${student.id}" class="btn-sm btn-danger ml-3">删除</a></td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    
</div>
</body>
<script>
	function update(count,id,course_name,score,stu_id){
		 var cname = prompt("请输入课程名",course_name);
		 if(cname == null || cname == '')
			 return false;
		 var cscore = prompt("请输入分值",score);
		 if(cname != null && cscore != null && typeof cscore === 'number' && parseInt(cscore) >= 0 && parseInt(cscore) <= 100)
		 $.ajax({
		        type:"post",
		        url:"${basePath}/UserHandler/updateAchievement",
		        data:{"count":count,"id":id,"course_name":cname,"score":cscore,"stu_id":stu_id},
		        dataType:"json",
		        success:function(){
		        	alert("修改成功")
		        }
		 })
		 else
			 alert("分数必须是整数或浮点数！");
	}
</script>
</html>