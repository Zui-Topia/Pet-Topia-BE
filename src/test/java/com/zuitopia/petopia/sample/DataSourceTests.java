package com.zuitopia.petopia.sample;

import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import lombok.extern.log4j.Log4j;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:**/*-context.xml")
@Log4j
public class DataSourceTests {
	@Autowired
	private DataSource dataSource;
	
	@Autowired 
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void testConnection() {

		SqlSession session = sqlSessionFactory.openSession();
		Connection con = session.getConnection();

		log.info(session);
		log.info(con);
//		try(){
//
//		}
//		catch (Exception e) {
//			fail(e.getMessage());
//		}
	}
}
