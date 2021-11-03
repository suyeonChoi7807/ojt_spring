package com.company.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.annotation.user.UserDAO;
import com.company.annotation.user.UserDO;

@Controller
public class LoginController {   //Controller Ŭ������ POJO Ŭ������ �����Ѵ�!!

	/*
	 * @RequestMapping ������̼��� ��û URL�� � �޼ҵ尡 ó������ ���θ� �����Ѵ�.
	 */
	@RequestMapping("/login.do")
	public String login(UserDO userDO, UserDAO userDAO, HttpSession session) {
		UserDO user = userDAO.getUser(userDO);
		
		if(user != null) {
			session.setAttribute("userName", user.getName());
			System.out.println("�α��� ����");
			return "getBoardList.do";
		}else {
			System.out.println("�α��� ����");
			return "login.jsp";
		}		
	}
}
