package com.company.view.board;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.annotation.board.BoardDAO;
import com.company.annotation.board.BoardDO;

/**
 * 
 * Ŀ�ǵ�(command) ��ü��?
 *   => Ŭ���̾�Ʈ�� �����ִ� �Ķ���Ͱ� �ڵ����� ��ܼ� ��ȯ�Ǵ� ��ü�� ���Ѵ�.
 *      �̴� '�ڵ� ��ü ��ȯ'�̶�� �ϸ�, MVC ������ ���Ͽ��� ���� ū �ٽ� ��� �߿� 
 *      �ϳ��̴�.
 * ������������  @RequestMapping�� �̿��Ͽ� HandlerMapping ������ ��ü�Ѵ�.    
 */

@Controller
public class BoardController {  //���� ��Ʈ�ѷ�
	//��ü �Խñ� ��� �˻�
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardDO boardDO, BoardDAO boardDAO, Model model) {
		model.addAttribute("boardList", boardDAO.getBoardList(boardDO));
		return "getBoardList.jsp";
	}
	//�Խñ� �󼼺���
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardDO boardDO, BoardDAO boardDAO, Model model) {
		model.addAttribute("board", boardDAO.getBoard(boardDO));
		return "getBoard.jsp";
	}
	//[��Ʈ] DML �۾� �� ���� BoardDO boardDO, BoardDAO boardDAO�� �ĸ�Ʈ ��ü�� ������ �ȴ�.
	//�Խñ� ���
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardDO boardDO, BoardDAO boardDAO) {
		boardDAO.insertBoard(boardDO);
		return "getBoardList.do";
	}
	//�Խñ� ����
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardDO boardDO, BoardDAO boardDAO) {
		boardDAO.updateBoard(boardDO);
		return "getBoardList.do";
	}
	
	//�Խñ� ����
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardDO boardDO, BoardDAO boardDAO) {
		boardDAO.deleteBoard(boardDO);
		return "getBoardList.do";
	}
}