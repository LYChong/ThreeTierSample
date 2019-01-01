package org.student.service.lmpl;

import java.util.List;

import org.student.dao.IStudentDao;
import org.student.dao.lmpl.StudentDaolmpl;
import org.student.entity.Student;
import org.student.service.IStudentService;

//业务逻辑层  ： 逻辑性的增删改查： （增： 查+增），对dao进行组装
public class StudentServicelmpl implements IStudentService{
	IStudentDao studentDao = new StudentDaolmpl();
	
	
	//增加学生
	public boolean addStudent(Student student) {
		if (!studentDao.isExist(student.getSno())) {
			studentDao.addStudent(student);
			return true;
		}else {
			System.out.println("此人已经存在！");
			return false;
		}
		
	}
		
	//删除学生
	public boolean deleteStudentBySno(int sno) {
		if(studentDao.isExist(sno)) {
			return studentDao.deleteStudentBysno(sno);
		}else {
			return false;
		}
	}

	
	//修改学生信息
	public boolean updateStudentBySno(int sno,Student student) {
		if (studentDao.isExist(sno)) {
			return studentDao.updateStudentBySno(sno, student);
		}
		return false;
	}
	
	//更据学号查询一个学生
	public Student queryStudentBySno(int sno) {
		return studentDao.queryStudentBySno(sno);
	}
	
	//查询所有学生
	public List<Student>  queryAllStudents(){
		return studentDao.queryAllStudent();
	}

	//查询数据总条数
	@Override
	public int getTotalCount() {
		return studentDao.getTotalCount();
	}

	//查询当前页面数据集合
	@Override
	public List<Student> queryStudentsByPage(int currentPage, int pageSize) {
		return studentDao.queryStudentsByPage(currentPage, pageSize);
	}

}
