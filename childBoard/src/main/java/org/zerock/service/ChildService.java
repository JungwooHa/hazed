package org.zerock.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zerock.domain.ChildVO;
import org.zerock.persistence.ChildDAO;

@Service
public class ChildService {

	@Inject
	private ChildDAO dao;
	
	public void regist(ChildVO vo)throws Exception{
		dao.add(vo);
	}
	
	public ChildVO read(Integer cno)throws Exception{
		return dao.read(cno);
	}
	
	public void modify(ChildVO vo)throws Exception{
		dao.renew(vo);
	}
	
	public void remove(Integer cno)throws Exception{
		dao.remove(cno);
	}
	
	public List<ChildVO>listAll()throws Exception{
		return dao.listAll();
	}
	
}
