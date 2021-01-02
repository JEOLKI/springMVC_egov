package kr.or.ddit.springmvc.board.vo;

import kr.or.ddit.springmvc.base.vo.BaseVO;

public class BoardVO extends BaseVO {

	private String boardSn;
	private String title;
	private String contents;
	private String writer;
	private String userPassword;
	private String openYn;

	public String getBoardSn() {
		return boardSn;
	}

	public void setBoardSn(String boardSn) {
		this.boardSn = boardSn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getOpenYn() {
		return openYn;
	}

	public void setOpenYn(String openYn) {
		this.openYn = openYn;
	}

}
