<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/bpath.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录页面</title>
    <link rel="stylesheet" href="${path}/css/bootstrap.min.css">
    <script type="text/javascript" src="${path}/js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="${path}/js/bootstrap.min.js"></script>
</head>
<body background="${path}/images/login_bg.jpg">
<form action="${basePath}/UserHandler/login" method="post">
    <div class="modal-dialog" style="margin-top: 10%;">
        <h2 class="card-title font-weight-bold" align="center">学生管理系统</h2>
        <div class="modal-content" style="background-color:rgba(250,250,250,0.2)">
            <div class="modal-header">
                <h4 class="modal-title text-center">登录</h4>
                <h5 class="modal-title text-center" style="color:red;" align="right">${login_status}</h5>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <div class="form-check font-weight-bold">
                        <input type="radio" id="stu_identity" checked="checked" name="identity" value="student" class="custom-radio m-2" autocomplete="off" />
                        <label for="stu_identity">学生</label>
                        <input type="radio" id="tea_identity" name="identity" value="teacher" class="custom-radio m-2" autocomplete="off" />
                        <label for="tea_identity">教师</label>
                        <input type="radio" id="dep_identity" name="identity" value="admin" class="custom-radio m-2" autocomplete="off" />
                        <label for="dep_identity">管理员</label>
                    </div>
                </div>
                <div class="form-group">
                    <input type="text" name="username" class="form-control" placeholder="用户名" required autocomplete="off">
                </div>
                <div class="form-group">
                    <input type="password" name="pwd" class="form-control" placeholder="密码" required autocomplete="off">
                </div>
            </div>
            <div class="modal-footer">
                <div class="form-group">
                    <button type="submit" class="btn btn-primary form-control">登录</button>
                </div>
                <div class="form-group">
                    <button type="button" onclick="javascript:alert('出于安全考虑，禁止注册用户！')" class="btn btn-default form-control">注册</button>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>