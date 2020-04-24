package cn.lip.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import cn.lip.mybatis.bean.Student;
import cn.lip.mybatis.bean.StudentSecond;

/**
 * mybatis ����ӿڲ�ѯһ��Student����
 * 
 * @author misterLip
 * @date 2018��5��5��
 */
public interface IStudentMapper {
	public StudentSecond getStudentDeptByStep(int deptId);
	
	public StudentSecond getStudentByStep(int id);
	public StudentSecond getCascResult(Integer id);
	public Student getBeanByResultMapMethod(int id);
	
	/**
	 * �ܽ�:����map����ļ��ϣ�
	 * 
	 * ���ս��ΪList�������� mapper �� xml �ڵ���resultTypeΪ��������Ķ������ͣ�
	 * 					xml:<select id="getStudentListByLastName" resultType="stus" databaseId="mysql">
	 * 					method:public List<Student> getStudentListByLastName(String lastName);
	 * ���ս��ΪList<Map<,>>�����������ԭ��resultTypeΪmap���ͣ�
	 * 					xml:<select id="getStudentMapList" resultType="map" databaseId="mysql">
	 * 					method:public List<Map<String,Object>> getStudentMapList(int id);
	 * �������������
	 * @date 2019��3��17��
	 * @author misterLip
	 */
	@MapKey("id")
	public Map<Integer, Student> getStudentReturnMap(String name);
	public List<Map<String,Object>> getStudentMapList(int id);
	public Map<String,Object> getStudentMap(int id);
	public List<Student> getStudentListByLastName(String lastName);
	public Student getStudentByIdAndName(@Param("id") int id, @Param("name") String name);
	//public Student getStudentByIdAndName(int id, String name);
	public Student getStudentById(Integer id);
	public int addStu(Student student);
	public boolean updateStu(Student student);
	public boolean deleteStu(Integer id);
	
	
	//���� statementType="STATEMENT"
	public boolean updateTb(Map<String,Object> map);
}