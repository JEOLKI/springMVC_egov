package kr.or.ddit.springmvc.board.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import kr.or.ddit.springmvc.board.service.BoardService;
import kr.or.ddit.springmvc.board.vo.BoardVO;

@Controller
public class BoardController {
	
	/** EgovSampleService */
	@Resource(name = "boardService")
	private BoardService boardService;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/** Validator */
	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;

	/**
	 * 글 목록을 조회한다. (pageing)
	 * @param boardVO - 조회할 정보가 담긴 BoardVO
	 * @param model
	 * @return "boardList"
	 * @exception Exception
	 */
	@RequestMapping(value = "/board/retrievePagingList.do")
	public String retrievePagingList(BoardVO boardVO, ModelMap model) throws Exception {

		/** EgovPropertyService.sample */
		boardVO.setPageUnit(propertiesService.getInt("pageUnit"));
		boardVO.setPageSize(propertiesService.getInt("pageSize"));

		/** pageing setting */
		PaginationInfo paginationInfo = new PaginationInfo();
		boardVO.preparePaginationInfo(paginationInfo);

		List<BoardVO> resultList = boardService.retrievePagingList(boardVO);
		model.addAttribute("resultList", resultList);

		int totCnt = boardService.retrievePagingListCnt(boardVO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);

		return "board/list";
	}
	
	@RequestMapping(value = "/board/updateView.do")
	public String updateView(BoardVO boardVO, ModelMap model) throws Exception {
		
		BoardVO retrieveBoardVO = boardService.retrieve(boardVO);
//		retrieveBoardVO.setSearchCondition(boardVO.getSearchCondition());
//		retrieveBoardVO.setSearchKeyword(boardVO.getSearchKeyword());
//		retrieveBoardVO.setPageIndex(boardVO.getPageIndex());
		
		retrieveBoardVO.copySearchCondition(boardVO);

//		BeanUtils.copyProperties(boardVO, retrieveBoardVO);
		model.addAttribute("boardVO", retrieveBoardVO);
		
		return "board/edit";
	}


	@RequestMapping(value = "/board/update.do")
	public String update(BoardVO boardVO, ModelMap model) throws Exception {
		
		int cnt = boardService.update(boardVO);
		
		return "forward:/board/retrievePagingList.do";
	}
	
	@RequestMapping(value = "/board/delete.do")
	public String delete(BoardVO boardVO, ModelMap model) throws Exception {
		
		int cnt = boardService.delete(boardVO);
		
		return "forward:/board/retrievePagingList.do";
	}
	
	
	@RequestMapping(value = "/board/createView.do")
	public String createView(BoardVO boardVO, ModelMap model) throws Exception {
		
		model.addAttribute("boardVO", new BoardVO());
		
		return "board/edit";
	}
	
	@RequestMapping(value = "/board/create.do")
	public String create(BoardVO boardVO, BindingResult bindingResult, ModelMap model) throws Exception {
		
		// Server-Side Validation
		beanValidator.validate(boardVO, bindingResult);

		if (bindingResult.hasErrors()) {
			return "board/edit";
		}
		
		boardService.create(boardVO);
		
		return "forward:/board/retrievePagingList.do";
	}
	
}
