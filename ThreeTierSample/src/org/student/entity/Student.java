package org.student.entity;

public class Student {
	private int sno;
	private String sname;
	private int sage;
	private String saddress;
	public Student() {
			
	}
	
	public Student(String name,int age, String address) {
		this.sage = age;
		this.saddress = address;
	}
	
	public Student(int no, String name, int age, String address) {
		
		this.sno = no;
		this.sname = name;
		this.sage = age;
		this.saddress = address;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getAge() {
		return sage;
	}
	public void setAge(int sage) {
		this.sage = sage;
	}
	public String getAddress() {
		return saddress;
	}
	public void setAddress(String saddress) {
		this.saddress = saddress;
	}
	public String toString() {
		return this.getSno()+"-"+this.getSname()+"-"+this.getAge()+"-"+this.getAddress();
	}

}
