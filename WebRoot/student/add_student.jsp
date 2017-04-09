<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/pintuer.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加学生</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="addStudentAction.action">  
      <div class="form-group">
        <div class="label">
          <label>学生序号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="sid" data-validate="required:请输入学号" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>学生学号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="studentId" data-validate="required:请输入学号" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>学生姓名：</label>
        </div>
        <div class="field">
          <input type="text" id="url1" name="sname" class="input tips" style="width:25%; float:left;"  value=""  data-toggle="hover" data-place="right" data-image="" />
        </div>
      </div>     
      
      <div class="form-group">
        <div class="label">
          <label>学生登录密码：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="spwd" data-validate="required:请输入登录密码" />
          <div class="tips"></div>
        </div>
      </div>
      
      <if condition="$iscid eq 1">
        <div class="form-group">
          <div class="label">
            <label>所属学院：</label>
          </div>
          <div class="field">
          <s:select list="{'经济管理学院','文法学院','师范学院','信电学院'}" name="college" class="input w50"></s:select>
            <div class="tips"></div>
          </div>
        </div>
        <div class="form-group">
          <div class="label">
            <label>学生性别：</label>
          </div>
          <div class="field" style="padding-top:8px;"> 
          <s:radio list="{'男','女'}" name="ssex"></s:radio>
          </div>
        </div>
        
        <div class="form-group">
        <div class="label">
          <label>专业和班级：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="specialities" data-validate="required:请输入专业和班级" />
          <div class="tips"></div>
        </div>
      </div>
      
      
      <div class="form-group">
        <div class="label">
          <label>email：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="semail" data-validate="required:请输入email" />
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>联系电话：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="sphone" data-validate="required:请输入联系电话" />
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>籍&nbsp;&nbsp;贯：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="address" data-validate="required:请输入籍贯" />
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>所属老师：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="steacher" data-validate="required:请输入所属老师" />
          <div class="tips"></div>
        </div>
      </div>

      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
        </div>
      </div>
    </form>
  </div>
</div>

</body></html>
