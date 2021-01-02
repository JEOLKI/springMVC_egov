package kr.or.ddit.springmvc.board.dao;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.or.ddit.springmvc.board.vo.BoardVO;

@Mapper("boardMapper")
public interface BoardMapper {
	
	void create(BoardVO boardVO) throws Exception;

	BoardVO retrieve (BoardVO boardVO) throws Exception;
	
	int update(BoardVO boardVO) throws Exception;
	
	int delete(BoardVO boardVO) throws Exception;
	
	List<BoardVO> retrieveList (BoardVO boardVO) throws Exception;
	
	List<BoardVO> retrievePagingList (BoardVO boardVO) throws Exception;

	int retrievePagingListCnt (BoardVO boardVO) throws Exception;

}