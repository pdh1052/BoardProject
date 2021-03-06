package kr.co.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.vo.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO{

	
	@Inject
	private SqlSession sqlsession;
	
	private final String NS = "kr.co.board";
	
	@Override
	public void insert(BoardVO vo) {
		
		sqlsession.insert(NS+".insert", vo);
		
	}

	@Override
	public BoardVO read(int bno) {
		
		return sqlsession.selectOne(NS+".read", bno);
	}

	@Override
	public List<BoardVO> list() {
		// TODO Auto-generated method stub
		return sqlsession.selectList(NS+".list");
	}

	@Override
	public BoardVO updateUI(int bno) {
		// TODO Auto-generated method stub
		return sqlsession.selectOne(NS+".updateUI", bno);
	}

	@Override
	public void update(BoardVO vo) {
		// TODO Auto-generated method stub
		
		sqlsession.update(NS+".update", vo);
	}

	@Override
	public void delete(int bno) {
		// TODO Auto-generated method stub
		sqlsession.delete(NS+".delete", bno);
	}

}
