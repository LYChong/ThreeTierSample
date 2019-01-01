package org.student.service;

import java.util.List;

import org.student.entity.Student;

public interface IStudentService {
	//增加学生
	public boolean addStudent(Student student);
		
	//删除学生
	public boolean deleteStudentBySno(int sno);
	
	//修改学生信息
	public boolean updateStudentBySno(int sno,Student student) ;
	
	//更据学号查询一个学生
	public Student queryStudentBySno(int sno) ;
	
	//查询所有学生
	public List<Student>  queryAllStudents();
	
	//查询总数据
	public int getTotalCount();
	
	//查询当前页对象集合
	public List<Student> queryStudentsByPage(int currentPage,int pageSize);
}
