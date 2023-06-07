package com.javalec.bbs.homecontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.command.NDCommand;
import com.javalec.bbs.command.NDLogoutCommand;
import com.javalec.bbs.command.NDMainAdminCommand_OKH;
import com.javalec.bbs.command.NDMainCommand_KMS;
import com.javalec.bbs.command.NDOrdersCheckCommand_OKH;
import com.javalec.bbs.command.NDOrdersGraphCommand_OKH;
import com.javalec.bbs.command.NDOrdersSearchCommand_OKH;
import com.javalec.bbs.command.NDOrdersUpdateCommand_OKH;
import com.javalec.bbs.command.NDProductListCommand_KMS;
import com.javalec.bbs.command.NDSearchReviewCommand_KMJ;
import com.javalec.bbs.command.NDUserCartListCommand_LYJ;
import com.javalec.bbs.command.NDUserGraphCommand_OKH;
import com.javalec.bbs.command.NDUserLoginCommand;
import com.javalec.bbs.command.NDUserSearchCommand_OKH;
import com.javalec.bbs.command.NDuserCartDeleteCommand;

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

		/*
		 * Main 구역
		 */
		//Home button 클릭시
		case "/main.do":
			command = new NDMainCommand_KMS();
			command.execute(request, response);
			viewPage = "index.jsp";
			break;
		//구독상품 버튼 클릭시
		case "/subscribe.do":
			viewPage = "subscribe.jsp";
			break;
		//일반상품구매 버튼 클릭시 ->product 목록 페이지로 이동
		case "productList.do":
			command = new NDProductListCommand_KMS();
			command.execute(request, response);
			viewPage = "productList.jsp";
			break;
		//찜버튼 클릭시
		case "heart.do":
			viewPage = "heart.jsp";
		// 카트
		case"/cart.do":
			command = new NDUserCartListCommand_LYJ();
			command.execute(request, response);
			viewPage = "shoping-cart.jsp";
			break;
		// 삭제
		case"/cartdelete.do":
			command = new NDuserCartDeleteCommand();
			command.execute(request, response);
			viewPage = "cart.do";
			break;	
			
	
			
			
		//고객센터 버튼 클릭시 ---------------------------민재야 만들어줘
			
		//header-top : 로그인했을 때 : id_session값이 있을 때
		case "/logout.do":
			command = new NDLogoutCommand();
			command.execute(request, response);
			viewPage = "main.do";
			break;
		case "/mypage.do":
			viewPage = "myPage.jsp";
			break;
		//header-top : 로그인안했을 때 : id_session값이 없을 때
		case "/login.do":
			viewPage = "login.jsp";
			break;
		case "/loginCheck.do":
			command = new NDUserLoginCommand();
			command.execute(request, response);
			viewPage = "login.do";
			break;
		case "/registerPage.do":
			// db에서 알러지 정보 불러와야 함
			viewPage = "register.jsp";
			break;
		case "/register.do":
			
			viewPage = "register.jsp";
			break;
		case "/duplicate.do":
			// id 찾아서 중복 체크 해야함
			viewPage = "idDupleCheck.jsp";
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
		
//		게시판 및 상품정보
			
		//  리뷰 불러오기
		case "/board.do":
			command = new NDSearchReviewCommand_KMJ();
			command.execute(request, response);
			viewPage = "shop-board.jsp";
			break;	
			
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);

	}

}// END
