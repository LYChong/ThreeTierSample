package org.student.dao;

import java.util.List;

import org.student.entity.Student;

public interface IStudentDao {
public boolean addStudent(Student student);
	
	//根据学号   删除学生
	public boolean deleteStudentBysno(int sno) ;
	
	//根据学号   修改学生信息： 根据sno找到待修改的人，把这个人修改成student
	public boolean updateStudentBySno(int sno,Student student);
	
	//查询学生总数
	public int getTotalCount() ;
	
	//查询某一页的数据
	public List<Student> queryStudentsByPage(int currentPage,int pageSize);
	
	//查询全部学生(很多学生
	public List<Student> queryAllStudent();
	
	//查询学生是否存在
		public boolean isExist(int sno) ;
	
	//根据学号  查询学生
	public Student queryStudentBySno(int sno);
}
