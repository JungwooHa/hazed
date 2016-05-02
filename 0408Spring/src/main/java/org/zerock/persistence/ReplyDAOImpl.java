package org.zerock.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;
@Service
public class ReplyDAOImpl implements ReplyDAO {

	
	@Inject
	private SqlSession session;
	
	private static String namespace = "org.zerock.mappers.ReplyMapper";
	
	@Override
	public List<ReplyVO> list(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".list",bno);
	}

	@Override
	public void create(ReplyVO vo) throws Exception {
		session.insert(namespace+".insert",vo);

	}

	@Override
	public void update(ReplyVO vo) throws Exception {
		session.update(namespace + ".update",vo);

	}

	@Override
	public void delete(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		session.delete(namespace+".delete",bno);

	}

	@Override
	public List<ReplyVO> listPage(Integer bno, Criteria cri) throws Exception {
		System.out.println("=================dddd=d============================");
		System.out.println(bno);
		System.out.println(cri);
		Map<String, Object>paramMap = new HashMap<String, Object>();
		
		paramMap.put("bno", bno);
		paramMap.put("cri", cri);
		
		return session.selectList(namespace+".listPage",paramMap);
	}

	@Override
	public int count(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".count",bno);
	}

}
