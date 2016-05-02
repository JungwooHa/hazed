package org.zerock.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.persistence.BoardDAO;
@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	BoardDAO dao;
	
	@Transactional
	@Override
	public void register(BoardVO board) throws Exception {
		dao.insert(board);
		
		String[] files=board.getFiles();
		
		if(files == null){
			return;
		}
		for (String fileName : files) {
			dao.addAttach(fileName);
		}

	}

	@Override
	public BoardVO selectOne(Integer bno) throws Exception {
		return dao.select1(bno);
		
	}

	@Override
	public void update(BoardVO board) throws Exception {
		dao.update(board);

	}

	@Override
	public void delete(Integer bno) throws Exception {
		dao.delete(bno);

	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return dao.ListAll();
	}

	@Override
	public List<BoardVO> listCriteria(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.listCriteria(cri);
	}

	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.countPaging(cri);
	}

	@Override
	public List<String> getAttach(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return dao.getAttach(bno);
	}

}
