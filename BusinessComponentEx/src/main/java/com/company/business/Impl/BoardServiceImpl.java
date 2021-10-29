package com.company.business.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.business.board.BoardDO;
import com.company.business.board.BoardService;
import com.company.business.common.LogAdvice;

/*
 * 구현 클래스이다.
 * 어느 클래스 선언 부 위에 @Service 어노테이션을 붙이면
 * 이 클래스는 비즈니스 로직을 처리하는 클래스라고 스프링 컨테이너에게 알려준다.
 */

@Service("boardService")
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDAO boardDAO;
	//추가(공통부분을 위해)
	private LogAdvice log;
	
	//생성자
	public BoardServiceImpl() {
		// TODO Auto-generated constructor stub
		log = new LogAdvice();
	}

	@Override
	public List<BoardDO> getBoardList() {
		//추가
		//log.printLog(); //공통 부분
		//보안처리
		//트랜잭션
		return boardDAO.getBoardList();
	}

	@Override
	public BoardDO getBoard(BoardDO boardDO) {
		//추가
		//log.printLog(); //공통 부분
		//보안처리
		//트랜잭션
		return boardDAO.getBoard(boardDO);
	}

	@Override
	public void insertBoard(BoardDO boardDO) {
		//추가
		//log.printLog(); //공통 부분
		//보안처리
		//트랜잭션
		boardDAO.insertBoard(boardDO);
	}

	@Override
	public void updateBoard(BoardDO boardDO) {
		//추가
		//log.printLog(); //공통 부분
		//보안처리
		//트랜잭션
		//boardDAO.updateBoard(boardDO);
	}

	@Override
	public void deleteBoard(BoardDO boardDO) {
		//추가
		//log.printLog(); //공통 부분
		//보안처리
		//트랜잭션
		//boardDAO.deleteBoard(boardDO);
	}

}
