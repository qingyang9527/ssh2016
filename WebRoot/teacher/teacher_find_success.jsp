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
<form method="post" action="">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 显示所有教师信息</strong></div>
    <div class="padding border-bottom">
      <ul class="search">
        <li>
          <button type="button"  class="button border-green" id="checkall"><span class="icon-check"></span> 全选</button>
          <button type="submit" class="button border-red"><span class="icon-trash-o"></span> 批量删除</button>
        </li>
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th width="70">工号</th>
        <th width="70">姓名</th> 
        <th width="70">教师密码</th>
        <th width="70">发布课题</th>
        <th width="70">所属学院</th>
        <th width="70">职称</th>
        <th width="90">操作</th>       
      </tr>
      
      <!-- 循环开始 -->
      <s:iterator value="tlist" var="tl">
      <tr>
        <td><s:property value="#tl.tid"/></td>
          <td><s:property value="#tl.tname"/></td>
          <td><s:property value="#tl.tpwd"/></td>
          <td><s:property value="#tl.pcourse"/></td>
          <td><s:property value="#tl.departments"/></td> 
          <td><s:property value="#tl.title"/></td> 
        <td><div class="button-group">
      <a class="button border-main" href="editTeacherAction.action?tid=<s:property value="#tl.tid"/>"><span class="icon-edit"></span> 修改</a>
      <a class="button border-red" href="deleteTeacherAction.action?tid=<s:property value="#tl.tid"/>" onclick="return del()"><span class="icon-trash-o"></span> 删除</a>
      </div></td>
      </tr>
      </s:iterator>
      <!-- 循环结束 -->
      <!-- 页数迭代开始 -->
      <s:iterator value="pageBean">
      <tr>
        <td colspan="12">共<s:property value="allRow"/>条记录        
         共<s:property value="totalPage"/>页        
         当前第<s:property value="currentPage"/>页
       <span>每页显示<s:property value="pageSize"/>条记录</span> <div class="pagelist"> 
        <s:if test="%{currentPage == 1}">    
           第一页  上一页    
         </s:if>    
         <!-- currentPage为当前页 -->    
         <s:else>    
           <a href="TeacherAction.action?page=1">第一页</a>    
           <a href="TeacherAction.action?page=<s:property value="%{currentPage-1}"/>">上一页</a>    
         </s:else>    
        
         <s:if test="%{currentPage != totalPage}">    
         <a href="TeacherAction?page=<s:property value="%{currentPage+1}"/>">下一页</a>    
         <a href="TeacherAction?page=<s:property value="totalPage"/>">最后一页</a>    
         </s:if>    
        
         <s:else>    
         下一页  最后一页    
         </s:else> 
      </tr>
      </s:iterator>
      <!-- 页数迭代结束-->
    </table>
  </div>
</form>
<script type="text/javascript">

function del(id){
	if(confirm("您确定要删除吗?")){
		
	}
}

$("#checkall").click(function(){ 
  $("input[name='id[]']").each(function(){
	  if (this.checked) {
		  this.checked = false;
	  }
	  else {
		  this.checked = true;
	  }
  });
})

function DelSelect(){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){
		var t=confirm("您确认要删除选中的内容吗？");
		if (t==false) return false; 		
	}
	else{
		alert("请选择您要删除的内容!");
		return false;
	}
}

</script>
</body></html>