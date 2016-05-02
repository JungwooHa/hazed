package org.zerock.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Inject
	private SqlSession session;
	
	private String namespace = "org.zerock.persistence.boardmapper";

	@Override
	public void insert(BoardVO vo) throws Exception {
		session.insert(namespace+".insert",vo);
	}

	@Override
	public BoardVO select1(Integer bno) throws Exception {
		return session.selectOne(namespace+".selectOne",bno);	
	}

	@Override
	public List<BoardVO> ListAll() throws Exception {
		return session.selectList(namespace+".List");
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		session.update(namespace+".update",vo);

	}

	@Override
	public void delete(Integer bno) throws Exception {
		session.delete(namespace+".delete",bno);
	}

	@Override
	public List<BoardVO> listpage(int page) throws Exception {
		
		
		
		if(page <=0){
			page =1;
		}
		
		int realpage = page;
	
		return session.selectList(namespace+".listpage", realpage);
	}

	@Override
	public List<BoardVO> listCriteria(Criteria cri) throws Exception {
		
		
		return session.selectList(namespace+".listCriteria", cri);
	}

	@Override
	public int countPaging(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".countPaging",cri);
	}

	@Override
	public void addAttach(String fullName) throws Exception {
		session.insert(namespace+".addAttach", fullName);
		
	}

	@Override
	public List<String> getAttach(Integer bno) throws Exception {
		return session.selectList(namespace+".getAttach", bno);
	}

}
