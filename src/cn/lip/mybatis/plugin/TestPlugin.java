package cn.lip.mybatis.plugin;

import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

@Intercepts(@Signature(type = StatementHandler.class, method = "parameterize", args = java.sql.Statement.class))
public class TestPlugin implements Interceptor {

	/**
	 * ������������Ŀ�����ķ�����ִ��
	 */
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		System.out.println("cn.lip.mybatis.plugin.TestPlugin.intercept is invoked !......");
		Object proceed = invocation.proceed();
		return proceed;
	}

	/**
	 * ��װĿ�����ΪĿ����󴴽�һ���������
	 *
	 * @param target
	 * @return
	 */
	@Override
	public Object plugin(Object target) {
		System.out.println("mybatis ��Ҫ��װ�Ķ���" + target);
		Object wrap = Plugin.wrap(target, this);
		return wrap;
	}

	/**
	 * �����ע��ʱ����������ý���
	 *
	 * @param properties
	 */
	@Override
	public void setProperties(Properties properties) {
		System.out.println(properties);
	}

}
