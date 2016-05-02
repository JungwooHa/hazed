package org.zerock.controller;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;
import org.zerock.persistence.BoardDAO;
import org.zerock.persistence.ReplyDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BoardDAOTest {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);
	
	@Inject
	BoardDAO dao;
	
	@Inject
	ReplyDAO rdao;
	
	@Test
	public void reply() throws Exception {
		ReplyVO vo = new ReplyVO();
		vo.setRno(2);
		vo.setReplytext("------------------");
		rdao.update(vo);
	}

	@Test
	public void test() throws Exception {
		BoardVO vo = new BoardVO();
		vo.setTitle("Ÿ��Ʋ�׽�Ʈ");
		vo.setContent("����Ʈ�׽�Ʈ");
		vo.setWriter("lala");
		dao.insert(vo);
	}
	
	@Test
	public void test1(){
		try{
			System.out.println(dao.select1(2).toString());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void List(){
		try {
			System.out.println(dao.ListAll().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void update(){
		try {
			BoardVO vo = new BoardVO();
			vo.setBno(3);
			vo.setTitle("�����ϴ� title");
			vo.setContent("�����ϴ� content");
			vo.setWriter("�����ϴ� writer");
			dao.update(vo);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Test
	public void delete(){
		try {
			dao.delete(5);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@Test
	public void testListPage() throws Exception{
		int page = 4;
		
		List<BoardVO> list = dao.listpage(page);
		
		
		

		for(BoardVO boardVO:list){
			
			logger.info(boardVO.getTitle());
			System.out.println(boardVO.getBno());
		}
	}
	@Test
	public void testListCriteria() throws Exception{
		Criteria cri = new Criteria();
		cri.setPage(3);
		cri.setPerPageNum(10);
		
		List<BoardVO>list = dao.listCriteria(cri);
		
		for(BoardVO boardvo : list){
			logger.info(boardvo.getBno()+": "+boardvo.getTitle());
		}
		
	}
	
	@Test
	public void testURI()throws Exception{
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
				.path("{module}/{page}").queryParam("bno", 12).queryParam("perPageNum", 20)
				.build().expand("boards","readpage").encode();
		
		logger.info("/boards/readpage?bno=12&perPageNum=20");
		logger.info(uriComponents.toString());
	}


}
