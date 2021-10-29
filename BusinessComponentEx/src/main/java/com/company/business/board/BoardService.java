package com.company.business.board;

import java.util.List;

public interface BoardService {
	//추상메소드
	//전체 게시글 목록 조회
	List<BoardDO> getBoardList();
	
	//게시글 상세보기
	BoardDO getBoard(BoardDO boardDO);
	
	//게시글 등록
	void insertBoard(BoardDO boardDO);
	
	//게시글 수정
	void updateBoard(BoardDO boardDO);
	
	//게시글 삭제
	void deleteBoard(BoardDO boardDO);
}
