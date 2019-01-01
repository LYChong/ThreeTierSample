package org.student.dao.lmpl;

import java.nio.channels.SelectableChannel;
import java.rmi.server.ObjID;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.student.dao.IStudentDao;
import org.student.entity.Student;
import org.student.util.DBUtil;

//数据访问层：  原子性不可拆  增删改查
public  class StudentDaolmpl implements IStudentDao {
	private final String URL = "jdbc:mysql://localhost:3306/student?useSSL=false";
	private final String USER = "root";
	private final String PASSWORD = "root";
	
	//增加学生
	public boolean addStudent(Student student) {
		String sql = "insert into student(sno,sname,sage,saddress) values(?,?,?,?)";
		Object[] params = {student.getSno(),student.getSname(),student.getAge(),student.getAddress()};
		return DBUtil.executeUpdate(sql, params);
	}
	
	//根据学号   删除学生
	public boolean deleteStudentBysno(int sno) {
		String sql = "delete from student where sno = ?";
		Object[] params = {sno};
		return DBUtil.executeUpdate(sql, params);
	}
	
	//根据学号   修改学生信息： 根据sno找到待修改的人，把这个人修改成student
	public boolean updateStudentBySno(int sno,Student student) {
		String sql = "update student set sname =?,sage =?,saddress =?where sno =?";
		Object[] params = {student.getSname(),student.getAge(),student.getAddress(),sno};
		return DBUtil.executeUpdate(sql, params);
	}
	
	//查询全部学生(很多学生
	public List<Student> queryAllStudent() {
		List<Student> students = new ArrayList<>();
		Student student = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			String sql = "select * from student ";
			rs = DBUtil.executeQuery(sql, null);
			
			while (rs.next()) {
				int no = rs.getInt("sno");
				String name = rs.getString("sname");
				int age = rs.getInt("sage");
				String address = rs.getString("saddress");
				student = new Student(no,name,age,address);
				students.add(student) ;
			}
			return students;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			DBUtil.closeAll(rs, pstmt, DBUtil.connection);
		}
		
	}



	
	//查询学生是否存在
		public boolean isExist(int sno) {
			return queryStudentBySno(sno)==null? false:true;
			
		}
	
	//根据学号  查询学生
	public Student queryStudentBySno(int sno) {
		Student student = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from student where sno=?";
			Object[] params = {sno};
			rs = DBUtil.executeQuery(sql, params);
			if (rs.next()) {
				int no = rs.getInt("sno");
				String name = rs.getString("sname");
				int age = rs.getInt("sage");
				String address = rs.getString("saddress");
				student = new Student(no,name,age,address);
			}
			return student;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(DBUtil.connection!=null)DBUtil.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	//查询总数数
	public int getTotalCount() {
		String sql = "select count(1) from student";
		return DBUtil.getTotalCount(sql);
	}

	@Override
	//查询某一页
	public List<Student> queryStudentsByPage(int currentPage, int pageSize) {
		String sql = "select * from student limit ?,?";
		Object[] params = {(currentPage-1)*pageSize,pageSize};
		ResultSet rs = DBUtil.executeQuery(sql, params);
		List<Student> students = new ArrayList<>();
		try {
			while(rs.next()) {
				Student student = new Student(rs.getInt("sno"),rs.getString("sname"),rs.getInt("sage"),rs.getString("sage"));
				students.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;
	}

}





///
///                   _ooOoo_
///                  o8888888o
///                  88" . "88
///                  (| -_- |)
///                  O\  =  /O
///               ____/`---'\____
///             .'  \\|     |//  `.
///            /  \\|||  :  |||//  \
///           /  _||||| -:- |||||-  \
///           |   | \\\  -  /// |   |	00
///           | \_|  ''\---/''  |   |
///           \  .-\__  `-`  ___/-. /
///         ___`. .'  /--.--\  `. . __
///      ."" '<  `.___\_<|>_/___.'  >'"".
///     | | :  `- \`.;`\ _ /`;.`/ - ` : | |
///     \  \ `-.   \_ __\ /__ _/   .-` /  /
 














