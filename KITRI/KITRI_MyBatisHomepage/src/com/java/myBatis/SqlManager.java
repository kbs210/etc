package com.java.myBatis;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.io.Resources;

public class SqlManager {
	private static SqlSessionFactory sqlSessionfactory;
	public static SqlSessionFactory getInstance() {
		try {
			String resource = "com/java/myBatis/sqlConfig.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionfactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sqlSessionfactory;
	}
}
