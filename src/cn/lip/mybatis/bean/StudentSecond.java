package cn.lip.mybatis.bean;

import java.io.Serializable;

public class StudentSecond implements Serializable {
	private int id;
	private String name;
	private int age;
	private int deptId;
	private DeptInfo deptInfo;
	
	
	
	
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "StudentSecond [id=" + id + ", name=" + name + ", age=" + age + ", deptInfo=" + deptInfo + "]";
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public DeptInfo getDeptInfo() {
		return deptInfo;
	}
	public void setDeptInfo(DeptInfo deptInfo) {
		this.deptInfo = deptInfo;
	}
	
}
