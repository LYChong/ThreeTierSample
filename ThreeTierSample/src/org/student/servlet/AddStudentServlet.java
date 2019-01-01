package org.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.dao.IStudentDao;
import org.student.entity.Student;
import org.student.service.IStudentService;
import org.student.service.lmpl.StudentServicelmpl;

/**
 * Servlet implementation class AddStudentServlet
 */
public class AddStudentServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取从前端传来的数据
		response.setContentType("text/html;charset=utf-8");    //在out前设置响应编码
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		int no = Integer.parseInt(request.getParameter("sno"));
		String name = request.getParameter("sname");
		int age = Integer.parseInt(request.getParameter("sage")); 
		String address = request.getParameter("saddress");
		Student student = new Student(no,name,age,address);
		
		//接口  x = new 实现类();
		IStudentService studentService = new StudentServicelmpl();
		boolean result = studentService.addStudent(student);
		PrintWriter out = response.getWriter();
		/*
		if(result) {
			//out.println("增加成功");
			//response.sendRedirect("QueryAllStudentServlet");
		}else {
			//out.println("增加失败");	
		}
		*/
		if(!result) {//如果增加失败，给request放入一条数据error
			request.setAttribute("error", "addError");
		}else {
			//增加成功
			request.setAttribute("error", "noAddError");
		}
		//response.sendRedirect("QueryAllStudentServlet");
		request.getRequestDispatcher("QueryAllStudentServlet").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
