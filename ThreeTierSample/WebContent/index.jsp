<%@page import="org.student.entity.Page"%>
<%@page import="org.student.entity.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息列表</title>
</head>
<body>

	<%
		String error = (String)request.getAttribute("error");
		if(error!=null){
			if(error.equals("addError")){
				out.print("增加失败");
			}else if(error.equals("noAddError")){
				out.print("增加成功");
			}
		}
			//没有执行增加		
	%>

		<table border="1px">
			<tr>
				<th>学号</th>
				<th>姓名</th>
				<th>年龄</th>
				<th>地址</th>	
				<th>操作</th>			
			</tr>
			<%
				Page p =  (Page)request.getAttribute("p");
				for(Student student:p.getStudents()){
			%>
				
				<tr>
					<td><a href="QueryStudentBySnoServlet?sno=<%=student.getSno() %>"><%=student.getSno() %></a></td>
					<td><%=student.getSname() %></td>
					<td><%=student.getAge() %></td>
					<td><%=student.getAddress() %></td>
					<td><a href="DeleteStudentServlet?sno=<%=student.getSno() %>">删除</a></td>
				
				</tr>			
			<%				
				}
			%>			
		</table>
		<a href="add.jsp">新增</a><br/>
		
		<%
			if(p.getCurrentPage()==p.getTotalPage()){
		%>		
				<a href="QueryStudentByPage?currentPage=1">首页</a>
				<a href="QueryStudentByPage?currentPage=<%=p.getCurrentPage()-1%>">上一页</a>
		<% 
			}
			else if(p.getCurrentPage()==1){
		%>
			<a href="QueryStudentByPage?currentPage=<%=p.getCurrentPage()+1%>">下一页</a>
				<a href="QueryStudentByPage?currentPage=<%=p.getTotalPage()%>">尾页</a>
		<% 	
			}else{
		%>
				<a href="QueryStudentByPage?currentPage=1">首页</a>
				<a href="QueryStudentByPage?currentPage=<%=p.getCurrentPage()-1%>">上一页</a>
				<a href="QueryStudentByPage?currentPage=<%=p.getCurrentPage()+1%>">下一页</a>
				<a href="QueryStudentByPage?currentPage=<%=p.getTotalPage()%>">尾页</a>
		<% 
			}
		%>
		
		
		
		
</body>
</html>



