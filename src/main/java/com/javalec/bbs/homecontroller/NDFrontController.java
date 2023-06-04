package com.javalec.bbs.homecontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.command.NDCommand;
import com.javalec.bbs.command.NDMainAdminCommand_OKH;
import com.javalec.bbs.command.NDOrdersCheckCommand_OKH;
import com.javalec.bbs.command.NDOrdersGraphCommand_OKH;
import com.javalec.bbs.command.NDOrdersSearchCommand_OKH;
import com.javalec.bbs.command.NDOrdersUpdateCommand_OKH;
import com.javalec.bbs.command.NDUserGraphCommand_OKH;
import com.javalec.bbs.command.NDUserSearchCommand_OKH;

/**
 * Servlet implementation class NDFrontController
 */
@WebServlet("*.do")
public class NDFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NDFrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet");
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost");
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("actionDo");
		request.setCharacterEncoding("utf-8");
		String viewPage = null;
		NDCommand command = null;

		String uri = request.getRequestURI();
		String conPath = request.getContextPath();

		String com = uri.substring(conPath.length());

		switch (com) {

		case "/index.html":
			viewPage = "main.do";
			break;
			
			
		/*
		 * Admin 구역
		 */
		
		//	admin login시,
		case "/admin_login.do":
			viewPage = "admin_main.do";
			break;
			
		//	admin main으로 갈때
		case "/admin_main.do":
			command = new NDMainAdminCommand_OKH();
			command.execute(request, response);
			viewPage = "admin_main.jsp";
			break;

		//	주문 관리
		
		//	admin 주문관리
		case "/admin_searchorders.do":
			command = new NDOrdersSearchCommand_OKH();
			command.execute(request, response);
			viewPage = "admin_orders.jsp";
			break;
		
		//	admin 주문 확인 및 데이터 가져오기
		case "/admin_updateorders.do":
			command = new NDOrdersUpdateCommand_OKH();
			command.execute(request, response);
			viewPage = "admin_orders_update.jsp";
			break;
			
		//	admin 환불 확인 및 배송 확인
		case "/admin_updateorders_checked.do":
			command = new NDOrdersCheckCommand_OKH();
			command.execute(request, response);
			viewPage = "admin_searchorders.do";
			break;
		
		//	admin graph 그릴 자료 넘기기	
		case "/admin_graphorders.do":
			command = new NDOrdersGraphCommand_OKH();
			command.execute(request, response);
			viewPage = "admin_orders_graph.jsp";
			break;
			
		//	유저 관리
			
		//	user 확인
		case "/admin_searchusers.do":
			command = new NDUserSearchCommand_OKH();
			command.execute(request, response);
			viewPage = "admin_user.jsp";
			break;
			
		//	user graph 그릴 자료 넘기기	
		case "/admin_graphusers.do":
			command = new NDUserGraphCommand_OKH();
			command.execute(request, response);
			viewPage = "admin_user_graph.jsp";
			break;
		
			
			
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);

	}

}// END
