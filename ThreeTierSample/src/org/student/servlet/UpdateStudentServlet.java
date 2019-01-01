package org.student.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.student.entity.*;

import org.student.entity.Student;
import org.student.service.IStudentService;
import org.student.service.lmpl.StudentServicelmpl;

public class UpdateStudentServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//获取待修改人的学号
		int no = Integer.parseInt(request.getParameter("sno"));
		//获取修改后得内容
		String name = request.getParameter("sname");
		int age = Integer.parseInt(request.getParameter("sage"));
		String address = request.getParameter("saddress");
		//将修改的内容封装到实体类中
		Student student = new Student(name,age,address);
		
		IStudentService service = new StudentServicelmpl();
		boolean result = service.updateStudentBySno(no, student);
		response.setContentType("text/html;charset=utf-8");    //在out前设置响应编码
		response.setCharacterEncoding("utf-8");
		if (result) {
			//response.getWriter().println("修改成功");
			response.sendRedirect("QueryAllStudentServlet");//
		}else {
			response.getWriter().println("修改失败");
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
