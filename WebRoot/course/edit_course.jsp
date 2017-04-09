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
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>编辑课程信息</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="course_updateCourse.action">  
      <div class="form-group">
        <div class="label">
          <label>课程编号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${model.cnum}" name="cnum" data-validate="required:请输入课程编号" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>课程名：</label>
        </div>
        <div class="field">
          <input type="text" id="url1" name="cname" class="input tips" style="width:25%; float:left;"  value="${model.cname}"  data-toggle="hover" data-place="right" data-image="" />
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>发布人：</label>
        </div>
        <div class="field">
          <input type="text" id="url1" name="publisher" class="input tips" style="width:25%; float:left;"  value="${model.publisher}"  data-toggle="hover" data-place="right" data-image="" />
        </div>
      </div>       
     
        
        <div class="form-group">
        <div class="label">
          <label>附件：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${model.upload}" name="upload" data-validate="required:请上传附件" />
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>日期：</label>
        </div>
        <div class="field">
        <s:date name="" format=""/>
          <input type="text" class="input w50" value="${model.date}" name="date" data-validate="required:请输入日期" />
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