package kr.or.ddit.springmvc.board.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.springmvc.board.vo.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
			"/egovframework/spring/context-common.xml",
			"/egovframework/spring/context-datasource.xml",
			"/egovframework/spring/context-mapper.xml"
})
public class BoardMapperJUnit {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardMapperJUnit.class);
	
	@Resource(name="boardMapper")
	private BoardMapper boardMapper;
	
	@Test
	public void createTest() throws Exception {
		
		BoardVO paramBoardVO = new BoardVO();
		
		for(int i = 0 ; i < 300 ; i++) {
			paramBoardVO.setTitle((i+1) + " 번째 title");
			paramBoardVO.setContents((i+1) + "번쨰 contents");
			paramBoardVO.setWriter("writer");
			paramBoardVO.setUserPassword("pass");
			paramBoardVO.setOpenYn("Y");
			boardMapper.create(paramBoardVO);
			
			logger.info("paramBoardVO.getBoardSn() : {}", paramBoardVO.getBoardSn());
		}
		
		assertNotNull(paramBoardVO.getBoardSn());
	}
	
	@Test
	public void retrieveTest() throws Exception {
		
		BoardVO paramBoardVO = new BoardVO();
		
		paramBoardVO.setBoardSn("10");
		
		BoardVO boardVO = boardMapper.retrieve(paramBoardVO);
		
		logger.info("boardVO : {}", boardVO);
		
		assertNotNull(boardVO);
	}
	
	@Test
	public void updateTest() throws Exception {
		
		BoardVO paramBoardVO = new BoardVO();
		
		paramBoardVO.setBoardSn("10");
		paramBoardVO.setTitle("titleUpdate");
		paramBoardVO.setContents("contentsUpdate");
		paramBoardVO.setWriter("writerUpdate");
		paramBoardVO.setUserPassword("passUpdate");
		paramBoardVO.setOpenYn("N");
		
		int cnt = boardMapper.update(paramBoardVO);
		logger.info("updateCnt : {}", cnt);
		
		assertTrue(cnt > 0);
	}
	
	@Test
	public void deleteTest() throws Exception {
		
		BoardVO paramBoardVO = new BoardVO();
		
		paramBoardVO.setBoardSn("12");
		
		int cnt = boardMapper.delete(paramBoardVO);
		logger.info("deleteCnt : {}", cnt);
		
		assertTrue(cnt > 0);
	}
	
	@Test
	public void retrieveListTest() throws Exception {
		
		BoardVO paramBoardVO = new BoardVO();
		
		List<BoardVO> list = boardMapper.retrieveList(paramBoardVO);

		for(BoardVO boardVO : list) {
			logger.info(boardVO.getTitle());
		}
		
		assertTrue(list.size() > 0);
		
	}
	
}
