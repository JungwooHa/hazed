package org.zerock.com;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.ChildVO;
import org.zerock.persistence.ChildDAO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class DBTest {
	
	private static final Logger logger = LoggerFactory.getLogger(DBTest.class);
	@Inject
	DataSource ds;

	@Inject
	private ChildDAO dao;
	
	@Test
	public void test() {
		try {
			Connection con = ds.getConnection();
			System.out.println(con);
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	@Test
	public void insertTest() throws Exception{
		ChildVO vo = new ChildVO();
		vo.setAge(5);
		vo.setClevel(6);
		vo.setCname("박요주");
		vo.setDeep(3);
		vo.setImgpath("C:\\team42\\child\\");
		vo.setSchool("성학초등학교");
		vo.setUserid("aaaa");
		dao.add(vo);
		
	}
	
	@Test
	public void deleteTest()throws Exception{
		dao.remove(2);
	}
	
	@Test
	public void updateTest() throws Exception{
		ChildVO vo = new ChildVO();
		vo.setAge(5);
		vo.setClevel(6);
		vo.setCname("박찬성");
		vo.setDeep(3);
		vo.setImgpath("C:\\team42\\ㅋㅋㅋㅋ\\");
		vo.setSchool("오라초등학교");
		vo.setUserid("wantme");
		dao.renew(vo);
	}
	@Test
	public void listAllTest()throws Exception{
		
		List<ChildVO> list = dao.listAll();
		logger.info("AllList"+list);
	}
	@Test
	public void oneSelect()throws Exception{
		System.out.println(dao.read(2).toString());
		
	}
	

}
