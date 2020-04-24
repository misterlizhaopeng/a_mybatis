package cn.lip.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import cn.lip.mybatis.bean.Student;
import cn.lip.mybatis.bean.StudentSecond;

/**
 * mybatis 面向接口查询一个Student对象
 * 
 * @author misterLip
 * @date 2018年5月5日
 */
public interface IStudentMapper {
	public StudentSecond getStudentDeptByStep(int deptId);
	
	public StudentSecond getStudentByStep(int id);
	public StudentSecond getCascResult(Integer id);
	public Student getBeanByResultMapMethod(int id);
	
	/**
	 * 总结:返回map对象的集合：
	 * 
	 * 最终结果为List，但是在 mapper 的 xml 节点中resultType为集合里面的对象类型；
	 * 					xml:<select id="getStudentListByLastName" resultType="stus" databaseId="mysql">
	 * 					method:public List<Student> getStudentListByLastName(String lastName);
	 * 最终结果为List<Map<,>>，类似上面的原理，resultType为map类型；
	 * 					xml:<select id="getStudentMapList" resultType="map" databaseId="mysql">
	 * 					method:public List<Map<String,Object>> getStudentMapList(int id);
	 * 此种情况不常用
	 * @date 2019年3月17日
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
	
	
	//测试 statementType="STATEMENT"
	public boolean updateTb(Map<String,Object> map);
}