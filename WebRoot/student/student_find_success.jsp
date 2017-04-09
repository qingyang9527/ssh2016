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
    <div class="panel-head"><strong class="icon-reorder"> 显示所有学生信息</strong></div>
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
        <th width="120">学生序号</th>
        <th width="120">学生学号</th>
        <th width="44">姓名</th> 
        <th width="83">学生密码</th> 
        <th width="44">性别</th>
        <th width="103">专业和班级</th>
        <th width="44">学院</th>
        <th width="52">email</th>
         <th width="83">联系电话</th>
         <th width="30">籍贯</th> 
         <th width="54">所属老师</th> 
        <th width="115">操作</th>       
      </tr>
      
      <!-- 循环开始 -->
      <s:iterator value="studentlist" var="st">
      <tr>
        <td><s:property value="#st.sid"/></td>
          <td><s:property value="#st.studentId"/></td>
          <td><s:property value="#st.sname"/></td>
          <td><s:property value="#st.spwd"/></td>
          <td><s:property value="#st.ssex"/></td>
          <td><s:property value="#st.specialities"/></td>  
           <td><s:property value="#st.college"/></td>         
          <td><s:property value="#st.semail"/></td>
          <td><s:property value="#st.sphone"/></td>
          <td><s:property value="#st.address"/></td>
          <td><s:property value="#st.steacher"/></td>
        <td><div class="button-group">
      <a class="button border-main" href="findStudentById.action?sid=<s:property value="#st.sid"/>"><span class="icon-edit"></span>修改</a>
      <a class="button border-red" href="deleteStudentById.action?sid=<s:property value="#st.sid"/>" onclick="return del()"><span class="icon-trash-o"></span> 删除</a>
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
           <a href="studentAction.action?page=1">第一页</a>    
           <a href="studentAction.action?page=<s:property value="%{currentPage-1}"/>">上一页</a>    
         </s:else>    
        
         <s:if test="%{currentPage != totalPage}">    
         <a href="studentAction?page=<s:property value="%{currentPage+1}"/>">下一页</a>    
         <a href="studentAction?page=<s:property value="totalPage"/>">最后一页</a>    
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

function del(){
	if(confirm("您确定要删除吗?")){
		return true;
	}
	return false;
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