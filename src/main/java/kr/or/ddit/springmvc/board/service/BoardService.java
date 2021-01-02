package kr.or.ddit.springmvc.board.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.springmvc.board.dao.BoardMapper;
import kr.or.ddit.springmvc.board.vo.BoardVO;

@Service("boardService")
public class BoardService {
	
	
	@Resource(name = "boardMapper")
	BoardMapper boardMapper;
	
	public void create(BoardVO boardVO) throws Exception{
		boardMapper.create(boardVO);
	}
	
	public BoardVO retrieve (BoardVO boardVO) throws Exception{
		return boardMapper.retrieve(boardVO);
	}
	
	public int update(BoardVO boardVO) throws Exception{
		return boardMapper.update(boardVO);
	}
	
	public int delete(BoardVO boardVO) throws Exception{
		return boardMapper.delete(boardVO);
	}
	
	public List<BoardVO> retrieveList (BoardVO boardVO) throws Exception{
		return boardMapper.retrieveList(boardVO);
	}
	
	public List<BoardVO> retrievePagingList (BoardVO boardVO) throws Exception{
		return boardMapper.retrievePagingList(boardVO);
	}
	
	public int retrievePagingListCnt (BoardVO boardVO) throws Exception{
		return boardMapper.retrievePagingListCnt(boardVO);
	}

}
