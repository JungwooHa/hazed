package org.zerock.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.ChildVO;

@Repository
public class ChildDAO {

	private String namespace ="org.zerock.persistence.mapper";
	
	@Inject
	private SqlSession session;
	
	
	
	public void add(ChildVO vo)throws Exception{
		session.insert(namespace+".insert",vo);
	}
	
	public void remove(Integer cno)throws Exception{
		session.delete(namespace+".delete",cno);
	}
	
	public void renew(ChildVO vo)throws Exception{
		session.update(namespace+".update",vo);
	}
	
	public List<ChildVO> listAll()throws Exception{
		return session.selectList(namespace+".readAll");
	}
	
	public ChildVO read(Integer cno)throws Exception{
		return session.selectOne(namespace+".read", cno);
	}
}
