<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>后台管理中心</title>  
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>   
</head>
<body style="background-color:#f2f9fd;">
<div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
    <h1><img src="images/y.jpg" class="radius-circle rotate-hover" height="50" alt="" />后台管理中心</h1>
  </div>
  <div class="head-l"><a class="button button-little bg-green" href="index.jsp" target="_self"><span class="icon-home"></span> 首页</a> &nbsp;&nbsp;<a class="button button-little bg-red" href="login.html"><span class="icon-power-off"></span> 退出登录</a> </div>
</div>
<div class="leftnav">
  <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
  <h2><span class="icon-user"></span>系统用户管理</h2>
  <ul style="display:block">
    <li><a href="admin/add_admin.jsp" target="right"><span class="icon-caret-right"></span>添加管理员</a></li>
    <li><a href="teacher/add_teacher.jsp" target="right"><span class="icon-caret-right"></span>教师信息添加</a></li>
    <li><a href="teacher/TeacherAction.action" target="right"><span class="icon-caret-right"></span>教师信息查询</a></li>  
    <li><a href="student/add_student.jsp" target="right"><span class="icon-caret-right"></span>学生信息添加</a></li>   
    <li><a href="student/studentAction.action" target="right"><span class="icon-caret-right"></span>学生信息查询</a></li>     
  </ul>   
  <h2><span class="icon-user"></span>课题管理</h2>
  <ul style="display:block">
    <li><a href="course/course_findCoursePage.action" target="right"><span class="icon-caret-right"></span>课题管理</a></li>
    </ul>
</div>
<script type="text/javascript">
$(function(){
  $(".leftnav h2").click(function(){
	  $(this).next().slideToggle(200);	
	  $(this).toggleClass("on"); 
  })
  $(".leftnav ul li a").click(function(){
	    $("#a_leader_txt").text($(this).text());
  		$(".leftnav ul li a").removeClass("on");
		$(this).addClass("on");
  })
});
</script>
<ul class="bread">
  <li><a href="#" target="right" class="icon-home"> 首页</a></li>
  <li><a href="##" id="a_leader_txt">网站信息</a></li>
  <li><b>当前用户：</b><span style="color:red;"><%=session.getValue("loginUsername") %></php></span>
</ul>
<div class="admin">
  <iframe scrolling="auto" rameborder="0" src="info.html" name="right" width="100%" height="100%"></iframe>
</div>
<div style="text-align:center;">
</div>
</body>
</html>