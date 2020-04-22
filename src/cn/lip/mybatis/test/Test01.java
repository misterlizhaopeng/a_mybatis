package cn.lip.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.lip.mybatis.bean.DeptInfo;
import cn.lip.mybatis.bean.Student;
import cn.lip.mybatis.bean.StudentSecond;
import cn.lip.mybatis.dao.IDeptInfoMapper;
import cn.lip.mybatis.dao.IStudentAnnotation;
import cn.lip.mybatis.dao.IStudentMapper;

public class Test01 {
	private SqlSessionFactory getSqlSessionFactory() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void helloWorld() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		SqlSession session = sqlSessionFactory.openSession();
		Student student = session.selectOne("cn.lip.mybatis.dao.IStudentMapper.getStudentById", "1");
		System.err.println(student);

		session.close();
	}

	@Test
	public void helloworld2() throws IOException {
		SqlSessionFactory factory = getSqlSessionFactory();
		SqlSession session = factory.openSession();
		System.err.println(session.getConnection());

		IStudentMapper iStudent = session.getMapper(IStudentMapper.class);
		// System.err.println(iStudent.getStudentById(7900));
		System.err.println(iStudent.getStudentById(1));
		session.close();
	}

	@Test
	public void helloworldAnnotation() throws IOException {
		// SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSessionFactory factory = getSqlSessionFactory();
		SqlSession session = factory.openSession();

		System.err.println(session.getConnection());
		IStudentAnnotation iStudent = session.getMapper(IStudentAnnotation.class);
		System.err.println(iStudent.getStudentById(1));
	}

	@Test
	public void testCUD() throws IOException {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		IStudentMapper mapper = openSession.getMapper(IStudentMapper.class);
		// Student student = new Student();
		// student.setName("rose");
		// student.setAge(21);
		// int addStu = mapper.addStu(student);
		// int acId=student.getId();

		Student student = new Student();
		student.setName(UUID.randomUUID().toString().substring(1, 10));
		student.setAge(12);
		mapper.addStu(student);
		System.out.println(student.getId());

		// update
		// Student student = new Student();
		// student.setId(61086);
		// student.setName("Update-tom-1");
		// student.setAge(31);
		// boolean updateStu = mapper.updateStu(student);
		// System.err.println(updateStu);

		// delete
		// boolean deleteStu = mapper.deleteStu(acId);
		// System.err.println(">>"+deleteStu);

		openSession.commit();
		openSession.close();

	}

	@Test
	public void getByMultiParam() throws IOException {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		IStudentMapper mapper = openSession.getMapper(IStudentMapper.class);
		Student studentByIdAndName = mapper.getStudentByIdAndName(2, "lp");
		System.err.println(studentByIdAndName);
		openSession.close();

	}

	@Test
	public void testMapKey() throws IOException {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		IStudentMapper mapper = sqlSession.getMapper(IStudentMapper.class);
		Map<Integer, Student> map1 = mapper.getStudentReturnMap("%1%");

		for (Map.Entry<Integer, Student> entry : map1.entrySet()) {
			Student student = entry.getValue();
			System.out.println(entry.getKey() + ":-> " + student);
		}
		sqlSession.close();
	}

	@Test
	public void selectTest() throws IOException {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		IStudentMapper mapper = sqlSession.getMapper(IStudentMapper.class);

		List<Student> stus = mapper.getStudentListByLastName("%1%");
		for (Student student : stus) {
			System.err.println(student);
		}

		List<Map<String, Object>> maps = mapper.getStudentMapList(61086);
		Map<String, Object> map = mapper.getStudentMap(61086);
		System.out.println(map);

		Student a = mapper.getBeanByResultMapMethod(1);
		System.out.println(a);
		sqlSession.close();//

		SqlSession sqlSession2 = sqlSessionFactory.openSession();
		IStudentMapper mapper2 = sqlSession2.getMapper(IStudentMapper.class);
		Student b = mapper2.getBeanByResultMapMethod(1);
		System.out.println(b);
		System.out.println(a == b);

		// sqlSession2.close();
	}

	@Test
	public void selectByStep() throws IOException {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		IStudentMapper mapper = sqlSession .getMapper(IStudentMapper.class);
		StudentSecond studentByStep = mapper.getStudentByStep(2);
		
		System.err.println(studentByStep.getName()+"\r\n");
		System.err.println(studentByStep.getDeptInfo());
		
//		System.err.println(studentByStep);
		sqlSession.close();
	}

	@Test
	public void selectCasResult() throws IOException {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		IStudentMapper mapper = openSession.getMapper(IStudentMapper.class);

		StudentSecond cascResult = mapper.getCascResult(2);
		System.out.println(cascResult);
		System.out.println(cascResult.getDeptInfo());

		IDeptInfoMapper mapper2 = openSession.getMapper(IDeptInfoMapper.class);
		DeptInfo deptStudent = mapper2.getDeptStudent(3);
		System.err.println(deptStudent);

		IDeptInfoMapper mapper3 = openSession.getMapper(IDeptInfoMapper.class);
		DeptInfo deptStudentByStep = mapper3.getDeptStudentByStep(3);
		System.err.println(deptStudentByStep);
		openSession.close();
	}
}
