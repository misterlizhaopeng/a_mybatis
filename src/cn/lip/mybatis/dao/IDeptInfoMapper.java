package cn.lip.mybatis.dao;

import cn.lip.mybatis.bean.DeptInfo;

public interface IDeptInfoMapper {
	public DeptInfo getDeptStudentByStep(int id);
	public DeptInfo getDeptStudent(int id);
	public DeptInfo getDeptInfo(int id);
}
