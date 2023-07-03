package com.solvd.navigator.dao.impl.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

public abstract class MyBatisDAO {
	private static final Logger logger = LogManager.getLogger(MyBatisDAO.class.getName());

	protected <T> T executeWithSession(SessionFunction<T> sessionFunction) {
		try (InputStream configStream = Resources.getResourceAsStream("mybatis-config.xml");
			 InputStream propStream = Resources.getResourceAsStream("db.properties")) {
			Properties props = new Properties();
			props.load(propStream);

			System.setProperty("url", props.getProperty("db.url"));
			System.setProperty("user", props.getProperty("db.user"));
			System.setProperty("password", props.getProperty("db.password"));

			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configStream, System.getProperties());
			SqlSession session = sqlSessionFactory.openSession();
			return sessionFunction.apply(session);
		} catch (SQLException | IOException e) {
			logger.error(e);
			return null;
		}
	}
}