package cn.lip.mybatis.plugin;

import java.util.Properties;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Invocation;

public class TestPlugin  implements Interceptor{

	/**
	 * 
	 */
	@Override
	public Object intercept(Invocation arg0) throws Throwable {
		return null;
	}

	@Override
	public Object plugin(Object arg0) {
		return null;
	}

	@Override
	public void setProperties(Properties arg0) {
	}

}
