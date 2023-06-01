package com.javalec.bbs.homecontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.command.SMainListCommand;
import com.javalec.bbs.command.SMyPageCommand;
import com.javalec.bbs.command.SProductInfoCommand;
import com.javalec.bbs.command.SSalesSearchCommand_OKH;
import com.javalec.bbs.command.SOrderCancelCommand_OKH;
import com.javalec.bbs.command.SOrderCheckCommand_OKH;
import com.javalec.bbs.command.SOrderConfirmCommand_OKH;
import com.javalec.bbs.command.SOrderInfoCommand;
import com.javalec.bbs.command.SOrderInsertCommand;
import com.javalec.bbs.command.SOrderListCommand;
import com.javalec.bbs.command.SOrderListRefundCommand;
import com.javalec.bbs.command.SOrderSearchCommand_OKH;
import com.javalec.bbs.command.SSearchCommand;
import com.javalec.bbs.command.SStockConfirmCommand_OKH;
import com.javalec.bbs.command.SStockDeleteCommand_OKH;
import com.javalec.bbs.command.SStockSearchCommand_OKH;
import com.javalec.bbs.command.SStockUpdateCommand_OKH;
import com.javalec.bbs.command.SUserAdjustmentCommand;
import com.javalec.bbs.command.SUserCartDeleteCommand;
import com.javalec.bbs.command.SUserCartListCommand_LYJ;
import com.javalec.bbs.command.SUserCheckCommand;
import com.javalec.bbs.command.SUserInsertCommand;
import com.javalec.bbs.command.SUserSearchCommand_OKH;
import com.javalec.bbs.command.SUserWithDrawCommand;
import com.javalec.bbs.command.SBasketInsertCommand;
import com.javalec.bbs.command.SMainSearchCommand_OKH;
import com.javalec.bbs.command.SCommand;
import com.javalec.bbs.command.SLogoutCommand_OKH;

/**
 * Servlet implementation class BFrontController
 */
@WebServlet("*.do")
public class MFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SFrontController() {
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
		SCommand command = null;

		String uri = request.getRequestURI();
		String conPath = request.getContextPath();

		String com = uri.substring(conPath.length());

		switch (com) {

		case "/index.html":
			viewPage = "main.do";
			break;

		case "/main.do":
			command = new SMainListCommand();
			command.execute(request, response);
			viewPage = "main.jsp";
			break;
		
			
		// 로그인 영역
		case "/login.do":
			viewPage = "login.jsp";
			break;
		case "/loginCheck.do":
			command = new SSearchCommand();
			command.execute(request, response);
			viewPage = "loginControll.jsp";
			break;
		case "/register.do":
			command = new SUserInsertCommand();
			command.execute(request, response);
			viewPage = "login.do";
			break;
		case "/duplicate.do":
			command = new SUserCheckCommand();
			command.execute(request, response);
			viewPage = "idcheck.jsp";
			break;
			
		//주문목록
		
		
			
		

		// Admin
		// 관리자 메뉴
		case "/adminMain.do":
			command = new SMainSearchCommand_OKH();
			command.execute(request, response);
			viewPage = "admin_main.jsp";
			break;
		case "/adminLogout.do":
			command = new SLogoutCommand_OKH();
			command.execute(request, response);
			viewPage = "main.do";
			break;

		

		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);

	}

} // END
