<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  String path = request.getContextPath();
/*http://localhost:8080/SSM-project/*/
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
request.getSession().setAttribute("path",path);
request.getSession().setAttribute("basePath",basePath);%>
