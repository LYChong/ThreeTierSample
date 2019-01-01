package org.student.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.service.IStudentService;
import org.student.service.lmpl.StudentServicelmpl;

public class DeleteStudentServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//删除功能
		request.setCharacterEncoding("utf-8");
		//接受前端传来的学号
		int no = Integer.parseInt(request.getParameter("sno"));
		IStudentService service = new StudentServicelmpl();
		boolean result = service.deleteStudentBySno(no);
		response.setContentType("text/html;charset=utf-8");    //在out前设置响应编码
		response.setCharacterEncoding("utf-8");
		if (result) {
			//response.getWriter().println("删除成功");
			response.sendRedirect("QueryAllStudentServlet");
		}else {
			response.getWriter().println("删除失败");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
