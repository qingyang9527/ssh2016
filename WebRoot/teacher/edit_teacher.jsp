<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title></title>  
    <link href="${pageContext.request.contextPath}/css/pintuer.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/admin.css" rel="stylesheet" type="text/css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>  
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>修改教师信息</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="updateTeacherAction.action">  
      <div class="form-group">
        <div class="label">
          <label>教师工号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${model.tid}" name="tid" data-validate="required:请输入工号" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>教师姓名：</label>
        </div>
        <div class="field">
          <input type="text" id="url1" name="tname" class="input tips" style="width:25%; float:left;"  value="${model.tname}"  data-toggle="hover" data-place="right" data-image="" />
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>教师密码：</label>
        </div>
        <div class="field">
          <input type="text" id="url1" name="tpwd" class="input tips" style="width:25%; float:left;"  value="${model.tpwd}"  data-toggle="hover" data-place="right" data-image="" />
        </div>
      </div>       
      
      <if condition="$iscid eq 1">
        <div class="form-group">
          <div class="label">
            <label>所属学院：</label>
          </div>
          <div class="field">
          <s:select list="{'经济管理学院','文法学院','师范学院','信电学院'}" name="departments" class="input w50" value="%{model.departments}"></s:select>
            <div class="tips"></div>
          </div>
        </div>
        
        <div class="form-group">
        <div class="label">
          <label>发布课题：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${model.pcourse}" name="pcourse" data-validate="required:请输入发布课题" />
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>教师职称：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${model.title}" name="title" data-validate="required:请输入教师职称" />
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