package com.company.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class LogoutController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("로그아웃 처리");
		
		//ModelAndView 객체 생성
		ModelAndView mav = new ModelAndView();

		HttpSession session = request.getSession();
		session.invalidate();
					
		System.out.println("로그아웃 성공");
		mav.setViewName("redirect:login.jsp");
		return mav;
	}



}

