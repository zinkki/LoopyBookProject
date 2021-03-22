package kr.co.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import lombok.extern.log4j.Log4j2;

@Log4j2
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DataSourceTest {

	@Autowired
	DataSource ds;
	
	@Test
	public void jdbcTest() throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "system";
		String pw = "1234";
		
		Class cla = Class.forName("oracle.jdbc.OracleDriver"); //드라이버네임 체크
		log.info(cla);
		
		con = DriverManager.getConnection(url, id, pw);
		log.info(con);
		
	}
	
	@Autowired
	SqlSessionFactory ssf;
	
	@Test
	public void mybatisTest() throws Exception {
		SqlSession ss = ssf.openSession();
		Connection con = ss.getConnection();
		
		log.info(con);
	}
}
