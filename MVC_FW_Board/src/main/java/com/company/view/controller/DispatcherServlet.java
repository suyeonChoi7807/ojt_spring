package com.company.view.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispatcherServlet
 */
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//객체 참조변수 선언(멤버변수)
	private HandlerMapping handlerMapping;
    private ViewResolver viewResolver;
    
    //수동으로 필요 메소드 overiding ! => i입력후 ctrl+ spacebar 누르기 => init() 더블 클릭
    @Override
    public void init() throws ServletException {
    	// 처음 호출되는 메소드
    	// 멤버 변수들 초기화!!
    	handlerMapping = new HandlerMapping(); 
    	viewResolver = new ViewResolver(); //원하는 페이지를 호출하기 위해 생성
    	viewResolver.setPrefix("./");
    	viewResolver.setSuffix(".jsp"); //접두사, 접미사를 미리 결정 set해놓음!
    }
    
    public DispatcherServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		process(request, response);
	}
	
	//사용자 정의 메소드
	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException{
	
		//1. 클라이언트의 요청 path 정보 추출
		//(예) "http://localhost:8080/MVC_FW_Board/login.do" 요청을 가정하여
		String uri = request.getRequestURI(); //"/MVC_FW_Board/login.do" 를 얻어옴 !! 
		int lastPosition = uri.lastIndexOf("/"); //13을 얻어옴
		String filePath = uri.substring(lastPosition); //index 13부터 마지막 문자까지 얻음=> "/login.do"
		
		//2. handler mapping을 통해서  filePath에 해당하는 Controller 를 검색한다.
		Controller ctrl = handlerMapping.getController(filePath); //요청한 컨트롤러를 가져옴
		
		//3. 검색된 controller를 실행한다.
		String viewName = ctrl.handleRequest(request, response); //해당 컨트롤러의 handleRequest메소드를 호출
		
		//4. ViewResolver 를 통해서 viewName에 해당하는 페이지(포워딩)을 검색한다.
		String view = null;
				
		//(예)로그인 성공 시에는 "getBoardList.do" 문자열이 넘어오고,
		//실패시에는 "login" 문자열이 넘어온다.
		
		if(viewName.contains(".do")) {
			view = viewName;
		}else {
			view = viewResolver.getView(viewName);
		}
		
		//5. 페이지 포워딩
		response.sendRedirect(view);
		
	}

}
