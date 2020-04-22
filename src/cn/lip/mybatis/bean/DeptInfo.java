package cn.lip.mybatis.bean;

import java.util.List;

public class DeptInfo {
	private int id;
	private String deptName;
	private List<Student> students;
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
 

	@Override
	public String toString() {
		return "DeptInfo [id=" + id + ", deptName=" + deptName + ", students=" + students + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	
	
}
