package cn.lip.mybatis.dao;

import org.apache.ibatis.annotations.Select;

import cn.lip.mybatis.bean.Student;

public interface IStudentAnnotation {

	@Select("select id,name,age from student where id = #{id} ")
	public Student getStudentById(Integer id);
}
